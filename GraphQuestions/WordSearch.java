public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(func(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean func(char[][] board,String word,int cr,int cc,int indx){
        int er=board.length;
        int ec=board[0].length;
        if(indx==word.length()){
            return true;
        }
        if(cr<0 || cc<0 || cr>=er || cc>=ec || board[cr][cc]!=word.charAt(indx)){
            return false;
        }
        char temp=board[cr][cc];
        board[cr][cc]='*';
        boolean found=func(board,word,cr-1,cc,indx+1)||func(board,word,cr+1,cc,indx+1)||func(board,word,cr,cc-1,indx+1)||func(board,word,cr,cc+1,indx+1);
        board[cr][cc]=temp;
        return found;
    }
}
