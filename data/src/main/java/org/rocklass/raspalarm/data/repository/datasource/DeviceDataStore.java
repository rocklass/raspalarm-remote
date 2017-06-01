package org.rocklass.raspalarm.data.repository.datasource;

import org.rocklass.raspalarm.data.entity.DeviceEntity;
import org.rocklass.raspalarm.data.entity.UserEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface DeviceDataStore {
    /**
     * Get an {@link Observable} which will emit a {@link DeviceEntity} by its id.
     *
     * @param token The device token.
     */
    Observable<DeviceEntity> deviceEntity(final String token);
}
