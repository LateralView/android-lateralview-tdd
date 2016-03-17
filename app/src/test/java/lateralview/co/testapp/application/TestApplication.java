package lateralview.co.testapp.application;

import android.app.Application;

import com.android.volley.ExecutorDelivery;

import net.lateralview.simplerestclienthandler.RestClientManager;

import java.util.concurrent.Executors;

/**
 * Created by Joaquin on 10/3/16.
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        initializeRestClientManager();
        super.onCreate();
    }

    protected void initializeRestClientManager(){
        RestClientManager.initialize(getApplicationContext(),
                new ExecutorDelivery(Executors.newSingleThreadExecutor())
        ).enableDebugLog(true);
    }
}
