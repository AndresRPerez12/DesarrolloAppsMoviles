package co.edu.unal.androidtictactoe_tutorial2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;

public class CreateGameActivity extends AppCompatActivity {

    private TextInputEditText textInput;
    private Button createGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_game);
        textInput = (TextInputEditText) findViewById(R.id.gameCodeTextInput);
        createGameButton = (Button) findViewById(R.id.createGameButton);
        CreateGameActivity currentActivity = this;
        createGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_create = new Intent(currentActivity, OnlineGameActivity.class);
                intent_create.putExtra(OnlineGameActivity.EXTRA_MESSAGE, "creator");
                intent_create.putExtra(OnlineGameActivity.GAME_CODE,
                        textInput.getText().toString().trim());
                startActivity(intent_create);
            }
        });
    }

}