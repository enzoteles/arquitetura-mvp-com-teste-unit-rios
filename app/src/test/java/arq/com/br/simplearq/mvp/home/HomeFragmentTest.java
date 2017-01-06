package arq.com.br.simplearq.mvp.home;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import arq.com.br.simplearq.BuildConfig;
import arq.com.br.simplearq.CustomRobolectricRunner;
import arq.com.br.simplearq.R;
import arq.com.br.simplearq.mvp.home.HomeView;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by AXM on 02/10/2016.
 */
@RunWith(CustomRobolectricRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class HomeFragmentTest{

    private HomeView fragment;
    private TextView txtCount;
    private TextView txtTotal;
    private TextView txtPrice;
    private Button btnInc;
    private Button btnDec;


    @Before
    public void setUp(){
        fragment = new HomeView();
        //Start the fragment!
        SupportFragmentTestUtil.startFragment(fragment);
        txtCount = (TextView) fragment.getView().findViewById(R.id.coffee_count);
        txtPrice = (TextView) fragment.getView().findViewById(R.id.coffee_price);
        txtTotal = (TextView) fragment.getView().findViewById(R.id.total_price);
        btnInc = (Button) fragment.getView().findViewById(R.id.coffee_increment);
        btnDec = (Button) fragment.getView().findViewById(R.id.coffee_decrement);

    }

    @Test
    public void homeViewIsNotNull(){
        assertNotNull(fragment);
    }

    @Test
    public void homeViewLabels(){

        Assert.assertNotNull(txtPrice);
        assertEquals(View.VISIBLE, txtPrice.getVisibility());
        assertEquals(fragment.getActivity().getString(R.string.coffee_price, 15.0f), txtPrice.getText());

        Assert.assertNotNull(txtTotal);
        assertEquals(View.VISIBLE, txtTotal.getVisibility());
        assertEquals(fragment.getActivity().getString(R.string.total_price, 0.0f), txtTotal.getText());

        Assert.assertNotNull(txtCount);
        assertEquals(View.VISIBLE, txtCount.getVisibility());
        assertEquals(fragment.getActivity().getString(R.string.default_coffee_count, 0), txtCount.getText());

    }

    @Test
    public void homeViewButtons() {
        Assert.assertNotNull(btnInc);
        assertEquals(View.VISIBLE, btnInc.getVisibility());

        Assert.assertNotNull(btnDec);
        assertEquals(View.VISIBLE, btnDec.getVisibility());
    }

    @Test
    public void homeButtonOnClickIncrement() {
        int count = 0;
        btnInc.performClick();
        assertEquals(String.valueOf(++count), txtCount.getText());
        btnInc.performClick();
    }

    @Test
    public void homeButtonOnClickDecrement() {
        int count = 1;

        btnDec.performClick();
        assertEquals(String.valueOf(--count), txtCount.getText());
        btnInc.performClick();
    }
}














