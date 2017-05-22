package org.rocklass.raspalarm.presentation;

import android.app.Application;

import org.rocklass.raspalarm.BuildConfig;
import org.rocklass.raspalarm.presentation.internal.di.components.ApplicationComponent;
import org.rocklass.raspalarm.presentation.internal.di.components.DaggerApplicationComponent;
import org.rocklass.raspalarm.presentation.internal.di.modules.ApplicationModule;

import com.squareup.leakcanary.LeakCanary;

/**
 * Android Main Application
 */
public class RaspAlarmRemoteApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}
