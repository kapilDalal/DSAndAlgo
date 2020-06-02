package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CaptureRegionOnBoard {

	int[] x = {-1,1,0,0};
	int[] y = {0,0,-1,1};
	public void solve(ArrayList<ArrayList<Character>> a) {
	    boolean[][] visited = new boolean[a.size()][a.get(0).size()];
		
		for(int i=0;i<a.size();i++) {
			if(a.get(i).get(0)=='O') {
				markVisited(visited,i,0,a);
			}
		}
		for(int i=0;i<a.size();i++) {
			if(a.get(i).get(a.get(0).size()-1)=='O') {
				markVisited(visited,i,a.get(0).size()-1,a);
			}
		}
		for(int j=0;j<a.get(0).size();j++) {
			if(a.get(0).get(j)=='O')
				markVisited(visited, 0, j, a);
		}
		for(int j=0;j<a.get(0).size();j++) {
			if(a.get(a.size()-1).get(j)=='O')
				markVisited(visited, a.size()-1, j, a);
		}
		
		for(int i=1;i<a.size()-1;i++) {
			for(int j=1;j<a.get(0).size()-1;j++) {
				if(a.get(i).get(j)=='O' && !visited[i][j])
					a.get(i).set(j, 'X');
			}
		}
		
	}
	private void markVisited(boolean[][] visited, int i, int j, ArrayList<ArrayList<Character>> a) {
		// TODO Auto-generated method stub
		visited[i][j] = true;
		
		for(int k=0;k<x.length;k++) {
			if(i+x[k]>=0 && i+x[k]<a.size() && j+y[k]>=0 && j+y[k]<a.get(0).size() && !visited[i+x[k]][j+y[k]] && a.get(i+x[k]).get(j+y[k])=='O')
				markVisited(visited, i+x[k], j+y[k], a);
		}
	}
	
	public static void main(String[] args) {
		CaptureRegionOnBoard cr = new CaptureRegionOnBoard();
		ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
		a.add(new ArrayList<Character>(Arrays.asList('X','O','X','X','X','X','O','O','X','X')));
		a.add(new ArrayList<Character>(Arrays.asList('X','O','O','O','O','X','O','O','X','X')));
		a.add(new ArrayList<Character>(Arrays.asList('O','X','X','O','O','X','X','X','O','O')));
		a.add(new ArrayList<Character>(Arrays.asList('O','X','X','X','O','O','O','X','X','O')));
		a.add(new ArrayList<Character>(Arrays.asList('O','X','X','X','X','X','O','O','X','X')));
		a.add(new ArrayList<Character>(Arrays.asList('O','X','X','X','X','X','X','O','X','O')));
		a.add(new ArrayList<Character>(Arrays.asList('O','O','X','X','X','X','O','X','O','O')));
		
		
		
		
		cr.solve(a);
		System.out.println(a);
	}
	
}
