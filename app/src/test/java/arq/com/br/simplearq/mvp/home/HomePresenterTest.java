package arq.com.br.simplearq.mvp.home;

import org.junit.Before;
import org.junit.Test;

import arq.com.br.simplearq.mvp.home.HomePresenter;
import arq.com.br.simplearq.mvp.home.HomeView;
import arq.com.br.simplearq.mvp.home.OnHomeMVP;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by AXM on 01/10/2016.
 */
public class HomePresenterTest {

    OnHomeMVP.OnHomeView view;
    OnHomeMVP.OnHomePresenter presenter;
    private final static float PRICE_TEST = 15.0f;

    @Before
    public void setUp(){
        view = new HomeView();
        presenter = new HomePresenter(view);
    }
    @Test
    public void homeViewIsNotNull(){
        assertNotNull(view);
    }
    @Test
    public void homePresenterNotNull(){
        assertNotNull(presenter);
    }

    @Test
    public void decrementCount(){
        presenter.decrementCoffeeCount();
        assertEquals(0, presenter.getCount());

        presenter.setCount(25);
        presenter.decrementCoffeeCount();
        assertEquals(24, presenter.getCount());
    }

    @Test
    public void incrementCount() {
        presenter.incrementCoffeeCount();
        assertEquals(1, presenter.getCount());
        presenter.setCount(25);
        presenter.incrementCoffeeCount();
        assertEquals(26, presenter.getCount());
    }

    @Test
    public void totalPrice(){
        assertEquals(0.0f, presenter.getTotal());
        presenter.setCount(25);
        assertEquals(PRICE_TEST * 25, presenter.getTotal());
    }


}
