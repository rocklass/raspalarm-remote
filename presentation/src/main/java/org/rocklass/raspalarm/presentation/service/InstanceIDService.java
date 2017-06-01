package org.rocklass.raspalarm.presentation.service;

import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.rocklass.raspalarm.data.entity.DeviceEntity;
import org.rocklass.raspalarm.data.net.DeviceRestApi;
import org.rocklass.raspalarm.domain.Device;
import org.rocklass.raspalarm.domain.User;
import org.rocklass.raspalarm.domain.exception.DefaultErrorBundle;
import org.rocklass.raspalarm.domain.interactor.DefaultObserver;
import org.rocklass.raspalarm.domain.interactor.GetUserDetails;
import org.rocklass.raspalarm.domain.interactor.PutDevice;
import org.rocklass.raspalarm.presentation.presenter.UserDetailsPresenter;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by pbrochado on 19/05/2017.
 */

public class InstanceIDService extends FirebaseInstanceIdService {
    @Inject
    PutDevice putDeviceUseCase;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        final String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        putDevice(refreshedToken);
    }

    private void putDevice(final String token) {
        putDeviceUseCase.execute(new DeviceObserver(), PutDevice.Params.forDevice(token));
    }

    private final class DeviceObserver extends DefaultObserver<Device> {
        @Override
        public void onError(Throwable e) {
            Toast.makeText(InstanceIDService.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNext(final Device device) {
            Toast.makeText(InstanceIDService.this, "Device registered", Toast.LENGTH_LONG).show();
        }
    }
}
