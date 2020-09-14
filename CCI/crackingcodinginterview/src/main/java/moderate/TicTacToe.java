package moderate;

public class TicTacToe {

    int[][] board;

    public TicTacToe(){
        board = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=-1;
            }
        }
    }

    public void nextMove(int num,int r,int c){
        if(board[r][c]!=-1)
        {
            System.out.println("already occupied, make a diff move");
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print(board[i][j]+"\t");
                }
                System.out.println();
            }
            return;
        }
        board[r][c] = num;

        if(winningMove(board,num,r,c)){
            System.out.println(num +"\t won");
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    board[i][j]=-1;
                }
            }
        }
    }
    private boolean winningMove(int[][] board,int r,int c,int num){

        for(int i=0;i<3;i++){
            if(board[i][c]!=num)
                return false;
        }
        for (int j=0;j<3;j++){
            if(board[r][j]!=num)
                return false;
        }
        int tr = r;
        int tc = c;
        int cnt = 1;
        for(int i=tr-1;i>=0;i--){
            if(tc-cnt>=0){
                if(board[i][tc-cnt]!=num)
                    return false;
            }
            if(tc+cnt<3){
                if(board[i][tc+cnt]!=num)
                    return false;
            }
        }
        cnt = 1;
        for(int i=tr+1;i<3;i++){
            if(tc-cnt>=0){
                if(board[i][tc-cnt]!=num)
                    return false;
            }
            if(tc+cnt<3){
                if(board[i][tc+cnt]!=num)
                    return false;
            }
        }
        return true;
    }


}
