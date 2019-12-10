package com.excessguru.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.excessguru.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).hide();
            }
            changeFragment(DashBoardFragment.newInstance());
        }
    }
    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);
        transaction.commitNow();

    }

}
