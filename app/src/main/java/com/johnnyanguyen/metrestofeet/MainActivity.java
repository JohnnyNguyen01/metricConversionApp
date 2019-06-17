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
        feetTxt = findViewById(R.id.feetTxt);
        convertBtn = findViewById(R.id.convertBtn);
        outputTV = findViewById(R.id.outputTV);

        //handle convertBtn Click
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!metresTxt.getText().toString().isEmpty() && feetTxt.getText().toString().isEmpty())
                    convertMetresToFeet();
                else if(metresTxt.getText().toString().isEmpty() && !feetTxt.getText().toString().isEmpty())
                    convertFeetToMetres();
            }
        });
    }

    //on click convertes metres to feet
    private void convertMetresToFeet(){
        //1 metre = 3.28084 feet
        double metres = Double.parseDouble(metresTxt.getText().toString());
        double feet = metres * 3.8084;
        outputTV.setText(doubleFormatter(feet) + " Feet. (Freedom Units are best Units!)");
        outputTV.setVisibility(View.VISIBLE);
    }

    //onclick convertes Feet to metres
    private void convertFeetToMetres(){
        double feet = Double.parseDouble(feetTxt.getText().toString());
        double metres = feet/3.8024;
        outputTV.setText(doubleFormatter(metres) + " Metres. (Non peasants use Metric!)");
        outputTV.setVisibility(View.VISIBLE)
    }

    //format decimals to 2.d.p
    private String doubleFormatter (double value){
        return  String.format("%.2f", value);
    }
}
