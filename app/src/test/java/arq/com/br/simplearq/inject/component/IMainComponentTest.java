package arq.com.br.simplearq.inject.component;

import javax.inject.Singleton;

import arq.com.br.simplearq.app.DaggerActivity;
import arq.com.br.simplearq.app.ManagerApplication;
import arq.com.br.simplearq.app.ManagerApplicationTest;
import arq.com.br.simplearq.inject.module.MainModule;
import arq.com.br.simplearq.inject.module.MainModuleTest;
import dagger.Component;

@Singleton
@Component(modules = {MainModuleTest.class})
public interface IMainComponentTest {

    void inject(DaggerActivity activity);

    static final class Initializer {
        private Initializer() {
        }

        public static IMainComponentTest init(ManagerApplicationTest app) {
            return DaggerIMainComponentTest.builder()
                    .mainModuleTest(new MainModuleTest(app))
                    .build();
        }
    }

}
