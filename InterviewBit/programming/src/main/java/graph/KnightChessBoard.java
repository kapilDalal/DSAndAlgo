package graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightChessBoard {
	
	int minMoves;
	int[] x = {-2,-2,-1,-1,1,1,2,2};
	int[] y = {-1,1,-2,2,-2,2,1,-1};
	
	public int knight(int A, int B, int C, int D, int E, int F) {
		minMoves = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[A+1][B+1]; 
		countMoves(A, B, C, D, E, F, 0,visited);
		return minMoves==Integer.MAX_VALUE?-1:minMoves;
    }
	private void countMoves(int a,int b,int c,int d,int e,int f,int moves,boolean[][] visited) {
		if(c==e && d==f) {
			minMoves = Math.min(moves, minMoves);			
			return;
		}			
		for(int i=0;i<x.length;i++) {
			if(c+x[i]>=1 && c+x[i]<=a && d+y[i]>=1 && d+y[i]<=b && !visited[c+x[i]][d+y[i]]) {
				visited[c+x[i]][d+y[i]] = true;
				countMoves(a, b, c+x[i], d+y[i], e, f, moves+1,visited);				
			}
		}
	}
	
	class Pair{
        int x,y,count;
        Pair(int x,int y,int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
    int []shiftX = new int[]{-2, -2, 1, -1, 2, 2, -1, 1};
    int shiftY[] = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
    boolean valid(int i,int j,int row,int col,boolean[][]visit){
        if(i>0 && i<=row && j>0 && j<=col && !visit[i][j]) return true;
        return false;
    }
    public int knightUsingBFS(int matrixRow, int matrixCol, int startX, int startY, int endX, int endY) {
        Queue<Pair> q  =new LinkedList<>();
        q.offer(new Pair(startX,startY,0));
        boolean visit[][] = new boolean[matrixRow+1][matrixCol+1];
        visit[startX][startY]=true;
        while(!q.isEmpty()){
            Pair  p = q.remove();
            int x=p.x;
            int y=p.y;
            int count=p.count;
            if(x==endX && y==endY){
                return count;
            }
            for(int i=0;i<8;i++){
                int nx=x+shiftX[i];
                int ny=y+shiftY[i];
                if(valid(nx,ny,matrixRow,matrixCol,visit)){
                    visit[nx][ny]=true;
                    q.offer(new Pair(nx,ny,count+1));
                }
            }
        }
        return -1;
    }

	
	
	public static void main(String[] args) {
		KnightChessBoard kcb = new KnightChessBoard();
		int moves = kcb.knightUsingBFS(8, 8, 1, 1, 8, 8);
		System.out.println(moves);
	}

}
