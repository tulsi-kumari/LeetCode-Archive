class Solution {
    public boolean exist(char[][] board, String word) {
       for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    if(sol(board,word,1,i,j)){
                        return true;
                                
                    }
                }
            }
        }
        return false; 
    }
     private static boolean sol(char[][] board,String word,int idx,int i,int j){
        if(idx==word.length()){
            return true;
        }
        if(board[i][j]=='#'){
            return false;
        }
        char ch=board[i][j];
        board[i][j]='#';
        if(i<board.length-1&&board[i+1][j]==word.charAt(idx)){
           if(sol(board,word,idx+1,i+1,j))
            {return true;}
        }
        if(i>0&&board[i-1][j]==word.charAt(idx)){
          if( sol(board,word,idx+1,i-1,j)){
               return true;
            }
        }
        if(j<board[0].length-1&&board[i][j+1]==word.charAt(idx)){
            if( sol(board,word,idx+1,i,j+1)){
                return true;
            }
        }
        if(j>0&&board[i][j-1]==word.charAt(idx)){
            if( sol(board,word,idx+1,i,j-1)){
                return true;
            }
        }
        board[i][j]=ch;
        return false;
    }
}