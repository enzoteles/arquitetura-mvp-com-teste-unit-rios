package arq.com.br.simplearq.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import arq.com.br.simplearq.R;

/**
 * Created by AXM on 28/09/2016.
 */
public class ManagerFragment {

    FragmentActivity activity;
    Fragment fragment;
    FragmentTransaction transaction;
    String tag;
    boolean backstack;
    int layout;

    public ManagerFragment(FragmentActivity activity) {
        this.activity = activity;
    }

    public ManagerFragment setFragment(Fragment fragment) {
        this.fragment = fragment;
        return this;
    }

    public ManagerFragment setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public ManagerFragment setBackstack(boolean backstack) {
        this.backstack = backstack;
        return this;
    }

    public ManagerFragment setLayout(int layout) {
        this.layout = layout;
        return this;
    }

    public void addFragment() {
        transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(layout, fragment, tag);
        transaction.commit();
    }

    public void replaceFragment() {
        transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(layout, fragment);
        if (backstack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

}
