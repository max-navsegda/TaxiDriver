package max.com.taxidriver;

import android.support.multidex.MultiDexApplication;

import max.com.taxidriver.utils.Settings;

/**
 * Created by Maxim on 8/29/2017.
 */

public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Settings.init(this);
    }
}
