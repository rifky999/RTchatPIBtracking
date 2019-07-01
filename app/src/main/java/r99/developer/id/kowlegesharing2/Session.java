package r99.developer.id.kowlegesharing2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setusername(String usename) {
        prefs.edit().putString("usename", usename).commit();
    }

    public void setstatus(String status) {
        prefs.edit().putString("status", status).commit();
    }

    public String getusename() {
        String usename = prefs.getString("usename","");
        return usename;
    }

    public String getstatus() {
        String usename = prefs.getString("status","");
        return usename;
    }
}