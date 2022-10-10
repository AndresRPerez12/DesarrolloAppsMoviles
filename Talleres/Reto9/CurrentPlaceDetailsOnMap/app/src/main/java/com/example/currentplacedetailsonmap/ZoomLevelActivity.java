package com.example.currentplacedetailsonmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class ZoomLevelActivity extends AppCompatActivity {

    private TextInputEditText zoomInput;
    private Button zoomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_zoom);
        zoomInput = (TextInputEditText) findViewById(R.id.zoomInput);
        zoomButton = (Button) findViewById(R.id.zoomButton);
    }

    public void clickZoomButton(View view) {
        String zoomLevel = zoomInput.getText().toString().trim();
        try{
            int zoom =Integer.parseInt(zoomLevel);
        }catch (NumberFormatException e){
            Toast toast = Toast.makeText(getApplicationContext(), "Valor no válido", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Intent intent = new Intent(this, MapsActivityCurrentPlace.class);
        intent.putExtra("ZOOM_LEVEL", zoomLevel);
        startActivity(intent);
    }

}
