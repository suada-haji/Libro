package com.suadahaji.libro.dagger;

import android.app.Application;

/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 4:50 PM.
 */

public class BaseApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = AppComponent.Initializer.init(this);
        /**
         * Use @Inject (to annotate the constructor that Dagger should use) to create instances of a
         * class. When a new instance is requested, Dagger will obtain the required parameters
         * values and invoke this constructor.
         *
         * Interfaces can't be constructed.
         *Third-party classes can't be annotated.
         *Configurable objects must be configured!
         * For these cases where @Inject is insufficient or awkward, use an @Provides-annotated method
         * to satisfy a dependency. The method's return type defines which dependency it satisfies.
         * */
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
