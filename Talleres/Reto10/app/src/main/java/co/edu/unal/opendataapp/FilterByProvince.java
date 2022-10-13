package co.edu.unal.opendataapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class FilterByProvince extends AppCompatActivity {
    private TextInputEditText textInput;
    private Button filterButton;

    public static String PROVINCE_FILTER = "PROVINCE_FILTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        textInput = (TextInputEditText) findViewById(R.id.provinceInput);
        filterButton = (Button) findViewById(R.id.filterButton);
        FilterByProvince currentActivity = this;
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_create = new Intent(currentActivity, MainActivity.class);
                intent_create.putExtra(FilterByProvince.PROVINCE_FILTER,
                        textInput.getText().toString().trim().toUpperCase());
                startActivity(intent_create);
            }
        });
    }
}
