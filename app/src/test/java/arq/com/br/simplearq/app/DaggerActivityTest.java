package arq.com.br.simplearq.app;

import android.app.Activity;
import android.support.v4.app.Fragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import arq.com.br.simplearq.BuildConfig;
import arq.com.br.simplearq.CustomRobolectricRunner;

import static junit.framework.Assert.assertNotNull;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

/**
 * Created by AXM on 04/10/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DaggerActivityTest {
    Activity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(DaggerActivity.class);
    }

    @Test
    public void DaggerActivityNotNull() {
        assertNotNull(activity);
    }

    @Test
    public void addFragmentShouldNotBeNull() {
        Fragment contentFragment = (Fragment) DaggerActivity.contentFragment;
        startFragment(contentFragment);
        assertNotNull(contentFragment);

        Fragment homeFragment = (Fragment) DaggerActivity.homeFragment;
        startFragment(homeFragment);
        assertNotNull(homeFragment);

        Fragment payFragment = (Fragment) DaggerActivity.payFragment;
        startFragment( payFragment );
        assertNotNull( payFragment );
    }
}
