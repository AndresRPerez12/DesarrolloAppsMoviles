package co.edu.unal.androidtictactoe_tutorial2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

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