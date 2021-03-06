package org.rocklass.raspalarm.presentation.internal.di.components;

import android.content.Context;

import org.rocklass.raspalarm.domain.executor.PostExecutionThread;
import org.rocklass.raspalarm.domain.executor.ThreadExecutor;
import org.rocklass.raspalarm.domain.repository.DeviceRepository;
import org.rocklass.raspalarm.domain.repository.UserRepository;
import org.rocklass.raspalarm.presentation.internal.di.modules.ApplicationModule;
import org.rocklass.raspalarm.presentation.service.DeviceService;
import org.rocklass.raspalarm.presentation.service.DeviceServiceController;
import org.rocklass.raspalarm.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);
    void inject(DeviceService deviceService);

    //Exposed to sub-graphs.
    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    UserRepository userRepository();

    DeviceRepository deviceRepository();

    DeviceServiceController deviceServiceController();

}
