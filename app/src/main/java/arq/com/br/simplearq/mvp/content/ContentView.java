package arq.com.br.simplearq.mvp.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import javax.inject.Inject;

import arq.com.br.simplearq.R;
import arq.com.br.simplearq.app.ManagerApplication;

/**
 * Created by AXM on 29/09/2016.
 */
public class ContentView extends Fragment implements OnContentMVP.OnContentView{

    OnContentMVP.OnContentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content, container, false);
        presenter = new ContentPresenter(this);
        presenter.callContentPresenter();
        return view;
    }

    @Override
    public void callHome() {
        presenter.replaceFrag(getActivity());
    }
}
