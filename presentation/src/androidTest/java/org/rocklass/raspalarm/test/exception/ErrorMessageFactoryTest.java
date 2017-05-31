package org.rocklass.raspalarm.test.exception;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rocklass.raspalarm.R;
import org.rocklass.raspalarm.data.exception.NetworkConnectionException;
import org.rocklass.raspalarm.data.exception.UserNotFoundException;
import org.rocklass.raspalarm.presentation.exception.ErrorMessageFactory;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith (AndroidJUnit4.class)
public class ErrorMessageFactoryTest {

    @Test
    public void testNetworkConnectionErrorMessage() {
        final String expectedMessage = getTargetContext().getString(R.string.exception_message_no_connection);
        final String actualMessage = ErrorMessageFactory.create(getTargetContext(), new NetworkConnectionException());

        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }

    @Test
    public void testUserNotFoundErrorMessage() {
        final String expectedMessage = getTargetContext().getString(R.string.exception_message_user_not_found);
        final String actualMessage = ErrorMessageFactory.create(getTargetContext(), new UserNotFoundException());

        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }
}
