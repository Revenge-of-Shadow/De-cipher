package com.lonerltd;

import static java.util.HexFormat.*;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

@RequiresApi(api = 34)
public class FromASCIIActivity extends AppCompatActivity {

    Button btStart;
    EditText etInput, etOutput;
    Spinner spMode, spEncoding;
    private String[] modes = {"HEX (NN format [N : 0-F]).", "Numbers (separated by space)."};
    private String[] encodings = {"Windows-1252"};
    ArrayAdapter<String> modeAdapter;
    ArrayAdapter<String> encodingAdapter;
    @RequiresApi(api = 34)
    private char[] getASCIIChars(String source){
        String res = "";

        if(((String)spMode.getSelectedItem()).equals(modes[0])){
            //  HEX
            char prevChar = 0;

            for(int ind = 0; ind < source.length(); ++ind){
                char currChar = source.charAt(ind);

                if ((currChar >= '0' && currChar <= '9') || (currChar >= 'A' && currChar <= 'F')){
                    if(prevChar != 0){
                        res += (char) (fromHexDigit(prevChar)*0x10 + fromHexDigit(currChar));
                        prevChar = 0;
                    }
                    else
                        prevChar = currChar;
                }
                else
                    res += currChar;
            }


        }else{
            //  Digits
            String[] divided = source.split(" ");

            for (int ind = 0; ind < divided.length; ++ind)
                res += (char) Integer.parseInt(divided[ind]);

        }


        return  res.toCharArray();
    }

    View.OnClickListener oclBtStart = view ->  {
        etOutput.setText(new String(getASCIIChars(String.valueOf(etInput.getText()))));
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_asciiactivity);

        btStart = (Button) findViewById(R.id.btFAStart);
        etInput = (EditText) findViewById(R.id.etFAEnter);
        etOutput = (EditText) findViewById(R.id.etFAResult);
        spMode = (Spinner) findViewById(R.id.spFAMode);
        spEncoding = (Spinner) findViewById(R.id.spFAEncoding);

        encodingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, encodings);
        modeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, modes);

        spEncoding.setAdapter(encodingAdapter);
        spMode.setAdapter(modeAdapter);

        btStart.setOnClickListener(oclBtStart);
    }
}