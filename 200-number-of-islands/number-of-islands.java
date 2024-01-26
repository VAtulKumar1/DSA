class Solution {
    int[] dRow = {-1,0,1,0};
    int[] dCol = {0,1,0,-1};
    public void dfs(int row,int col,int[][] vis,char[][] grid,int m,int n){
        for(int i=0;i<4;i++){
            int r = row + dRow[i];
            int c = col +dCol[i];
            if(r>=0
                    && r<m
                    && c>=0
                    && c<n
                    && vis[r][c] == 0
                    && grid[r][c] == '1'){
                vis[r][c] = 1;
                dfs(r,c,vis,grid,m,n);
            }
        }
    }
    public int numIslands(char[][] grid) {
         int m = grid.length;
       int n = grid[0].length;

       int[][] vis=new int[m][n];

       for(int i=0; i<m;i++){
           for(int j=0; j<n; j++){
               vis[i][j] = 0;
           }
       }
        int totalIslands = 0;
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
               if(vis[i][j] == 0 && grid[i][j] == '1'){
                   dfs(i,j,vis,grid,m,n);
                   totalIslands++;
               }
            }
        }
        return totalIslands;
    }
}