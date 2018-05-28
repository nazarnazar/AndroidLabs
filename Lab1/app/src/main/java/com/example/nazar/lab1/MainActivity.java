package com.example.nazar.lab1;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.activity_main);
        else
            setContentView(R.layout.activity_main_land);
    }

    @Override
    public void onFragmentInteraction(String link) {
        OutputFragment fragment = (OutputFragment) getFragmentManager()
                .findFragmentById(R.id.fragment2);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(link);
        }
    }
}
