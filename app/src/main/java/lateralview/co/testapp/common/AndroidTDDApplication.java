package lateralview.co.testapp.common;

import android.app.Application;

import lateralview.co.testapp.components.DaggerDiComponent;
import lateralview.co.testapp.components.DiComponent;

public class AndroidTDDApplication extends Application {
    DiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerDiComponent.builder().build();
    }

    public DiComponent getComponent() {
        return component;
    }
}
