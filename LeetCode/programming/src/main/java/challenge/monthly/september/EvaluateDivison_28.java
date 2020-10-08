package challenge.monthly.september;

import java.util.*;

public class EvaluateDivison_28 {

    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {

        double[] res = new double[queries.size()];
        HashMap<String,Double> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int i=0;
        for(List<String> e : equations){
            String s1 = e.get(0);
            String s2 = e.get(1);
            map.put(s1+"_"+s2,values[i]);
            map.put(s2+"_"+s1,1/values[i]);
            set.add(s1);
            set.add(s2);
            i++;
        }
        i=0;
        for(List<String> q : queries){

            String s1 = q.get(0);
            String s2 = q.get(1);
            if(!set.contains(s1) || !set.contains(s2)){
                res[i] = -1D;
            }
            else{
                if(map.containsKey(s1+"_"+s2)){
                    res[i] = map.get(s1+"_"+s2);
                }else if(map.containsKey(s2+"_"+s1)){
                    res[i] = map.get(s2+"_"+s1);
                }else{
                    boolean found = false;
                    Iterator<Map.Entry<String, Double>> iterator = map.entrySet().iterator();
                    while(iterator.hasNext()){
                        Map.Entry<String, Double> next = iterator.next();
                        String key = next.getKey();
                        String[] splits = key.split("_");
                        if(splits[0].equals(s1)){
                            if(map.containsKey(splits[1]+"_"+s2)){
                                res[i] = next.getValue() * map.get(splits[1]+"_"+s2);
                                found = true;
                                break;
                            }
                        }
                    }
                    if(!found)
                        res[i] = -1D;
                }
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        EvaluateDivison_28 ed = new EvaluateDivison_28();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1","x2"));
        equations.add(Arrays.asList("x2","x3"));
        equations.add(Arrays.asList("x3","x4"));
        equations.add(Arrays.asList("x4","x5"));
        double[] values = new double[]{3.0,4.0,5.0,6.0};
        //"x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]]
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x1","x5"));
        queries.add(Arrays.asList("x5","x2"));
        queries.add(Arrays.asList("x2","x4"));
        queries.add(Arrays.asList("x2","x2"));
        queries.add(Arrays.asList("x2","x9"));
        queries.add(Arrays.asList("x9","x9"));
        double[] res = ed.calcEquation(equations, values, queries);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+"\t");
        }
    }
}
