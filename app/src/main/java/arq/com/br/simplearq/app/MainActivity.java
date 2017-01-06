package arq.com.br.simplearq.app;

import android.os.Bundle;

import arq.com.br.simplearq.R;

public class MainActivity extends DaggerActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();
    }
}
