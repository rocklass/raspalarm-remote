package org.rocklass.raspalarm.test.mapper;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rocklass.raspalarm.domain.User;
import org.rocklass.raspalarm.presentation.mapper.UserModelDataMapper;
import org.rocklass.raspalarm.presentation.model.UserModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

@RunWith (AndroidJUnit4.class)
public class UserModelDataMapperTest {

    private static final int FAKE_USER_ID = 123;
    private static final String FAKE_FULL_NAME = "Tony Stark";

    private UserModelDataMapper userModelDataMapper;

    @Before
    public void setUp() throws Exception {
        userModelDataMapper = new UserModelDataMapper();
    }

    @Test
    public void testTransformUser() {
        final User user = createFakeUser();
        final UserModel userModel = userModelDataMapper.transform(user);

        assertThat(userModel, is(instanceOf(UserModel.class)));
        assertThat(userModel.getUserId(), is(FAKE_USER_ID));
        assertThat(userModel.getFullName(), is(FAKE_FULL_NAME));
    }

    @Test
    public void testTransformUserCollection() {
        final User mockUserOne = mock(User.class);
        final User mockUserTwo = mock(User.class);

        final List<User> userList = new ArrayList<>(5);
        userList.add(mockUserOne);
        userList.add(mockUserTwo);

        final Collection<UserModel> userModelList = userModelDataMapper.transform(userList);

        assertThat(userModelList.toArray()[0], is(instanceOf(UserModel.class)));
        assertThat(userModelList.toArray()[1], is(instanceOf(UserModel.class)));
        assertThat(userModelList.size(), is(2));
    }

    private User createFakeUser() {
        final User user = new User(FAKE_USER_ID);
        user.setFullName(FAKE_FULL_NAME);

        return user;
    }
}
