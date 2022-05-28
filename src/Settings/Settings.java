package Settings;

import java.util.ArrayList;
import java.util.Map;

public abstract class Settings {

    private String name;
    private Map<String, String> settingsList;

    protected void SetName(String name) {
        this.name = name;
    }
    protected Map<String, String> GetSettingsList() {
        return settingsList;
    }

    protected void AddSetting (String s) {
        this.AddSetting(s, "");
    }

    protected void AddSetting (String setting, String value) {
        this.GetSettingsList().put(setting, value);
    }

    public String GetSettingsName() {
        return name;
    }

    public Boolean ContainsSetting(String setting) {
        return this.settingsList.containsKey(setting);
    }

    public Boolean SetSetting(String setting, String value) {
        if(this.ContainsSetting(setting)) {
            this.GetSettingsList().put(setting, value);
            return true;
        }
        return false;
    }

    public String GetSetting(String setting) {
        if(this.ContainsSetting(setting)) {
            return  this.GetSettingsList().get(setting);
        }
        return null;
    }

    public void PrintSettingsList() {
        for (Map.Entry<String, String> entry: settingsList.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
    public void PrintSettings() {
        for (Map.Entry<String, String> entry: settingsList.entrySet()) {
            System.out.printf("%s:%s\n", entry.getKey(), entry.getValue());
        }
    }
}
