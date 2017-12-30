package max.com.taxidriver.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import max.com.taxidriver.network.NetworkService;
import max.com.taxidriver.utils.Settings;

/**
 * Created by max on 13.04.17.
 */
public class UpdateOrdersService extends IntentService {
    public static boolean isRun = true;
    public UpdateOrdersService() {
        super("OrdersService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRun) {
                    new NetworkService().getOrders();
                    new NetworkService().getAllAcceptOrders(Settings.currentUser.getPhone());
                    new NetworkService().getProfile(Settings.currentUser.getPhone());
                    try {
                        TimeUnit.SECONDS.sleep(8);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e("RUNSERVICE", "RUNSERVICE");
                }
            }
        }).start();
    }

}
