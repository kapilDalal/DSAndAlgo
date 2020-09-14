package challenge.weekly.September13;

import java.util.Iterator;
import java.util.LinkedList;

public class SpecialPositions {

    public int numSpecial(int[][] mat) {
        LinkedList<Integer>[] specials = new LinkedList[mat.length];
       // LinkedList<Integer>[] cols = new LinkedList[mat[0].length];

        for(int i=0;i<mat.length;i++){

            for(int j=0;j<mat[0].length;j++){

                if(mat[i][j]==1){

                    if(specials[i]==null){
                        specials[i] = new LinkedList<>();
                    }
                    specials[i].add(j);
                }

            }

        }
        int cnt = 0;
        for(int i=0;i<specials.length;i++){

            if(specials[i]!=null && rowSpecial(i,mat)){
                Iterator<Integer> iterator = specials[i].iterator();
                while (iterator.hasNext()){

                    if(colSpecial(iterator.next(),mat))
                        cnt++;
                }
            }

        }

        return cnt;
    }

    private boolean colSpecial(Integer j, int[][] mat) {
        int cnt = 0;
        for(int i=0;i< mat.length;i++){
            if(mat[i][j]==1)
                cnt++;
        }
        return cnt>1?false:true;
    }

    private boolean rowSpecial(int i, int[][] mat) {
        int cnt = 0;
        for(int j=0;j<mat[0].length;j++){
            if(mat[i][j]==1)
                cnt++;

        }

        return cnt>1?false:true;
    }

    public static void main(String[] args) {
        SpecialPositions sp = new SpecialPositions();
        int[][] mat =  {{0,0,0,0,0},
                        {1,0,0,0,0},
                        {0,1,0,0,0},
                        {0,0,1,0,0},
                        {0,0,0,1,1}};

        int mat1[][] = {{0,1,0},
                        {0,0,1},
                        {1,0,0}};
        System.out.println(sp.numSpecial(mat));
    }


}
