package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Circus Tower: A circus is designing a tower routine consisting of people standing atop one another
shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter
than the person below him or her. Given the heights and weights of each person in the circus, write
a method to compute the largest possible number of people in such a tower.
EXAMPLE
Input(ht,wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
Output: The longest tower is length 6 and includes from top to bottom:
(56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
* */
public class CircusTower {

    static class Person implements Comparable<Person>{
        int height;
        int weight;

        public Person(int h,int w){
            this.height = h;
            this.weight = w;
        }

        @Override
        public int compareTo(Person o) {
            return o.weight-this.weight;
        }
    }
    public void getLongestTowerLength(ArrayList<Integer> heights,ArrayList<Integer> weights){

        ArrayList<Person> personList = new ArrayList<>();
        for(int i=0;i<heights.size();i++){
            int height = heights.get(i);
            int weight = weights.get(i);
            Person p = new Person(height,weight);
            personList.add(p);
        }
        Collections.sort(personList);

        int[] len = new int[heights.size()];
        for(int i=0;i< len.length;i++)
            len[i] = 1;
        int max = 0;
        for(int i=1;i<personList.size();i++){
            for(int j=0;j<i;j++){
                if(personList.get(i).height<personList.get(j).height){
                    len[i] = Math.max(len[i],1+len[j] );
                }
            }
            max = Math.max(max,len[i]);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        //(65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
        ArrayList<Integer> heights = new ArrayList<>(Arrays.asList(65,70,56,75,60,68));
        ArrayList<Integer> weights = new ArrayList<>(Arrays.asList(100,150,90,190,95,110));
        CircusTower ct = new CircusTower();
        ct.getLongestTowerLength(heights,weights);
    }

}
