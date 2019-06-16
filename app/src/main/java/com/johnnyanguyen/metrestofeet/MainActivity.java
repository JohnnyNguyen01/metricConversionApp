package com.johnnyanguyen.metrestofeet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView metresTV;
    private TextView feetTV;
    private EditText metresTxt;
    private EditText feetTxt;
    private Button convertBtn;
    private TextView outputTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link Java to xml attributes [dependency injection]
        metresTV = findViewById(R.id.metresTV);
        feetTV = findViewById(R.id.feetTV);
        metresTxt = findViewById(R.id.metresTxt);
        feetTV = findViewById(R.id.feetTxt);
        convertBtn = findViewById(R.id.convertBtn);
        outputTV = findViewById(R.id.outputTV);

        //handle convertBtn Click
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertMetresToFeet();
            }
        });
    }

    private void convertMetresToFeet(){
        //1 metre = 3.28084 feet
        double metres = Double.parseDouble(metresTxt.getText().toString());
        double feet = metres * 3.8084;
        outputTV.setText(feet + " Feet. (Freedom Units are best Units!)");
        outputTV.setVisibility(View.VISIBLE);
    }

}
