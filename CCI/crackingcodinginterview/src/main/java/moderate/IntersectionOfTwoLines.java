package moderate;

import recursionanddynamicprogramming.PowerSet;

public class IntersectionOfTwoLines {

    static class Line{
        Point first;
        Point second;

        public Line(Point first,Point second){
            this.first = first;
            this.second = second;
        }
    }

    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }


    static Point getIntersectionPoint(Line l1, Line l2){
        int slope1 = (l1.second.y - l1.first.y)/(l1.second.x - l1.first.x);
        int slope2 = (l2.second.y - l1.first.y)/(l2.second.x - l2.first.x);

        int intercept1 = l1.first.y - (slope1*l1.first.x);
        int intercept2 = l2.first.y - (slope2*l1.first.x);

        if(slope1==slope2){
            if(intercept1==intercept2){
                System.out.println("lines are overlapping");
                return null;
            }
            System.out.println("lines are parallel, no intersection");
            return null;
        }

        int x = (l1.first.y - l2.second.y - slope1*l1.first.x + slope2*l2.second.x)/(slope2-slope1);
        int y = slope1*(x - l1.first.x) + l1.first.y;
        return new Point(x,y);
    }

    public static void main(String[] args) {
        Point first = new Point(1,2);
        Point second = new Point(4,10);
        Line l1 = new Line(first,second);

        Point third = new Point(1,2);
        Point fourth = new Point(4,-10);
        Line l2 = new Line(third,fourth);

        Point p = getIntersectionPoint(l1,l2);
        if(p!=null)
            System.out.println(p.x+"\t"+p.y);

    }
}
