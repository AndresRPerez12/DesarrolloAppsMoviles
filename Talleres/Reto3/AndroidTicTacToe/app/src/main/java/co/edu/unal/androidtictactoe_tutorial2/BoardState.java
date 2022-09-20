package co.edu.unal.androidtictactoe_tutorial2;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class BoardState {

    // Identifier for the game
    public String gameId;

    // State of the board
    public String mBoard;
    public static final int BOARD_SIZE = 9;

    // Characters used to represent the human, computer, and open spots
    public static final char PLAYER_1 = '1';
    public static final char PLAYER_2 = '2';
    public static final char OPEN_SPOT = '-';

    public BoardState(){}

    public BoardState(String gameId){
        this.gameId = gameId;
        mBoard = "";
        for( int i = 0 ; i < BOARD_SIZE ; i ++ ){
            mBoard = mBoard + OPEN_SPOT;
        }
    }

    public BoardState(String gameId, String mBoard){
        this.gameId = gameId;
        this.mBoard = mBoard;
    }

}
