package org.mperezcastell.impatientclient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by mmpc on 10/10/15.
 */
public class HelloActivity extends Activity {


    @InjectView(R.id.textView)
    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        ButterKnife.inject(this);
        textView.setText(LoginUtility.getUserType(getApplicationContext()));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
