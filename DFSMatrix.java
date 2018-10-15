public class DFSMatrix {
    public int numIslands(char[][] grid) {
        int number = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    ++number;
                    dfsFlooder(grid, i, j);
                }
            }
        }
        return number;
    }

    public void dfsFlooder(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        } else {
            return;
        }
        if (checkCo(i - 1, j, grid.length, grid[i].length)) {
            dfsFlooder(grid, i - 1, j);
        }
        if (checkCo(i + 1, j, grid.length, grid[i].length)) {
            dfsFlooder(grid, i + 1, j);
        }
        if (checkCo(i, j + 1, grid.length, grid[i].length)) {
            dfsFlooder(grid, i, j + 1);
        }
        if (checkCo(i, j - 1, grid.length, grid[i].length)) {
            dfsFlooder(grid, i, j - 1);
        }
    }

    public boolean checkCo(int i, int j, int len, int wid) {
        if (i >= 0 && i < len && j >= 0 && j < wid) {
            return true;
        }
        return false;
    }
}
