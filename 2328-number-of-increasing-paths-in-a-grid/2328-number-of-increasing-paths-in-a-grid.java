class Solution {
     int max = -1;
    int min = Integer.MAX_VALUE;
    int ii = -1, jj = -1;
    int mod = 1000000007;
    int[][] dp;
    int[][] visited;
    int trav(int[][] grid, int i, int j){
        if(grid[i][j] == max ){
            dp[i][j] = 1; return 1;
        }
        if(visited[i][j] == 1) return dp[i][j];

        visited[i][j] = 1;
        
        int up = 0, left = 0, right = 0, down = 0;
        int res = 1;
        if( i+1 < grid.length && grid[i+1][j] > grid[i][j]){
            if(dp[i+1][j] == -1) res = (res + trav(grid, i+1, j)) % mod;
            else res += dp[i+1][j];
        }
        if(i >= 1 && grid[i-1][j] > grid[i][j]){
            if(dp[i-1][j] == -1) res = (res + trav(grid, i-1, j)) % mod;
            else res += dp[i-1][j];
        }
        if( j+1 < grid[0].length && grid[i][j+1] > grid[i][j]){
            if(dp[i][j+1] == -1) res = (res+ trav(grid, i, j+1)) % mod ;
            else res += dp[i][j+1];
        }
        if(j >= 1 && grid[i][j-1] > grid[i][j]){
            if(dp[i][j-1] == -1) res = (res + trav(grid, i, j-1)) % mod;
            else res += dp[i][j-1] ;
        }
        dp[i][j] = res % mod;
        return dp[i][j];

    }
    public int countPaths(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        visited = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(visited[i], -1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j] != 1){
                    trav(grid, i, j);
                }
            }
        }
        int sum = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum = (sum + dp[i][j]) % mod;
            }
        } 
        return sum;

    }
}