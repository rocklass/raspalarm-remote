package org.rocklass.raspalarm.test.exception;

import android.test.AndroidTestCase;

import org.rocklass.raspalarm.R;
import org.rocklass.raspalarm.data.exception.NetworkConnectionException;
import org.rocklass.raspalarm.data.exception.UserNotFoundException;
import org.rocklass.raspalarm.presentation.exception.ErrorMessageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ErrorMessageFactoryTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testNetworkConnectionErrorMessage() {
        String expectedMessage = getContext().getString(R.string.exception_message_no_connection);
        String actualMessage = ErrorMessageFactory.create(getContext(),
                new NetworkConnectionException());

        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }

    public void testUserNotFoundErrorMessage() {
        String expectedMessage = getContext().getString(R.string.exception_message_user_not_found);
        String actualMessage = ErrorMessageFactory.create(getContext(), new UserNotFoundException());

        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }
}
