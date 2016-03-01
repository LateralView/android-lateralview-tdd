package lateralview.co.testapp.modules;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

import lateralview.co.testapp.utils.NetworkApi;

@Module
public class NetworkApiModule {
    @Provides
    @Singleton
    public NetworkApi getNetwork(){
        return new NetworkApi();
    }
}
