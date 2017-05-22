package org.rocklass.raspalarm.presentation.internal.di.components;

import org.rocklass.raspalarm.presentation.internal.di.PerActivity;
import org.rocklass.raspalarm.presentation.internal.di.modules.ActivityModule;
import org.rocklass.raspalarm.presentation.internal.di.modules.UserModule;
import org.rocklass.raspalarm.presentation.view.fragment.UserDetailsFragment;
import org.rocklass.raspalarm.presentation.view.fragment.UserListFragment;

import dagger.Component;

/**
 * A scope {@link org.rocklass.raspalarm.presentation.internal.di.PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
    void inject(UserListFragment userListFragment);

    void inject(UserDetailsFragment userDetailsFragment);
}
