package lateralview.co.testapp.application;


import net.lateralview.simplerestclienthandler.RestClientManager;

/**
 * Created by Joaquin on 1/3/16.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        initializeRestClientManager();
        super.onCreate();
    }

    protected void initializeRestClientManager(){
        RestClientManager.initialize(getApplicationContext()).enableDebugLog(true);
    }
}
