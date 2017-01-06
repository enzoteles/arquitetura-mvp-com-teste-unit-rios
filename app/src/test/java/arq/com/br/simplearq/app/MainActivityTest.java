package arq.com.br.simplearq.app;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import arq.com.br.simplearq.BuildConfig;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by AXM on 04/10/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    Activity activity;

    @Before
    public void setUp(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void DaggerActivityNotNull(){
        assertNotNull(activity);
    }
}
