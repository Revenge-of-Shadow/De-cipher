package com.lonerltd;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.lonerltd.databinding.ActivitySimpleShiftBinding;

public class SimpleShiftActivity extends AppCompatActivity {

    Button btStart;
    EditText etInput, etOutput, etSymbols;
    EditText npShiftVal;

    View.OnClickListener oclBtStart  = view -> {
        String inputText = String.valueOf(etInput.getText()),
                outputText = "",
                symbols = String.valueOf(etSymbols.getText());
        int shiftVal;
        try {
            shiftVal = Integer.parseInt(npShiftVal.getText().toString());
        }catch (Exception e){
            return;
        }

        if(inputText.equals("") || symbols.length() < 2)
            return;

        for(int ind = 0; ind < inputText.length(); ++ind){
            int symb_ind = symbols.indexOf(inputText.charAt(ind));

            if(symb_ind > -1) {
                //  The corresponding symbol is found. Proceed with shifting.
                symb_ind += shiftVal;
                if (symb_ind < 0) {
                    symb_ind = symbols.length() + symb_ind;
                }

                symb_ind %= symbols.length();

                outputText += symbols.charAt(symb_ind);
            }else {
                //  Symbol is not found. Accept it as is.
                outputText += inputText.charAt(ind);
            }
        }

        etOutput.setText(outputText);
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_shift);

        btStart = (Button) findViewById(R.id.btSSStart);
        etInput = (EditText) findViewById(R.id.etSSEnter);
        etOutput = (EditText) findViewById(R.id.etSSResult);
        etSymbols = (EditText) findViewById(R.id.etSSSymbols);
        npShiftVal = (EditText) findViewById(R.id.npSSShiftVal);

        btStart.setOnClickListener(oclBtStart);

    }
}