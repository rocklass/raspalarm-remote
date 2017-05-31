package org.rocklass.raspalarm.test.view.activity;

import android.app.Fragment;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rocklass.raspalarm.R;
import org.rocklass.raspalarm.presentation.view.activity.UserListActivity;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith (AndroidJUnit4.class)
public class UserListActivityTest {
    @Rule
    public ActivityTestRule<UserListActivity> rule = new ActivityTestRule<>(UserListActivity.class);

    @Before
    public void setUp() throws Exception {
        rule.launchActivity(createTargetIntent());
    }

    @Test
    public void testContainsUserListFragment() {
        final Fragment userListFragment = rule.getActivity().getFragmentManager().findFragmentById(R.id.fragmentContainer);

        assertThat(userListFragment, is(notNullValue()));
    }

    @Test
    public void testContainsProperTitle() {
        final String actualTitle = rule.getActivity().getTitle().toString().trim();

        assertThat(actualTitle, is("Users List"));
    }

    private Intent createTargetIntent() {
        return UserListActivity.getCallingIntent(getInstrumentation().getTargetContext());
    }
}
