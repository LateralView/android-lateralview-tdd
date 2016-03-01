package lateralview.co.testapp.application;

import android.app.Application;

import net.lateralview.simplerestclienthandler.RestClientManager;

/**
 * Created by Joaquin on 1/3/16.
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        RestClientManager.initialize(getApplicationContext()).enableDebugLog(true);
        super.onCreate();
    }
}
