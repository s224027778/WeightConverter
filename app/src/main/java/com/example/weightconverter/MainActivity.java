package com.example.weightconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    // declare our variables
    double weightInserted;
    double conversionRate = 2.2;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set our text and button properties
        final EditText weightEntered = findViewById(R.id.txtWeight);
        final RadioButton LbToKg = findViewById(R.id.toKilo);
        final RadioButton KgToLb = findViewById(R.id.toPound);
        final TextView conversionResult = findViewById(R.id.txtConvertedWeight);
        Button convert = findViewById(R.id.btnWeight);

        // set on click listener
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // functionality begins here
                weightInserted = Double.parseDouble(weightEntered.getText().toString());
                DecimalFormat roundedTenth = new DecimalFormat("###.##");

                if (LbToKg.isChecked())
                {
                    if (weightInserted <= 500)
                    {
                        convertedWeight = weightInserted / conversionRate;
                        conversionResult.setText(roundedTenth.format(convertedWeight) + "Kilograms");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                    }
                }
                if (KgToLb.isChecked())
                {
                    if (weightInserted <= 225)
                    {
                        convertedWeight = weightInserted * conversionRate;
                        conversionResult.setText(roundedTenth.format(convertedWeight) + "Pounds");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Kilograms must be less than 225", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}