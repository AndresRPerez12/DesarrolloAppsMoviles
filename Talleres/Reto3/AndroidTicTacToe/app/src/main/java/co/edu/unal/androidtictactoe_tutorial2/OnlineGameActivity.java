package co.edu.unal.androidtictactoe_tutorial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Timestamp;
import java.util.Map;

public class OnlineGameActivity extends AppCompatActivity {

    // Represents the internal state of the game
    private TicTacToeGame mGame;
    // Indicates if the current game is over
    private boolean mGameOver;
    // Various text displayed
    private TextView mInfoTextView;
    private TextView mGameCodeTextView;

    private BoardView mBoardView;

    MediaPlayer mHumanMediaPlayer;
    MediaPlayer mComputerMediaPlayer;

    static final int DIALOG_QUIT_ID = 1;

    boolean isHumanTurn;

    private SharedPreferences mPrefs;

    public static final String EXTRA_MESSAGE = "online_game.ENDPOINT";
    public static final String GAME_CODE = "online_game.GAME_CODE";
    private char mySpaces;
    private String mGameCode;
    private BoardState boardState;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_game);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        mInfoTextView = (TextView) findViewById(R.id.information);
        mGameCodeTextView = (TextView) findViewById(R.id.game_code);
        isHumanTurn = true;
        mGame = new TicTacToeGame();
        mBoardView = (BoardView) findViewById(R.id.board);
        mBoardView.setGame(mGame);
        // Listen for touches on the board
        mBoardView.setOnTouchListener(mTouchListener);
        checkForWinnerAndUpdatePrompts();
        if( getIntent().getStringExtra(EXTRA_MESSAGE).equals("creator") ){
            mySpaces = BoardState.PLAYER_1;
            mGameCode = "" + System.currentTimeMillis();
            mGameCodeTextView.setText("Game Code: " + mGameCode);
            boardState = new BoardState(mGameCode);
            writeNewBoard(boardState);
        }else{
            mySpaces = BoardState.PLAYER_2;
            mGameCode = getIntent().getStringExtra(GAME_CODE);
            mGameCodeTextView.setText("Game Code: " + mGameCode);
            isHumanTurn = false;
            loadNewBoard();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.online_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.single_player:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.create_match:
                return true;
            case R.id.join_match:
                return true;
            case R.id.quit:
                showDialog(DIALOG_QUIT_ID);
                return true;
        }
        return false;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch(id) {
            case DIALOG_QUIT_ID:
                // Create the quit confirmation dialog
                builder.setMessage(R.string.quit_question)
                        .setCancelable(false)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                OnlineGameActivity.this.finish();
                            }
                        })
                        .setNegativeButton(R.string.no, null);
                dialog = builder.create();
                break;
        }
        return dialog;
    }

    // Listen for touches on the board
    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            // Determine which cell was touched
            int col = (int) event.getX() / mBoardView.getBoardCellWidth();
            int row = (int) event.getY() / mBoardView.getBoardCellHeight();
            int location = row * 3 + col;
            if (!mGameOver && isHumanTurn && setMove(TicTacToeGame.HUMAN_PLAYER, location)) {
                setMove(TicTacToeGame.HUMAN_PLAYER, location);
                // If no winner yet, let the computer make a move
                int winner = mGame.checkForWinner();
                if(winner != 0) checkForWinnerAndUpdatePrompts();
                else mInfoTextView.setText(R.string.turn_opponent);
            }
            // So we aren't notified of continued events when finger is moved
            return false;
        }
    };

    private void checkForWinnerAndUpdatePrompts(){
        int winner = mGame.checkForWinner();
        if (winner == 0)
            mInfoTextView.setText(R.string.turn_human);
        else if (winner == 1) {
            mInfoTextView.setText(R.string.result_tie);
            mGameOver = true;
        } else if (winner == 2) {
            mInfoTextView.setText(R.string.result_human_wins);
            mGameOver = true;
        } else {
            mInfoTextView.setText(R.string.result_opponent_wins);
            mGameOver = true;
        }
    }

    private boolean setMove(char player, int location) {
        if (mGame.setMove(player, location)) {
            mBoardView.invalidate(); // Redraw the board
            // Play the sound effect
            if(player == TicTacToeGame.HUMAN_PLAYER) mHumanMediaPlayer.start();
            else mComputerMediaPlayer.start();
            return true;
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHumanMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.humansound);
        mComputerMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.computersound);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHumanMediaPlayer.release();
        mComputerMediaPlayer.release();
    }

    private void writeNewBoard( BoardState boardState ){
        myRef.child("boards").child(boardState.gameId).setValue(boardState);
    }

    private void loadNewBoard(  ){
        myRef.child("boards").child(mGameCode).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Map<String,Object> returnedValue = (Map) task.getResult().getValue();
                    BoardState boardState = new BoardState(mGameCode,
                            (String) returnedValue.get("mBoard"));

                    mGame.setBoardState(boardStateToLocalBoard(boardState.mBoard));
                    mBoardView.invalidate();
                }
            }
        });
    }

    private char[] boardStateToLocalBoard( String boardState ){
        String ret = "";
        for( int i = 0 ; i < boardState.length() ; i ++ ){
            if( boardState.charAt(i) == BoardState.OPEN_SPOT )
                ret = ret + TicTacToeGame.OPEN_SPOT;
            else if( boardState.charAt(i) == mySpaces )
                ret = ret + TicTacToeGame.HUMAN_PLAYER;
            else
                ret = ret + TicTacToeGame.COMPUTER_PLAYER;
        }
        return ret.toCharArray();
    }

}