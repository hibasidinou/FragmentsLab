package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class StudentInfoFragment extends Fragment {

    private static final String TAG = "StudentInfoFragment";
    private EditText etName;
    private TextView tvWelcome;
    private Button btnConfirm;

    public StudentInfoFragment() {
        super(R.layout.fragment_student_info);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        etName    = view.findViewById(R.id.etStudentName);
        tvWelcome = view.findViewById(R.id.tvWelcome);
        btnConfirm = view.findViewById(R.id.btnConfirm);

        // Restaurer le texte de bienvenue après rotation
        if (savedInstanceState != null) {
            String saved = savedInstanceState.getString("welcome_text", "");
            tvWelcome.setText(saved);
        }

        btnConfirm.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            if (!name.isEmpty()) {
                tvWelcome.setText("Bienvenue, " + name + " !");
            } else {
                tvWelcome.setText("Veuillez entrer votre nom.");
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (tvWelcome != null) {
            outState.putString("welcome_text", tvWelcome.getText().toString());
        }
    }

    // Cycle de vie — pour debug
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }
}