package oleg.hubal.com.tm_homework09;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    private SignInFragment signInFragment;
    private UsersHeadlessFragment usersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();

        if (savedInstanceState == null) {
            commitSignInFragment();
            commitUserHeadlessFragment();
        }
    }

    private void commitUserHeadlessFragment() {
        usersFragment = new UsersHeadlessFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(usersFragment, "users")
                .commit();
    }

    private void initFragment() {
        signInFragment = new SignInFragment();
    }

    private void commitSignInFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, signInFragment)
                .addToBackStack(null)
                .commit();
    }
}
