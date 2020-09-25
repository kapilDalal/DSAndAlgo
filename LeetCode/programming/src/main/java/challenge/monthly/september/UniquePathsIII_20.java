package challenge.monthly.september;

public class UniquePathsIII_20 {

    int paths;
    public int uniquePathsIII(int[][] grid) {
        paths = 0;
        boolean[][] v = new boolean[grid.length][grid[0].length];
        int sx=0;
        int sy=0;
        int dx= grid.length-1;
        int dy= grid[0].length-1;
        for(int i=0;i<v.length;i++){
            for(int j=0;j<v[0].length;j++){
                if(grid[i][j]==0)
                    v[i][j] = false;
                else {
                    v[i][j] = true;
                    if(grid[i][j]==1){
                        sx = i;
                        sy = j;
                    }
                    else if(grid[i][j]==2){
                        v[i][j] = false;
                        dx = i;
                        dy = j;
                    }
                }
            }
        }
        geneatePaths(grid,v,sx,sy,dx,dy);
        return paths;
    }
    int[] xMoves = {0,0,1,-1};
    int[] yMoves = {1,-1,0,0};
    private void geneatePaths(int[][] grid, boolean[][] v,int sx,int sy,int dx,int dy) {
        v[sx][sy] = true;
        if(sx==dx && sy==dy){
            if(allVisited(v))
                paths++;
        }

        for(int i=0;i< xMoves.length;i++){
            if(sx+xMoves[i]>=0 && sx+xMoves[i]< grid.length && sy+yMoves[i]>=0 && sy+yMoves[i]< grid[0].length &&!v[sx+xMoves[i]][sy+yMoves[i]]){
                geneatePaths(grid,v,sx+xMoves[i],sy+yMoves[i],dx,dy);
            }
        }
        v[sx][sy] = false;
    }

    private boolean allVisited(boolean[][] v) {
        for(int i=0;i<v.length;i++){
            for(int j=0;j<v[0].length;j++){
                if(!v[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UniquePathsIII_20 up = new UniquePathsIII_20();
        int[][] grid =  {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(up.uniquePathsIII(grid));

    }

}
