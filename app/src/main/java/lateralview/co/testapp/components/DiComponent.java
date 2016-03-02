package lateralview.co.testapp.components;

import javax.inject.Singleton;
import dagger.Component;
import lateralview.co.testapp.activities.MainActivity;
import lateralview.co.testapp.modules.EmailValidatorModule;

@Singleton
@Component(modules = {EmailValidatorModule.class})

public interface DiComponent {
    // to update the fields in your activities
    void inject(MainActivity activity);
}
