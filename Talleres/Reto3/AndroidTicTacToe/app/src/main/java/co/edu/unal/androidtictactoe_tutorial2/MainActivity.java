package co.edu.unal.androidtictactoe_tutorial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import co.edu.harding.tictactoe.TicTacToeGame;

public class MainActivity extends AppCompatActivity {

    // Represents the internal state of the game
    private TicTacToeGame mGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}