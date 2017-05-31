package org.rocklass.raspalarm.presenter;

import android.content.Context;

import org.mockito.ArgumentMatchers;
import org.mockito.junit.MockitoJUnitRunner;
import org.rocklass.raspalarm.domain.interactor.GetUserList;
import org.rocklass.raspalarm.presentation.mapper.UserModelDataMapper;
import org.rocklass.raspalarm.presentation.presenter.UserListPresenter;
import org.rocklass.raspalarm.presentation.view.UserListView;

import io.reactivex.observers.DisposableObserver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith (MockitoJUnitRunner.class)
public class UserListPresenterTest {

    private UserListPresenter sut;

    @Mock
    private UserListView mockUserListView;
    @Mock
    private GetUserList mockGetUserList;
    @Mock
    private UserModelDataMapper mockUserModelDataMapper;

    @Before
    public void setUp() {
        sut = new UserListPresenter(mockGetUserList, mockUserModelDataMapper);
        sut.setView(mockUserListView);
    }

    @Test
    @SuppressWarnings ("unchecked")
    public void testUserListPresenterInitialize() {
        sut.initialize();

        verify(mockUserListView).hideRetry();
        verify(mockUserListView).showLoading();
        verify(mockGetUserList).execute(any(DisposableObserver.class), ArgumentMatchers.<Void>isNull());
    }
}
