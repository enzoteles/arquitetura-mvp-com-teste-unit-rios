package arq.com.br.simplearq.mvp.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import arq.com.br.simplearq.R;
import arq.com.br.simplearq.app.DaggerActivity;
import arq.com.br.simplearq.app.MainActivity;
import arq.com.br.simplearq.app.ManagerFragment;

/**
 * Created by AXM on 29/09/2016.
 */
public class HomePresenter implements OnHomeMVP.OnHomePresenter {
    OnHomeMVP.OnHomeView view;

    private final static float PRICE_TEST = 15.0f;
    private int count;
    private float total;
    private TextView txtCount;
    private TextView txtTotal;
    private FragmentActivity activity;
    private Button btnDec, btnInc, btnPay;

    public HomePresenter(OnHomeMVP.OnHomeView view) {
        this.view = view;
    }

    @Override
    public void onClickListener(View v) {
        switch (v.getId()){
            case R.id.coffee_increment:
                incrementCoffeeCount();
                updateTotalPrice();
                updateCount();
                break;
            case R.id.coffee_decrement:
                decrementCoffeeCount();
                updateTotalPrice();
                updateCount();
                break;
            case R.id.pay:
                new ManagerFragment(activity)
                        .setFragment((Fragment) DaggerActivity.payFragment)
                        .setTag("pay")
                        .setBackstack(true)
                        .setLayout(R.id.content)
                        .replaceFragment();
                break;

        }
    }
    @Override
    public void updateTotalPrice() {
        txtTotal.setText(String.format(activity.getString(R.string.total_price), getTotal()));
    }

    public void updateCount() {
        txtCount.setText(String.valueOf(getCount()));
    }

    @Override
    public void onResume() {
        count = 0;
        total = 0;
    }

    @Override
    public void viewInjectText(TextView txtCount, TextView txtTotal, FragmentActivity activity, Button dec, Button btnDec, Button btnInc) {
        this.txtCount = txtCount;
        this.txtTotal = txtTotal;
        this.activity = activity;
        this.btnDec = btnDec;
        this.btnInc = btnInc;
        this.btnPay = btnPay;

    }
    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count >= 0) {
            this.count = count;
        }
        calculateTotalPrice();
    }
    @Override
    public void calculateTotalPrice() {
        total = PRICE_TEST * count;
    }
    @Override
    public void incrementCoffeeCount() {

        count++;
        calculateTotalPrice();
    }
    @Override
    public void decrementCoffeeCount() {
        if (count > 0) {
            count--;
            calculateTotalPrice();
        }
    }
    @Override
    public float getTotal() {
        return total;
    }
}
