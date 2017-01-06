package arq.com.br.simplearq.mvp.content;

import android.os.Handler;

/**
 * Created by AXM on 29/09/2016.
 */
public class ContentModel implements OnContentMVP.OnContentModel {

    @Override
    public void callContentModel(final OnContentMVP.OnContentPresenter callback) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                callback.callHome();
            }
        }, 3000);
    }
}
