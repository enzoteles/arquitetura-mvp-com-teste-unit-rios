package arq.com.br.simplearq.mvp.home;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by AXM on 29/09/2016.
 */
public interface OnHomeMVP {

    //método da view
    interface OnHomeView{
    }

    //método do presenter
    interface OnHomePresenter{
        void onClickListener(View v);
        void onResume();
        void viewInjectText(TextView txtCount, TextView txtTotal, FragmentActivity activity, Button dec, Button btnDec, Button btnInc);
        void updateTotalPrice();
        void updateCount();
        int getCount();
        void setCount(int count);
        void calculateTotalPrice();
        void incrementCoffeeCount();
        void decrementCoffeeCount();
        float getTotal();
    }

    //método da model
    interface OnHomeModel{
    }

}
