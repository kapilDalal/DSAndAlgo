package dp;

public class FloydWarshall {
	
	static int[][] fw(int[][] g)
	{
		int[][] dis = new int[g.length][g.length];
		
		for(int i=0;i<g.length;i++) {
			for(int j=0;j<g.length;j++) {
				dis[i][j] = g[i][j];
			}
		}
		
		for(int i=0;i<g.length;i++) {
			for(int j=0;j<g.length;j++) {
				for(int k=0;k<g.length;k++) {
					if(dis[i][k]!=Integer.MAX_VALUE && dis[k][j]!=Integer.MAX_VALUE && dis[i][j]>dis[i][k]+dis[k][j])
						dis[i][j] = dis[i][k]+dis[k][j];
				}
			}
		}
		
		return dis;
		
	}
	
	public static void main(String[] args) {
		int INF = Integer.MAX_VALUE;
		int[][] g = {{0,   5,  INF, 10},
	                {INF,  0,  3,  INF},
	                {INF, INF, 0,   1},
	                {INF, INF, INF, 0} };
		
		int[][] dist = fw(g);
		
		for(int i=0;i<dist.length;i++) {
			for(int j=0;j<dist.length;j++) {
				System.out.print(dist[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
