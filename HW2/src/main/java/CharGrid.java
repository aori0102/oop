// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {

    private final char[][] grid;
    private final int row;
    private final int col;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {

        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (ch == grid[i][j]) {

                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    bottom = Math.max(bottom, i);
                    right = Math.max(right, j);

                }

            }

        }

        return (bottom - top + 1) * (right - left + 1);

    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {

        int valid = 0;
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                int left = getEdgeCount(i, j, Direction.Left);
                int right = getEdgeCount(i, j, Direction.Right);
                int up = getEdgeCount(i, j, Direction.Up);
                int down = getEdgeCount(i, j, Direction.Down);
                if (validPlus(up, down, left, right)) {
                    valid++;
                }

            }

        }

        return valid;

    }

    private enum Direction {
        Left,
        Right,
        Up,
        Down
    }

    private boolean validPlus(int upCount, int downCount, int leftCount, int rightCount) {
        return upCount > 1 && leftCount > 1 && upCount == downCount && leftCount == rightCount;
    }

    private int getEdgeCount(int centerRow, int centerColumn, Direction direction) {

        int rowDelta = switch (direction) {
            case Left, Right -> 0;
            case Up -> -1;
            case Down -> 1;
        };
        int columnDelta = switch (direction) {
            case Up, Down -> 0;
            case Left -> -1;
            case Right -> 1;
        };

        int count = 0;
        char ch = grid[centerRow][centerColumn];
        while (isCellValid(centerRow, centerColumn) && grid[centerRow][centerColumn] == ch) {

            centerRow += rowDelta;
            centerColumn += columnDelta;

            count++;

        }

        return count;

    }

    private boolean isCellValid(int row, int column) {
        return row >= 0 && row < this.row && column >= 0 && column < this.col;
    }

}
