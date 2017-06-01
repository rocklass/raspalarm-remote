package org.rocklass.raspalarm.presentation.service;

import org.rocklass.raspalarm.domain.Device;
import org.rocklass.raspalarm.domain.interactor.DefaultObserver;
import org.rocklass.raspalarm.domain.interactor.PutDevice;
import org.rocklass.raspalarm.presentation.callback.MessageCallback;

import javax.inject.Inject;

/**
 * Created by rocklass on 01/06/2017.
 */
public class DeviceServiceController implements ServiceController {
    private final PutDevice putDeviceUseCase;

    @Inject
    public DeviceServiceController(final PutDevice putDeviceUseCase) {
        this.putDeviceUseCase = putDeviceUseCase;
    }

    private MessageCallback messageCallback;

    public void putDevice(final String token) {
        putDeviceUseCase.execute(new DeviceObserver(), PutDevice.Params.forDevice(token));
    }

    public void setMessageCallback(final MessageCallback messageCallback) {
        this.messageCallback = messageCallback;
    }

    private final class DeviceObserver extends DefaultObserver<Device> {
        @Override
        public void onComplete() {
            messageCallback.showMessage("Device registered");
        }

        @Override
        public void onError(final Throwable e) {
            messageCallback.showMessage(e.getMessage());
        }

        @Override
        public void onNext(final Device device) {
            messageCallback.showMessage("Device registered");
        }
    }
}
