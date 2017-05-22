package org.rocklass.raspalarm.data.repository.datasource;

import org.rocklass.raspalarm.data.entity.UserEntity;

import io.reactivex.Observable;

import java.util.List;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface UserDataStore {
    /**
     * Get an {@link Observable} which will emit a List of {@link UserEntity}.
     */
    Observable<List<UserEntity>> userEntityList();

    /**
     * Get an {@link Observable} which will emit a {@link UserEntity} by its id.
     *
     * @param userId The id to retrieve user data.
     */
    Observable<UserEntity> userEntityDetails(final int userId);
}
