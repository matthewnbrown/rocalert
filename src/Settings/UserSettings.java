package Settings;

import java.util.ArrayList;
import java.util.Map;

public class UserSettings extends Settings {

    private static final String[] settingsNames = { "username", "password", "mintime", "maxtime" };

    public UserSettings () {
        this.SetName("User Settings");
        for (String s: settingsNames) {
            this.AddSetting(s);
        }

        this.SetSetting(settingsNames[2], "0");
        this.SetSetting(settingsNames[3], "0");
    }

    public String GetUsername() {
        return this.GetSetting(settingsNames[0]);
    }

    public String GetPassword() {
        return this.GetSetting(settingsNames[1]);
    }

    public Integer GetMinTime() {
        String time = this.GetSetting(settingsNames[2]);
        return Integer.parseInt(time);
    }

    public Integer GetMaxTime() {
        String time = this.GetSetting(settingsNames[3]);
        return Integer.parseInt(time);
    }

    @Override
    public Boolean SetSetting(String setting, String value) {
        if(setting.equalsIgnoreCase(settingsNames[2]) || setting.equalsIgnoreCase(settingsNames[3])) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
        }
        return super.SetSetting(setting, value);
    }


}
