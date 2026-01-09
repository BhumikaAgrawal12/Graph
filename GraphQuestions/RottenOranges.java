import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        int[][] visited=new int[m][n];
        int cntFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    visited[i][j]=2;
                    q.offer(new int[]{i,j,0});
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }
        int time=0;
        int[] dr={-1,0,1,0};
        int[] dc={0,-1,0,1};
        int cnt=0;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            int t=arr[2];
            time=Math.max(t,time);
            for(int i=0;i<4;i++){
                int row=r+dr[i];
                int col=c+dc[i];
                if(row>=0 && col>=0 && row<m && col<n && grid[row][col]==1 && visited[row][col]==0){
                    q.add(new int[]{row,col,t+1});
                    visited[row][col]=2;
                    cnt++;
                }
            }
        }
        if(cntFresh!=cnt){
            return -1;
        }
        return time;
    }
}
