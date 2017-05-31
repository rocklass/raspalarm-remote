package org.rocklass.raspalarm.data.repository.datasource;

import android.support.annotation.NonNull;

import org.rocklass.raspalarm.data.cache.UserCache;
import org.rocklass.raspalarm.data.net.UserRestApi;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
@Singleton
public class UserDataStoreFactory {

    private final UserCache userCache;
    private final UserRestApi userRestApi;

    @Inject
    UserDataStoreFactory(@NonNull UserCache userCache, @NonNull UserRestApi userRestApi) {
        this.userCache = userCache;
        this.userRestApi = userRestApi;
    }

    /**
     * Create {@link UserDataStore} from a user id.
     */
    public UserDataStore create(int userId) {
        UserDataStore userDataStore;

        if (!this.userCache.isExpired() && this.userCache.isCached(userId)) {
            userDataStore = new DiskUserDataStore(this.userCache);
        } else {
            userDataStore = createCloudDataStore();
        }

        return userDataStore;
    }

    /**
     * Create {@link UserDataStore} to retrieve data from the Cloud.
     */
    public UserDataStore createCloudDataStore() {
        return new CloudUserDataStore(userRestApi, this.userCache);
    }
}
