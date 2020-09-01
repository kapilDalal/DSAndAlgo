package recursionanddynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;

public class RobotInGrid {

    static class Move {
        int row;
        int col;
        public Move(int r, int c){
            this.row = r;
            this.col = c;
        }
    }

    private boolean isSafe(int i,int j,int[][] grid,boolean[][] visited){
        if(i>=grid.length || j>= grid[0].length || grid[i][j]==-1 || visited[i][j])
            return false;
        return true;
    }

    public void findPath(int[][] grid){
        Queue<Move> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Move[][] moves = new Move[grid.length][grid[0].length];
        Move curr = new Move(0,0);
        q.add(curr);
        while(!q.isEmpty() && (curr.row!= grid.length-1 || curr.col!=grid[0].length-1)){
            curr = q.poll();
            visited[curr.row][curr.col] = true;
            if(isSafe(curr.row+1, curr.col, grid, visited)){
                q.add(new Move(curr.row+1, curr.col));
                visited[curr.row+1][curr.col] = true;
                moves[curr.row+1][curr.col] = curr;
            }
            if(isSafe(curr.row, curr.col+1, grid,visited)) {
                q.add(new Move(curr.row, curr.col + 1));
                visited[curr.row][curr.col+1] = true;
                moves[curr.row][curr.col+1] = curr;
            }
        }
        if(curr.row== grid.length-1 && curr.col==grid[0].length-1){
            curr = moves[grid.length-1][grid[0].length-1];

            while(curr.row!= 0 || curr.col!=0){
                System.out.print(curr.row+"\t"+curr.col);
                System.out.println();
                curr = moves[curr.row][curr.col];
            }
            System.out.println(curr.row+"\t"+ curr.col);
        }

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,0,0},
                                   {0,-1,0,0},
                                   {0,0,-1,0}};
        RobotInGrid r = new RobotInGrid();
        r.findPath(grid);
    }

}
