package com.suadahaji.libro.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 4:53 PM.
 *
 * Provides application context dependencies
 */

@Module
public class AppModule {

    private final BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    Context providesApplicationContext() {
        return application.getApplicationContext();
    }


}
