class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int maxArea  = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int r = 0; r<row; r++){
            for (int c = 0; c<col ; c++){
                if (grid[r][c]==1){
                    area = dfs(grid,r,c);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
    private int dfs (int[][] grid, int r, int c){
        if (r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0){
            return 0;
        }

        grid[r][c] = 0;
        int area = 1;
        area += dfs(grid,r-1,c);
        area += dfs(grid,r+1,c);
        area += dfs(grid,r,c-1);
        area += dfs(grid,r,c+1); 

        return area; 
        
    } 
}
