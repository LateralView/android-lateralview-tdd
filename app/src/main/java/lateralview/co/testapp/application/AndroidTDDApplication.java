package lateralview.co.testapp.application;

import android.app.Application;

import net.lateralview.simplerestclienthandler.RestClientManager;

import lateralview.co.testapp.components.DaggerDiComponent;
import lateralview.co.testapp.components.DiComponent;

public class AndroidTDDApplication extends Application {
    DiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeRestClientManager();
        component = DaggerDiComponent.builder().build();
    }

    public DiComponent getComponent() {
        return component;
    }

    protected void initializeRestClientManager(){
        RestClientManager.initialize(getApplicationContext()).enableDebugLog(true);
    }
}
