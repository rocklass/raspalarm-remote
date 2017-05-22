package org.rocklass.raspalarm.presentation.internal.di.modules;

import android.content.Context;

import org.rocklass.raspalarm.data.cache.UserCache;
import org.rocklass.raspalarm.data.cache.UserCacheImpl;
import org.rocklass.raspalarm.data.executor.JobExecutor;
import org.rocklass.raspalarm.data.repository.UserDataRepository;
import org.rocklass.raspalarm.domain.executor.PostExecutionThread;
import org.rocklass.raspalarm.domain.executor.ThreadExecutor;
import org.rocklass.raspalarm.domain.repository.UserRepository;
import org.rocklass.raspalarm.presentation.RaspAlarmRemoteApplication;
import org.rocklass.raspalarm.presentation.UIThread;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final RaspAlarmRemoteApplication application;

    public ApplicationModule(RaspAlarmRemoteApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    UserCache provideUserCache(UserCacheImpl userCache) {
        return userCache;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
