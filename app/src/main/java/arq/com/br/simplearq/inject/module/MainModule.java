package arq.com.br.simplearq.inject.module;

import android.app.Application;

import javax.inject.Singleton;

import arq.com.br.simplearq.app.ManagerApplication;
import arq.com.br.simplearq.mvp.content.ContentView;
import arq.com.br.simplearq.mvp.content.OnContentMVP;
import arq.com.br.simplearq.mvp.home.HomeView;
import arq.com.br.simplearq.mvp.home.OnHomeMVP;
import arq.com.br.simplearq.mvp.pay.OnPayMVP;
import arq.com.br.simplearq.mvp.pay.PayView;
import dagger.Module;
import dagger.Provides;

/*Um módulo do dagger2 fornece o caminho que constrói os objectos que serão injectados*/
@Module
public class MainModule {

    ManagerApplication app;

    public MainModule(ManagerApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    protected Application provideApplication() {
        return app;
    }

    @Provides // retorna a instancia do objeto
    @Singleton // diz que o objeto é um singleton
    OnContentMVP.OnContentView provideContentView() {
        return new ContentView();
    }

    @Provides // retorna a instancia do objeto
    @Singleton // diz que o objeto é um singleton
    OnHomeMVP.OnHomeView provideHomeView() {
        return new HomeView();
    }

    @Provides // retorna a instancia do objeto
    @Singleton // diz que o objeto é um singleton
    OnPayMVP.OnPayView providePayView() {
        return new PayView();
    }
}
