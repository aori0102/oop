//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

    private final boolean[][] grid;
    private final int row;
    private final int column;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     *
     * @param grid grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
        row = grid.length;
        column = grid[0].length;
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {

        int firstFreeRow = 0;
        for (int i = 0; i < row; i++) {

            if (!isRowFull(i)) {

                if (firstFreeRow != i) {

                    for (int j = 0; j < column; j++) {
                        grid[firstFreeRow][j] = grid[i][j];
                    }

                }
                firstFreeRow = i;

            }

        }

        for (int i = firstFreeRow; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = false;
            }
        }

    }

    private boolean isRowFull(int row) {

        for (int i = 0; i < column; i++) {

            if (!grid[row][i]) {
                return false;
            }

        }

        return true;

    }

    /**
     * Returns the internal 2d grid array.
     *
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return this.grid;
    }
}
