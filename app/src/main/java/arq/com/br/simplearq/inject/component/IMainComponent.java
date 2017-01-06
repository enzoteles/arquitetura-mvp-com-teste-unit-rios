package arq.com.br.simplearq.inject.component;

import javax.inject.Singleton;

import arq.com.br.simplearq.app.DaggerActivity;
import arq.com.br.simplearq.app.MainActivity;
import arq.com.br.simplearq.app.ManagerApplication;
import arq.com.br.simplearq.inject.module.MainModule;
import dagger.Component;

@Singleton
@Component(modules = {MainModule.class})
public interface IMainComponent {

    void inject(DaggerActivity activity);

    static final class Initializer {
        private Initializer() {
        }

        public static IMainComponent init(ManagerApplication app) {
            return DaggerIMainComponent.builder()
                    .mainModule(new MainModule(app))
                    .build();
        }
    }

}
