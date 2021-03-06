package org.rocklass.raspalarm.data.repository.datasource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.rocklass.raspalarm.data.ApplicationTestCase;
import org.rocklass.raspalarm.data.cache.UserCache;
import org.rocklass.raspalarm.data.net.UserRestApi;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class UserDataStoreFactoryTest extends ApplicationTestCase {

    private static final int FAKE_USER_ID = 11;

    private UserDataStoreFactory userDataStoreFactory;

    @Mock
    private UserCache mockUserCache;
    @Mock
    private UserRestApi mockUserRestApi;

    @Before
    public void setUp() {
        userDataStoreFactory = new UserDataStoreFactory(mockUserCache, mockUserRestApi);
    }

    @Test
    public void testCreateDiskDataStore() {
        given(mockUserCache.isCached(FAKE_USER_ID)).willReturn(true);
        given(mockUserCache.isExpired()).willReturn(false);

        UserDataStore userDataStore = userDataStoreFactory.create(FAKE_USER_ID);

        assertThat(userDataStore, is(notNullValue()));
        assertThat(userDataStore, is(instanceOf(DiskUserDataStore.class)));

        verify(mockUserCache).isCached(FAKE_USER_ID);
        verify(mockUserCache).isExpired();
    }

    @Test
    public void testCreateCloudDataStore() {
        given(mockUserCache.isExpired()).willReturn(true);
        given(mockUserCache.isCached(FAKE_USER_ID)).willReturn(false);

        UserDataStore userDataStore = userDataStoreFactory.create(FAKE_USER_ID);

        assertThat(userDataStore, is(notNullValue()));
        assertThat(userDataStore, is(instanceOf(CloudUserDataStore.class)));

        verify(mockUserCache).isExpired();
    }
}
