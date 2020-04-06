import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

//this class will read all the boards and be like a factory that the board has access to
abstract class BoardUtility {
    Map<Integer, Integer[][]> readBoardsFromFile() throws FileNotFoundException {
        final String file = "C:\\Users\\King\\Desktop\\WORKSPACE\\src\\files";
        File f = new File(file);

        Scanner scanner = new Scanner(f);
        Map<Integer, Integer[][]> sudokuBoardMap = new TreeMap<>();
        while (scanner.hasNext()) {
            String grid = scanner.next("Grid");
            int key = scanner.nextInt();
            String next = "";
            for (int i = 0; i < 9; i++) {
                next += scanner.next();
            }
            convertStringToSudokuBoard(next);

            sudokuBoardMap.put(key,
                    convertStringToSudokuBoard(next));

        }

        return sudokuBoardMap;
    }

    private Integer[][] convertStringToSudokuBoard(String grid) throws FileNotFoundException {
        String[] split = grid.split("");
        Integer[][] result = new Integer[9][9];
        List<Integer> numbers= new ArrayList<>();

        int index = 0;

        while (index < split.length) {
            String s = split[index];
                Integer value = Integer.parseInt(s);
                numbers.add(value);
                index++;

        }

        int i = 0;
        for(int row = 0 ; row  < result.length; row++){
            for(int col = 0 ; col < result.length; col++){
                result[row][col] = numbers.get(i++);
            }
        }

        return result;
    }


}
