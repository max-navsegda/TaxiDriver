package max.com.taxidriver.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import max.com.taxidriver.model.User;

/**
 * Created by max on 28.08.2017.
 */

public class Settings {
    public static final String APP_PREFERENCES_USER_PASSWORD = "User_password";
    public static final String APP_PREFERENCES_USER_PHONE = "User_phone";
    public static final String APP_PREFERENCES_ORDER_COORD = "LastUserMarker";
    private static SharedPreferences settings;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_SIMID = "";

    public static User currentUser;

    public static void init(Context context) {
        currentUser = new User();
        settings = getSettings(context);
    }

    public static SharedPreferences getSettings(Context context) {
        Context appContext = context.getApplicationContext();
        if (settings==null) {
            settings = appContext.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        }
        return settings;
    }

    public static SharedPreferences getSettings() {
        return settings;
    }

    public static void init(Bundle savedInstanceState) {
        if (savedInstanceState!=null) {
            currentUser = new User();
            Settings.currentUser.setPassword(savedInstanceState.getString("password"));
            Settings.currentUser.setFirstName(savedInstanceState.getString("firstName"));
            Settings.currentUser.setLastName(savedInstanceState.getString("lastName"));
            Settings.currentUser.setEmail(savedInstanceState.getString("email"));
            Settings.currentUser.setPhone(savedInstanceState.getString("phone"));
            Settings.currentUser.setBalance(savedInstanceState.getInt("balance"));
        }
    }

    public static void save(Bundle outState) {
        outState.putString("firstName", Settings.currentUser.getFirstName());
        outState.putString("lastName", Settings.currentUser.getLastName());
        outState.putString("email", Settings.currentUser.getEmail());
        outState.putString("phone", Settings.currentUser.getPhone());
        outState.putInt("balance", Settings.currentUser.getBalance());
        outState.putString("password", Settings.currentUser.getPassword());
    }
}