
import java.io.FileNotFoundException;

public class Main extends BoardUtility {

    public static void main(String [] args) throws FileNotFoundException {
        Board boards = new Board();
        Integer[][] board = boards.getBoardMap().get(1);

        boards.setBoard(board);
//        printBoard(boards);
        System.out.println(boards);

        SolveBoard solver = new SolveBoard();


        Integer[][] solved = solver.solvedBoard(boards);
        boards.setBoard(solved);
        System.out.println("---------------------------Solved---------------------------------");
        System.out.println(boards);
    }

}
