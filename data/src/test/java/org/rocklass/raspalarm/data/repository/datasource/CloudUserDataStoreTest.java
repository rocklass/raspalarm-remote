package org.rocklass.raspalarm.data.repository.datasource;

import org.mockito.junit.MockitoJUnitRunner;
import org.rocklass.raspalarm.data.cache.UserCache;
import org.rocklass.raspalarm.data.entity.UserEntity;
import org.rocklass.raspalarm.data.net.UserRestApi;

import io.reactivex.Observable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith (MockitoJUnitRunner.class)
public class CloudUserDataStoreTest {

    private static final int FAKE_USER_ID = 765;

    private CloudUserDataStore cloudUserDataStore;

    @Mock
    private UserRestApi mockUserRestApi;
    @Mock
    private UserCache mockUserCache;

    @Before
    public void setUp() {
        cloudUserDataStore = new CloudUserDataStore(mockUserRestApi, mockUserCache);
    }

    @Test
    public void testGetUserEntityListFromApi() {
        cloudUserDataStore.userEntityList();
        verify(mockUserRestApi).userEntityList();
    }

    @Test
    public void testGetUserEntityDetailsFromApi() {
        UserEntity fakeUserEntity = new UserEntity();
        Observable<UserEntity> fakeObservable = Observable.just(fakeUserEntity);
        given(mockUserRestApi.userEntityById(FAKE_USER_ID)).willReturn(fakeObservable);

        cloudUserDataStore.userEntityDetails(FAKE_USER_ID);

        verify(mockUserRestApi).userEntityById(FAKE_USER_ID);
    }
}
