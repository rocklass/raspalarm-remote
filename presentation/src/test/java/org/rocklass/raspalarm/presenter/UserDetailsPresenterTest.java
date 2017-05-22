package org.rocklass.raspalarm.presenter;

import android.content.Context;

import org.rocklass.raspalarm.domain.interactor.GetUserDetails;
import org.rocklass.raspalarm.domain.interactor.GetUserDetails.Params;
import org.rocklass.raspalarm.presentation.mapper.UserModelDataMapper;
import org.rocklass.raspalarm.presentation.presenter.UserDetailsPresenter;
import org.rocklass.raspalarm.presentation.view.UserDetailsView;

import io.reactivex.observers.DisposableObserver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith (MockitoJUnitRunner.class)
public class UserDetailsPresenterTest {

    private static final int USER_ID = 1;

    private UserDetailsPresenter userDetailsPresenter;

    @Mock
    private Context mockContext;
    @Mock
    private UserDetailsView mockUserDetailsView;
    @Mock
    private GetUserDetails mockGetUserDetails;
    @Mock
    private UserModelDataMapper mockUserModelDataMapper;

    @Before
    public void setUp() {
        userDetailsPresenter = new UserDetailsPresenter(mockGetUserDetails, mockUserModelDataMapper);
        userDetailsPresenter.setView(mockUserDetailsView);
    }

    @Test
    @SuppressWarnings ("unchecked")
    public void testUserDetailsPresenterInitialize() {
        given(mockUserDetailsView.context()).willReturn(mockContext);

        userDetailsPresenter.initialize(USER_ID);

        verify(mockUserDetailsView).hideRetry();
        verify(mockUserDetailsView).showLoading();
        verify(mockGetUserDetails).execute(any(DisposableObserver.class), any(Params.class));
    }
}
