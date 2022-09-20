package co.edu.unal.androidtictactoe_tutorial2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class JoinGameActivity extends AppCompatActivity {

    private TextInputEditText textInput;
    private Button joinGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_game);
        textInput = (TextInputEditText) findViewById(R.id.gameCodeTextInput);
        joinGameButton = (Button) findViewById(R.id.joinGameButton);
        JoinGameActivity currentActivity = this;
        joinGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_create = new Intent(currentActivity, OnlineGameActivity.class);
                intent_create.putExtra(OnlineGameActivity.EXTRA_MESSAGE, "opponent");
                intent_create.putExtra(OnlineGameActivity.GAME_CODE,
                        textInput.getText().toString().trim());
                startActivity(intent_create);
            }
        });
    }

}