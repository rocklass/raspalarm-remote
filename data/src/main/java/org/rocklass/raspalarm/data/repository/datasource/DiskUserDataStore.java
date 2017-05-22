package org.rocklass.raspalarm.data.repository.datasource;

import org.rocklass.raspalarm.data.cache.UserCache;
import org.rocklass.raspalarm.data.entity.UserEntity;

import io.reactivex.Observable;

import java.util.List;

/**
 * {@link UserDataStore} implementation based on file system data store.
 */
class DiskUserDataStore implements UserDataStore {

    private final UserCache userCache;

    /**
     * Construct a {@link UserDataStore} based file system data store.
     *
     * @param userCache A {@link UserCache} to cache data retrieved from the api.
     */
    DiskUserDataStore(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override
    public Observable<List<UserEntity>> userEntityList() {
        //TODO: implement simple cache for storing/retrieving collections of users.
        throw new UnsupportedOperationException("Operation is not available!!!");
    }

    @Override
    public Observable<UserEntity> userEntityDetails(final int userId) {
        return this.userCache.get(userId);
    }
}
