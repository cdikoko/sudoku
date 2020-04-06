//this class will have most of the logic to solve the sudoku board as in checking to see if the players move is valid
public class SolveBoard extends boxUtility {

    private Integer[][] board = new Integer[9][9];

    SolveBoard() {
    }

    //this is where some genius is involved my nigga
    public Integer[][] solvedBoard(Board b) {
        this.board = b.getBoard();
        this.solve();
        b.setBoard(this.board);
        return this.board;
    }

//this is a solution to solve the baord using backtracking and it is recursive. lets test how long it takes
    private boolean solve() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                Integer currentValue = board[row][col];
                if (currentValue.equals(0)) {
                    for (int i = 1; i <= 9; i++) {
                        if (isOk(row, col, i)) {
                            board[row][col] = i;

                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }

                    }return false;
                }

            }
        }
        return true;
    }

    private boolean isOk(int row, int col, int i) {
        return !rowExists(board, row, i)
                && !columnExists(board, col, i) &&
                !boxExist(board, row, col, i);
    }


}
