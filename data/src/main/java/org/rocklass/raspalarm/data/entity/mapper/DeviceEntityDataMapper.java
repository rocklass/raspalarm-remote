package org.rocklass.raspalarm.data.entity.mapper;

import org.rocklass.raspalarm.data.entity.DeviceEntity;
import org.rocklass.raspalarm.data.entity.UserEntity;
import org.rocklass.raspalarm.domain.Device;
import org.rocklass.raspalarm.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link DeviceEntity} (in the data layer) to {@link Device} in the
 * domain layer.
 */
@Singleton
public class DeviceEntityDataMapper {

    @Inject
    DeviceEntityDataMapper() {
    }

    /**
     * Transform a {@link DeviceEntity} into an {@link Device}.
     *
     * @param deviceEntity Object to be transformed.
     * @return {@link Device} if valid {@link DeviceEntity} otherwise null.
     */
    public Device transform(final DeviceEntity deviceEntity) {
        Device device = null;
        if (deviceEntity != null) {
            device = new Device(deviceEntity.getToken());
        }
        return device;
    }
}
