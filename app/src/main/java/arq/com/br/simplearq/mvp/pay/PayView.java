package arq.com.br.simplearq.mvp.pay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import arq.com.br.simplearq.R;

/**
 * Created by AXM on 04/10/2016.
 */
public class PayView extends Fragment implements OnPayMVP.OnPayView{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pay, container, false);
        return view;
    }
}
