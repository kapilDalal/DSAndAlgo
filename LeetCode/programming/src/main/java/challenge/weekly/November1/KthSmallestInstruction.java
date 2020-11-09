package challenge.weekly.November1;
/*
Bob is standing at cell (0, 0), and he wants to reach destination: (row, column).
He can only travel right and down. You are going to help Bob by providing instructions
for him to reach destination.

The instructions are represented as a string, where each character is either:

'H', meaning move horizontally (go right), or
'V', meaning move vertically (go down).
Multiple instructions will lead Bob to destination. For example, if destination is (2, 3),
both "HHHVV" and "HVHVH" are valid instructions.

However, Bob is very picky. Bob has a lucky number k, and he wants the kth lexicographically
smallest instructions that will lead him to destination. k is 1-indexed.

Given an integer array destination and an integer k, return the kth lexicographically smallest
instructions that will take Bob to destination.

Input: destination = [2,3], k = 1
Output: "HHHVV"
Explanation: All the instructions that reach (2, 3) in lexicographic order are as follows:
["HHHVV", "HHVHV", "HHVVH", "HVHHV", "HVHVH", "HVVHH", "VHHHV", "VHHVH", "VHVHH", "VVHHH"].
* */
public class KthSmallestInstruction {

    static String dest = "";
    int[] xMoves = {0,1};
    int[] yMoves = {1,0};
    boolean reached = false;
    int ways = 0;

    public String kthSmallestPath(int[] destination, int k) {
        int x = 0;
        int y = 0;
        dest = "";
        ways = 0;
        reached = false;
        findSmallestPath(x,y,destination,k,"");
        return dest;
    }

    private void findSmallestPath(int x, int y, int[] destination, int k, String curr) {
        if(x==destination[0] && y==destination[1]){
            ways++;
            if(ways ==k){
            dest = new String(curr);
            reached = true;
            }
            return;
        }
        if(!reached)
            for (int i=0;i<xMoves.length;i++){
                if(x+xMoves[i]>=0 && y+yMoves[i]>=0 && x+xMoves[i]<=destination[0] &&
                        y+yMoves[i]<=destination[1] && !reached){
                    if(i==0){
                        curr = curr +"H";
                    }else {
                        curr = curr +"V";
                    }
                    findSmallestPath(x+xMoves[i],y+yMoves[i],destination,k,curr);
                    if(!reached)
                        curr = curr.substring(0,curr.length()-1);
                }
            }
    }

}
