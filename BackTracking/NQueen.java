public class NQueen {

    public static void main(String[] args) {
        placeQueens(4);
    }

    public static void placeQueens(int n) {
        int[][] board = new int[n][n];
        findPlace(board, n, 0);

    }

    public static void findPlace(int board[][], int n, int row) {
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Check all colums
        // Check if its safe to place queen
        // If it is safe -> then place queen and move to next row
        for (int j = 0; j < n; j++) {
            if (isBoardSafe(board, row, j)) {
                board[row][j] = 1;
                findPlace(board, n, row);
                board[row][j] = 0;
            }
        }

    }

    public static boolean isBoardSafe(int board[][], int row, int col) {
        int n = board.length;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row + 1; i < n; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        return true;
    }
}
