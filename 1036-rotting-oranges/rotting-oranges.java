class Solution {
    class Pair{
        int row;
        int col;
        int time;

        Pair(int _row,int _col,int _time){
            this.row = _row;
           this.col = _col;
            this.time = _time;
        }
    }


    public  int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        int countFresh = 0;
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j]== 1){
                    countFresh++;
                }
            }
        }
        int maxTime = 0;
        int count = 0;
        int[] dRow = {0,1,0,-1};
        int[] dCol = {1,0,-1,0};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            maxTime =Math.max(maxTime,t);
            q.poll();

            for(int i=0; i<4; i++){
                int row = r + dRow[i];
                int col = c + dCol[i];
                if(row>=0 && row<n && col>=0 && col<m && vis[row][col] == 0 && grid[row][col] == 1){
                    q.add(new Pair(row,col,t+1));
                    vis[row][col] = 2;
                    count++;
                }
            }




        }

        if(count!=countFresh) return -1;

        return maxTime;
    }
}