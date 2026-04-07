package com.example.fragmentslab;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFrag1 = findViewById(R.id.btnGoFragment1);
        Button btnFrag2 = findViewById(R.id.btnGoFragment2);

        // Afficher le premier fragment par défaut
        if (savedInstanceState == null) {
            replaceFragment(new StudentInfoFragment());
        }

        btnFrag1.setOnClickListener(v -> replaceFragment(new StudentInfoFragment()));
        btnFrag2.setOnClickListener(v -> replaceFragment(new GradeFragment()));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}