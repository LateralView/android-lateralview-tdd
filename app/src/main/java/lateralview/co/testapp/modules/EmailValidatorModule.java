package lateralview.co.testapp.modules;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

import lateralview.co.testapp.utils.EmailValidator;

@Module
public class EmailValidatorModule {
    @Provides
    @Singleton
    public EmailValidator provideEmailValidator() {
        return new EmailValidator();
    }
}
