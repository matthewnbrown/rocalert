package Settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class SettingsLoader {
    private static Boolean ValidSetting(Settings settings, String[] dataLines) {

        if(dataLines.length < 2) {
            System.out.printf("Warning: %s %s has no field.\n", settings.GetSettingsName(), dataLines[0]);
            return false;
        }
        if(!settings.ContainsSetting(dataLines[0].toLowerCase())) {
            System.out.printf("Warning: %s has no setting %s.\n", settings.GetSettingsName(), dataLines[0]);
            return false;
        }

        return true;
    }

    public static void LoadSettings(Settings settings,String filename) throws FileNotFoundException {
        File f = new File(filename);

        try {
            Scanner scanner = new Scanner(f);
            while(scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] dataLines =  data.split(":", 2);

                dataLines[0] = dataLines[0].toLowerCase();
                if(!ValidSetting(settings, dataLines)) {
                    continue;
                }

                String setting = dataLines[0];
                String field = dataLines[1];

                settings.SetSetting(setting, field);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
