package arq.com.br.simplearq.mvp.content;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by AXM on 29/09/2016.
 */
public interface OnContentMVP {

    //método da view
    interface OnContentView{
        void callHome();
    }

    //método do presenter
    interface OnContentPresenter{
        void callContentPresenter();
        void callHome();
        void replaceFrag(FragmentActivity activity);
    }

    //método da model
    interface OnContentModel{

        void callContentModel(OnContentPresenter callback);
    }

}
