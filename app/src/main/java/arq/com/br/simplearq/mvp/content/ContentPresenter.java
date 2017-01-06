package arq.com.br.simplearq.mvp.content;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import arq.com.br.simplearq.R;
import arq.com.br.simplearq.app.MainActivity;
import arq.com.br.simplearq.app.ManagerFragment;

/**
 * Created by AXM on 29/09/2016.
 */
public class ContentPresenter implements OnContentMVP.OnContentPresenter {

    OnContentMVP.OnContentView view;
    OnContentMVP.OnContentModel model;

    public ContentPresenter(OnContentMVP.OnContentView view) {
        this.view = view;
        model = new ContentModel();
    }

    @Override
    public void callContentPresenter() {
        model.callContentModel(this);
    }

    @Override
    public void callHome() {
        view.callHome();

    }

    @Override
    public void replaceFrag(FragmentActivity activity) {

        new ManagerFragment(activity)
                .setFragment((Fragment) MainActivity.homeFragment)
                .setTag("home")
                .setBackstack(false)
                .setLayout(R.id.content)
                .replaceFragment();


    }
}
