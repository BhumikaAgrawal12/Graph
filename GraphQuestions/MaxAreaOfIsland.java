public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int c=dfs(grid,i,j);
                    maxArea=Math.max(c,maxArea);
                }
            }
        }
        return maxArea;
    }
    int dfs(int[][] grid,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){
            return 0;
        }
        grid[r][c]=0;
        int cnt=1;
        cnt+=dfs(grid,r+1,c);
        cnt+=dfs(grid,r,c+1);
        cnt+=dfs(grid,r-1,c);
        cnt+=dfs(grid,r,c-1);
        return cnt;
    }
}
