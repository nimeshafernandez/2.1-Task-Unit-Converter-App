package com.example.activity11;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private TextView resultText;
    private Button convertButton;
    private Spinner unitFromSpinner, unitToSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.input_value);
        resultText = findViewById(R.id.result_text);
        convertButton = findViewById(R.id.convert_button);
        unitFromSpinner = findViewById(R.id.unit_from_spinner);
        unitToSpinner = findViewById(R.id.unit_to_spinner);

        // Set up spinner adapters with unit types
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unit_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitFromSpinner.setAdapter(adapter);
        unitToSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void convertUnits() {
        String input = inputValue.getText().toString();
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input);
            String unitFrom = unitFromSpinner.getSelectedItem().toString();
            String unitTo = unitToSpinner.getSelectedItem().toString();

            // Conversion logic for inches to centimeters as an example
            double result = 0;
            if (unitFrom.equals("Inches") && unitTo.equals("Centimeters")) {
                result = value * 2.54; // Convert inches to cm
            }
            resultText.setText(getString(R.string.result_label) + " " + result);
        } else {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
        }
    }
}
