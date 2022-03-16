public class RatInMaze {
    /**
     * @param return true if their exists a path for rat to exit the maze
     */

    public static void main(String[] args) {
        int[][] maze = { { 1, 1, 1, 0 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 } };
        System.out.println(ratInMaze(maze, maze.length));
    }

    public static void printAllPaths(int maze[][], int n, int i, int j, int path[][]) {
        // Check if i,j cell is valid or not
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return;
        }

        // Include the cell in current path
        path[i][j] = 1;

        // Check destination cell
        if (i == n - 1 && j == n - 1) {
            printMatrix(path);
            System.out.println();
            path[i][j] = 0;
            return;
        }

        // Explore further in all direction
        // top
        printAllPaths(maze, n, i - 1, j, path);
        // right
        printAllPaths(maze, n, i, j + 1, path);
        // down
        printAllPaths(maze, n, i + 1, j, path);
        // left
        printAllPaths(maze, n, i, j - 1, path);
        path[i][j] = 0;
    }

    public static boolean ratInMaze(int maze[][], int n) {
        int[][] path = new int[n][n];
        // return solvemaze(maze, n, 0, 0, path);
        printAllPaths(maze, n, 0, 0, path);
        return true;
    }

    public static boolean solvemaze(int maze[][], int n, int i, int j, int path[][]) {
        // Check if i,j cell is valid or not
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }

        // Include the cell in current path
        path[i][j] = 1;

        // Check destination cell
        if (i == n - 1 && j == n - 1) {
            printMatrix(path);
            return true;
        }

        // Explore further in all direction
        // top
        if (solvemaze(maze, n, i - 1, j, path)) {
            return true;
        }

        // right
        if (solvemaze(maze, n, i, j + 1, path)) {
            return true;
        }

        // down
        if (solvemaze(maze, n, i + 1, j, path)) {
            return true;
        }

        // left
        if (solvemaze(maze, n, i, j - 1, path)) {
            return true;
        }

        return false;
    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
