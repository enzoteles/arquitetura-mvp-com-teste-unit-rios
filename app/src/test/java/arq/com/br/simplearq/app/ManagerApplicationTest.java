package arq.com.br.simplearq.app;

import android.app.Application;

import arq.com.br.simplearq.inject.component.IMainComponent;
import arq.com.br.simplearq.inject.component.IMainComponentTest;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by AXM on 29/09/2016.
 */
public class ManagerApplicationTest extends Application {

    private static IMainComponentTest graph;
    private static ManagerApplicationTest instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        buildComponentGraph();
    }

    public static IMainComponentTest component() {
        return graph;
    }

    public static void buildComponentGraph() {
        graph = IMainComponentTest.Initializer.init(instance);
    }

}
