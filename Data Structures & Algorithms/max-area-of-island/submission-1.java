class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int currentArea = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int r = 0; r < row; r++){
            for (int c = 0; c < col; c++){
                if (grid[r][c] == 1){
                    currentArea = dfs(grid,r,c);
                    maxArea = Math.max(maxArea,currentArea);
                }
            }
        }
        return maxArea;
    }
    private int dfs (int[][] grid, int r, int c){
        //Base/Boundary
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }
        //Sink
        grid[r][c] = 0;
        
        int area = 1;
        area += dfs(grid,r-1,c);
        area += dfs(grid,r+1,c);
        area += dfs(grid,r,c-1);
        area += dfs(grid,r,c+1);

        return area;
    }
}
