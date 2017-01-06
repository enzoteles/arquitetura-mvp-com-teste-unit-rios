package arq.com.br.simplearq.app;

import android.app.Application;

import arq.com.br.simplearq.inject.component.IMainComponent;

/**
 * Created by AXM on 29/09/2016.
 */
public class ManagerApplication extends Application {

    private static IMainComponent graph;
    private static ManagerApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        buildComponentGraph();
    }

    public static IMainComponent component() {
        return graph;
    }

    public static void buildComponentGraph() {
        graph = IMainComponent.Initializer.init(instance);
    }

}
