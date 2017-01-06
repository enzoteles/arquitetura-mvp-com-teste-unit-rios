package arq.com.br.simplearq.mvp.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import arq.com.br.simplearq.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by AXM on 29/09/2016.
 */
public class HomeView extends Fragment implements OnHomeMVP.OnHomeView, View.OnClickListener{

    private OnHomeMVP.OnHomePresenter presenter;
    @InjectView(R.id.coffee_count)
    TextView txtCount;
    @InjectView(R.id.coffee_price)
    TextView txtPrice;
    @InjectView(R.id.total_price)
    TextView txtTotal;
    @InjectView(R.id.coffee_increment)
    Button btnInc;
    @InjectView(R.id.coffee_decrement)
    Button btnDec;
    @InjectView(R.id.pay)
    Button btnPay;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        ButterKnife.inject(this, view);
        presenter = new HomePresenter(this);
        presenter.onResume();

        //insert textview
        txtPrice.setText(String.format(getString(R.string.coffee_price), 15.0f));
        txtTotal.setText(String.format(getString(R.string.total_price), 0.0f));
        //Onclick
        btnDec.setOnClickListener(this);
        btnInc.setOnClickListener(this);
        btnPay.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        presenter.viewInjectText(txtCount, txtTotal, getActivity(), btnDec, btnInc, btnPay);
        presenter.onClickListener(v);
    }
}
