package org.rocklass.raspalarm.data.repository.datasource;

import org.rocklass.raspalarm.data.cache.UserCache;
import org.rocklass.raspalarm.data.entity.UserEntity;
import org.rocklass.raspalarm.data.net.UserRestApi;

import io.reactivex.Observable;

import java.util.List;

/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
class CloudUserDataStore implements UserDataStore {

    private final UserRestApi userRestApi;
    private final UserCache userCache;

    /**
     * Construct a {@link UserDataStore} based on connections to the api (Cloud).
     *
     * @param userRestApi   The {@link UserRestApi} implementation to use.
     * @param userCache A {@link UserCache} to cache data retrieved from the api.
     */
    CloudUserDataStore(final UserRestApi userRestApi, UserCache userCache) {
        this.userRestApi = userRestApi;
        this.userCache = userCache;
    }

    @Override
    public Observable<List<UserEntity>> userEntityList() {
        return this.userRestApi.userEntityList();
    }

    @Override
    public Observable<UserEntity> userEntityDetails(final int userId) {
        return this.userRestApi.userEntityById(userId).doOnNext(CloudUserDataStore.this.userCache::put);
    }
}
