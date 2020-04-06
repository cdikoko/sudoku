import java.util.*;
import java.util.stream.Collectors;

/**
 * BOX TL  = row 0-2, col 0-2
 * BOX TM  = row 0-2, col 3-5
 * BOX TR  = row 0-2, col 6-8
 * <p>
 * BOX ML  = row 3-5, col 0-2
 * BOX MM  = row 3-5, col 3-5
 * BOX MR  = row 3-5, col 6-8
 * <p>
 * BOX BL  = row 6-8, col 0-2
 * BOX BM  = row 6-8, col 3-5
 * BOX BR  = row 6-8, col 6-8
 */
public abstract class boxUtility {

    private Map<String, List<Integer>> boxMap = new TreeMap<>();

    Map<String, List<Integer>> setBoxMap() {
        //im gonna make the ending values one more cause the if statement is if < 3 *the value above the end* in other class
        this.boxMap.put("TL", List.of(0, 2, 0, 2));
        this.boxMap.put("TM", List.of(0, 2, 3, 5));
        this.boxMap.put("TR", List.of(0, 2, 6, 8));

        this.boxMap.put("ML", List.of(3, 5, 0, 2));
        this.boxMap.put("MM", List.of(3, 5, 3, 5));
        this.boxMap.put("MR", List.of(3, 5, 6, 8));

        this.boxMap.put("BL", List.of(6, 8, 0, 2));
        this.boxMap.put("BM", List.of(6, 8, 3, 5));
        this.boxMap.put("BR", List.of(6, 8, 6, 8));
        return this.boxMap;
    }

    String determineBox(int row, int col) {
        String vertical = geniusSwitch(row);
        String horizontal = geniusSwitch(col + 10);
        return vertical + horizontal;
    }


    boolean rowExists(Integer[][] board, int row, int value) {

        for (int col = 0; col < board.length; col++) {
            if (board[row][col] == value) {
                return true;
            }
        }
        return false;
    }


    boolean columnExists(Integer[][] board, int c, int value) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][c] == value) {
                return true;
            }
        }
        return false;
    }

    boolean boxExist(Integer[][] board, int row, int col, int value) {
        Map<String, List<Integer>> map = setBoxMap();
        List<Integer> bounds = map.get(determineBox(row, col));
        if (bounds == null) throw new RuntimeException("couldnt determine box");

        int startRow = bounds.get(0);
        int endRow = bounds.get(1);
        int startCol = bounds.get(2);
        int endCol = bounds.get(3);
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if(r >= startRow && r <= endRow && c >= startCol && c <= endCol && board[r][c]==value){
                    return true;
                }
            }
        }
        return false;

    }

    private String geniusSwitch(int val) {
        switch (val) {
            case 0:
            case 1:
            case 2:
                return "T";
            case 3:
            case 4:
            case 5:
                return "M";

            case 6:
            case 7:
            case 8:
                return "B";
            case 10:
            case 11:
            case 12:
                return "L";
            case 13:
            case 14:
            case 15:
                return "M";

            case 16:
            case 17:
            case 18:
                return "R";
            default:
                return "";
        }

    }
}
