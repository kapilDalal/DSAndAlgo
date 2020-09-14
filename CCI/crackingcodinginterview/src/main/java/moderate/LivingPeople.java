package moderate;

import java.util.List;

public class LivingPeople {

    static class People{
        int birthYear;
        int deathYear;
        public People(int b,int d){
            this.birthYear = b;
            this.deathYear = d;
        }
    }

    public int getYearMostPeopleAlive(List<People> peopleList){
        int[] count = new int[100+1];

        for(People p : peopleList){

            for(int i=p.birthYear;i<= p.deathYear;i++){
                count[1900-i]++;
            }

        }

        int max = count[0];
        int maxIndex = 0;
        for(int i=0;i<=100;i++){
            if(count[i]>max){
                max = count[i];
                maxIndex = i;
            }
        }
        return maxIndex+1900;
    }

}
