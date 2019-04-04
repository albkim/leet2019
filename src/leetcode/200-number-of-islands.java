/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
 are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000

Output: 1


Example 2:
Input:
11000
11000
00100
00011

Output: 3


 */

package leetcode;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if ((grid == null) || (grid.length == 0) || (grid[0].length == 0)) {
            return 0;
        }

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (visited[row][column]) {
                    continue;
                }
                if (grid[row][column] == '1') {
                    dfs(grid, visited, row, column);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int column) {
        if ((row < 0) || (row == grid.length) || (column < 0) || (column == grid[0].length)) {
            return;
        }

        if (visited[row][column]) {
            return;
        }

        visited[row][column] = true;
        if (grid[row][column] == '0') {
            return;
        }

        dfs(grid, visited, row-1, column);
        dfs(grid, visited, row+1, column);
        dfs(grid, visited, row, column-1);
        dfs(grid, visited, row, column+1);
    }
}
