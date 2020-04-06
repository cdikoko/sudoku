import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

public class Board extends BoardUtility {

    private final int size = 9;
    private  Integer[][] board = new Integer[9][9];
    private  Map<Integer, Integer[][]> boardMap = new TreeMap<>();
//-----------------------------CONSTRUCTOR--------------------------------//

    Board() throws FileNotFoundException {
        boardMap = super.readBoardsFromFile();

    }
//-----------------------------Getters And Setters / ToString --------------------------------//


    public Map<Integer, Integer[][]> getBoardMap() {
        return boardMap;
    }

    public void setBoardMap(Map<Integer, Integer[][]> boardMap) {
        this.boardMap = boardMap;
    }

    public int getSize() {
        return size;
    }

    private String displayBoard() {
        StringBuffer result = new StringBuffer();
        for (int row = 0; row < size; row++) {
            if (row % 3 == 0 && row > 1) result.append(" -----------------------\n");

            for (int col = 0; col < size; col++) {
                if (col % 3 == 0 && col > 1) result.append(" | ");

                result.append(" " + this.board[row][col]);

                if (col == 8) result.append("\n");

            }

        }
        return String.valueOf(result);
    }


    void setBoard(Integer[][] board) {
        this.board = board;
    }

    Integer[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return displayBoard();
    }
}
