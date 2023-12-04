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

public class ReplacementActivity extends AppCompatActivity {

    Button btStart, btSwap;
    EditText etInput, etOutput, etOSymbols, etSymbols;

    View.OnClickListener oclBtStart  = view -> {
        String inputText = String.valueOf(etInput.getText()),
                outputText = "",
                osymbols = String.valueOf(etOSymbols.getText()),
                symbols = String.valueOf(etSymbols.getText());


        if(inputText.equals("") || symbols.length() < 2 || osymbols.length() < 2)
            return;

        for(int ind = 0; ind < inputText.length(); ++ind){
            int symb_ind = symbols.indexOf(inputText.charAt(ind));

            if(symb_ind > -1) {
                //  The corresponding symbol is found. Proceed with replacement.
                outputText += osymbols.charAt(symb_ind);
            }else {
                //  Symbol is not found. Accept it as is.
                outputText += inputText.charAt(ind);
            }
        }

        etOutput.setText(outputText);
    };

    View.OnClickListener oclBtSwap = view ->{
        String osymbols = String.valueOf(etOSymbols.getText());
        etOSymbols.setText(etSymbols.getText());
        etSymbols.setText(osymbols);
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replacement);

        btStart = (Button) findViewById(R.id.btRStart);
        btSwap = (Button) findViewById(R.id.btRSwap);
        etInput = (EditText) findViewById(R.id.etREnter);
        etOutput = (EditText) findViewById(R.id.etRResult);
        etOSymbols = (EditText) findViewById(R.id.etROSymbols);
        etSymbols = (EditText) findViewById(R.id.etRSymbols);

        btStart.setOnClickListener(oclBtStart);
        btSwap.setOnClickListener(oclBtSwap);

    }
}