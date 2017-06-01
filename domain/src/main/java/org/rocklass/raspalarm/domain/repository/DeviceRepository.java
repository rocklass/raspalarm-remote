package org.rocklass.raspalarm.domain.repository;

import org.rocklass.raspalarm.domain.Device;
import org.rocklass.raspalarm.domain.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting {@link Device} related data.
 */
public interface DeviceRepository {
    /**
     * Get an {@link Observable} which will emit a {@link Device}.
     *
     * @param token The token used to retrieve device data.
     */
    Observable<Device> device(final String token);
}
