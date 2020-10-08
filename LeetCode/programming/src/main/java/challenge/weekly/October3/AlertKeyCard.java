package challenge.weekly.October3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlertKeyCard {

    static class PersonEntry implements Comparable<PersonEntry>{
        String name;
        String time;
        int timeStamp;
        public PersonEntry(String name,String time){
            this.name = name;
            this.time = time;
        }

        public void  setTimeStamp(int timeStamp){
            this.timeStamp = timeStamp;
        }
        public  int getTimeStamp(){
            return timeStamp;
        }

        @Override
        public int compareTo(PersonEntry o) {
            if(this.name.equals(o.name)){
                return this.timeStamp-o.timeStamp;
            }
            return this.name.compareTo(o.name);
        }
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        ArrayList<PersonEntry> pe = new ArrayList<>();
        for(int i=0;i< keyName.length;i++){
            PersonEntry p = new PersonEntry(keyName[i],keyTime[i]);
            pe.add(p);
        }

        for(PersonEntry p : pe){

            String timeStr = p.time;
            String[] splits = timeStr.split(":");
            int f = Integer.parseInt(splits[0]);
            int s = Integer.parseInt(splits[1]);
            p.setTimeStamp(f*60+s);
        }
        Collections.sort(pe);
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<pe.size();i++){

            PersonEntry p = pe.get(i);
            if(i+2<pe.size() && pe.get(i+2).name.equals(p.name)){
                if(Math.abs(p.getTimeStamp()-pe.get(i+2).getTimeStamp())<=60){
                    if(!res.contains(p.name))
                        res.add(p.name);
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        AlertKeyCard ak = new AlertKeyCard();

        System.out.println(ak.alertNames(new String[]{"alice","alice","alice","bob","bob","bob","bob"},
                new String[]{"12:01","12:00","18:00","21:00","21:20","22:00","23:00"}));
    }
}
