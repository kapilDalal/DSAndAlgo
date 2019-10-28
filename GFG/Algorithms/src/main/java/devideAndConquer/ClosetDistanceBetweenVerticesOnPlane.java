package devideAndConquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClosetDistanceBetweenVerticesOnPlane {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static double bfDist(ArrayList<Point> list){
		double dist = Integer.MAX_VALUE;
		
		for(int i=0;i<list.size();i++){
			for(int j=i+1;j<list.size();j++){
				Point p1 = list.get(i);
				Point p2 = list.get(j);				
				double d = Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));
				if(d<dist)
					dist = d;
			}
		}
		return dist;
	}
	
	static double stripClosestDist(ArrayList<Point> list,double delta){
		double dist = Integer.MAX_VALUE;
		
		Collections.sort(list, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.y - p2.y;
			}
		});
		
		for(int i=0;i<list.size();i++){
			for(int j=i+1;j<list.size() && Math.abs((list.get(i).y-list.get(j).y))< delta ; j++){
				double d = Math.sqrt(Math.pow((list.get(i).y-list.get(j).y),2) + Math.pow((list.get(i).x-list.get(j).x),2));
				if(d<dist)
					dist = d;
			}
		}
		return dist;
		
	}
	
	static double closestDist(ArrayList<Point> list,int n){
		if(n<=3)
			return bfDist(list);
		int mid = n/2;
		Point middle = list.get(mid);
		
		ArrayList<Point> left = new ArrayList<Point>(list.subList(0, mid));
		ArrayList<Point> right = new ArrayList<Point>(list.subList(mid, n));
		
		double ld = closestDist(left, left.size());
		double rd = closestDist(right, right.size());
		
		double delta = Math.min(ld, rd);
		
		ArrayList<Point> strip = new ArrayList<Point>();
		
		for(int i=0;i<list.size();i++){
			Point p = list.get(i);
			if(Math.abs(p.x-middle.x)<delta)
				strip.add(p);
		}		
		return Math.min(delta, stripClosestDist(strip, delta));		
	}

	public static void main(String[] args) {
		Point a = new Point(2, 3);
		Point b = new Point(12, 30);
		Point c = new Point(40, 50);
		Point d = new Point(5, 1);
		Point e = new Point(12, 10);
		Point f = new Point(3, 4);
		ArrayList<Point> P = new ArrayList<Point>();
		P.add(a);
		P.add(b);
		P.add(c);
		P.add(d);
		P.add(e);
		P.add(f);

		Collections.sort(P, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.x - p2.x;
			}
		});

		System.out.println(closestDist(P, P.size()));		

	}

}
