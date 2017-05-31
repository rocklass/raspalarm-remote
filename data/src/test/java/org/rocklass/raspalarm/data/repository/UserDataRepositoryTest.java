package org.rocklass.raspalarm.data.repository;

import org.mockito.junit.MockitoJUnitRunner;
import org.rocklass.raspalarm.data.entity.UserEntity;
import org.rocklass.raspalarm.data.entity.mapper.UserEntityDataMapper;
import org.rocklass.raspalarm.data.repository.datasource.UserDataStore;
import org.rocklass.raspalarm.data.repository.datasource.UserDataStoreFactory;
import org.rocklass.raspalarm.domain.User;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

@RunWith (MockitoJUnitRunner.class)
public class UserDataRepositoryTest {

    private static final int FAKE_USER_ID = 123;

    private UserDataRepository userDataRepository;

    @Mock
    private UserDataStoreFactory mockUserDataStoreFactory;
    @Mock
    private UserEntityDataMapper mockUserEntityDataMapper;
    @Mock
    private UserDataStore mockUserDataStore;
    @Mock
    private UserEntity mockUserEntity;
    @Mock
    private User mockUser;

    @Before
    public void setUp() {
        userDataRepository = new UserDataRepository(mockUserDataStoreFactory, mockUserEntityDataMapper);
        given(mockUserDataStoreFactory.create(anyInt())).willReturn(mockUserDataStore);
        given(mockUserDataStoreFactory.createCloudDataStore()).willReturn(mockUserDataStore);
    }

    @Test
    public void testGetUsersHappyCase() {
        List<UserEntity> usersList = new ArrayList<>();
        usersList.add(new UserEntity());
        given(mockUserDataStore.userEntityList()).willReturn(Observable.just(usersList));

        userDataRepository.users();

        verify(mockUserDataStoreFactory).createCloudDataStore();
        verify(mockUserDataStore).userEntityList();
    }

    @Test
    public void testGetUserHappyCase() {
        UserEntity userEntity = new UserEntity();
        given(mockUserDataStore.userEntityDetails(FAKE_USER_ID)).willReturn(Observable.just(userEntity));
        userDataRepository.user(FAKE_USER_ID);

        verify(mockUserDataStoreFactory).create(FAKE_USER_ID);
        verify(mockUserDataStore).userEntityDetails(FAKE_USER_ID);
    }
}
