class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int r = 0; r < row; r++){
            for (int c = 0; c < col; c++){
                if (grid[r][c] == '1'){
                    count++;
                    dfs(grid,r,c);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r, int c){
        //Boundary/Base case
        if (r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!='1'){
            return;
        }
        grid[r][c] = '0'; //Mark Visited

        //Recurse/Traverse
        dfs(grid,r-1,c); //up
        dfs(grid,r+1,c); //down
        dfs(grid,r,c-1); //left
        dfs(grid,r,c+1); //right
    }
}
