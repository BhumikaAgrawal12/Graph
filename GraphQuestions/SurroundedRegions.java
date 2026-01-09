public class SurroundedRegions {
    public void fill(char[][] board) {
        // Code here
        int m=board.length;
        int n=board[0].length;  
        int[][] visited=new int[m][n];
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(board,0,j,visited);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0,visited);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O'){
                dfs(board,i,n-1,visited);
            }
        }
        for(int j=0;j<n;j++){
            if(board[m-1][j]=='O'){
                dfs(board,m-1,j,visited);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0 && i!=m-1 && j!=0 && j!=n-1){
                    if(board[i][j]=='O' && visited[i][j]==0){
                        board[i][j]='X';
                    }
                }
            }
        }
    }
    void dfs(char[][] board,int cr,int cc,int[][] visited){
        if(cr<0 || cc<0 || cr>=board.length || cc>=board[0].length || board[cr][cc]=='X' || visited[cr][cc]==1){
            return;
        }
        visited[cr][cc]=1;
        dfs(board,cr+1,cc,visited);
        dfs(board,cr-1,cc,visited);
        dfs(board,cr,cc+1,visited);
        dfs(board,cr,cc-1,visited);
    }
}


