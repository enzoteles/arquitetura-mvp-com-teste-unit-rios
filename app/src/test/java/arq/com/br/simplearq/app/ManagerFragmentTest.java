package arq.com.br.simplearq.app;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import arq.com.br.simplearq.BuildConfig;
import arq.com.br.simplearq.R;

/**
 * Created by AXM on 28/09/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ManagerFragmentTest {

    private FragmentActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(DaggerActivity.class);
    }


    @Test
    public void testAddFragment(){

        Fragment fragment = (Fragment) DaggerActivity.contentFragment;
        android.support.v4.app.FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add( fragment, null );
        fragmentTransaction.commit();
    }

    @Test
    public void testReplaceFragment(){

        Fragment fragment = (Fragment) DaggerActivity.contentFragment;
        android.support.v4.app.FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
    }
}
