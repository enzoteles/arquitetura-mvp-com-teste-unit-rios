package arq.com.br.simplearq.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import arq.com.br.simplearq.R;
import arq.com.br.simplearq.mvp.content.OnContentMVP;
import arq.com.br.simplearq.mvp.home.OnHomeMVP;
import arq.com.br.simplearq.mvp.pay.OnPayMVP;

/**
 * Created by AXM on 29/09/2016.
 */
public class DaggerActivity extends AppCompatActivity {

    @Inject
    public static OnContentMVP.OnContentView contentFragment;
    @Inject
    public static OnHomeMVP.OnHomeView homeFragment;
    @Inject
    public static OnPayMVP.OnPayView payFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ManagerApplication.component().inject(this);
    }

    public void addFragment() {
        new ManagerFragment(this)
                .setFragment((Fragment) contentFragment)
                .setTag("content")
                .setLayout(R.id.content)
                .addFragment();
    }
}
