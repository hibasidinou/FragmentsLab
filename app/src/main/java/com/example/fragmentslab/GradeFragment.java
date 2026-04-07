package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class GradeFragment extends Fragment {

    private TextView tvGradeDisplay;
    private TextView tvMention;
    private SeekBar seekGrade;
    private int currentGrade = 0;
    private static final String KEY_GRADE = "grade_value";

    public GradeFragment() {
        super(R.layout.fragment_grade);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvGradeDisplay = view.findViewById(R.id.tvGradeDisplay);
        tvMention      = view.findViewById(R.id.tvMention);
        seekGrade      = view.findViewById(R.id.seekGrade);

        // Restaurer la note après rotation
        if (savedInstanceState != null) {
            currentGrade = savedInstanceState.getInt(KEY_GRADE, 0);
            seekGrade.setProgress(currentGrade);
            updateDisplay(currentGrade);
        }

        seekGrade.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentGrade = progress;
                updateDisplay(progress);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void updateDisplay(int grade) {
        tvGradeDisplay.setText("Note : " + grade + " / 20");

        String mention;
        if (grade >= 16) {
            mention = "Très bien ";
        } else if (grade >= 14) {
            mention = "Bien ";
        } else if (grade >= 12) {
            mention = "Assez bien";
        } else if (grade >= 10) {
            mention = "Passable";
        } else {
            mention = "Insuffisant ";
        }
        tvMention.setText("Mention : " + mention);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_GRADE, currentGrade);
    }
}
