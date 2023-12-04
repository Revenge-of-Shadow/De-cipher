package com.lonerltd;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

@RequiresApi(api = 34)
public class MainActivity extends AppCompatActivity {

    Button btShift, btReplace, btFromASCII;
    View.OnClickListener oclBtShiftSimple = view -> {
        Intent intent = new Intent(getApplicationContext(), SimpleShiftActivity.class);
        startActivity(intent);
    };
    View.OnClickListener oclBtFromASCII = view -> {
        Intent intent = new Intent(getApplicationContext(), FromASCIIActivity.class);
        startActivity(intent);
    };
    View.OnClickListener oclBtReplace = view -> {
        Intent intent = new Intent(getApplicationContext(), ReplacementActivity.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShift = (Button) findViewById(R.id.btShift);
        btReplace = (Button) findViewById(R.id.btReplace);
        btFromASCII = (Button) findViewById(R.id.btFromASCII);


        btShift.setOnClickListener(oclBtShiftSimple);
        btReplace.setOnClickListener(oclBtReplace);
        btFromASCII.setOnClickListener(oclBtFromASCII);

    }
}