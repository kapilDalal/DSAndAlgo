package hard;

import java.util.*;

/*
Baby Names: Each year, the government releases a list of the 10000 most common baby names
and their frequencies (the number of babies with that name). The only problem with this is that
some names have multiple spellings. For example, "John" and ''.Jon" are essentially the same name
but would be listed separately in the list. Given two lists, one of names/frequencies and the other
of pairs of equivalent names, write an algorithm to print a new list of the true frequency of each
name. Note that if John and Jon are synonyms, and Jon and Johnny are synonyms, then John and
Johnny are synonyms. (It is both transitive and symmetric.) In the final list, any name can be used
as the "real" name.
EXAMPLE
Input:
Names: John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
Output: John (27), Kris (36)
* */
public class BabyNames {
    /*
    * create an adjacency list of equivalent names like in above example,
    * the list would be
    *
    * John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
    *
    * Jon   -> John
    * John  -> Jon, Jonny
    * Jonny -> John
    * Chris -> Kris, Christopher
    * Kris  -> Chris
    * Christopher-> Chris
    *
    * Now start with frequency list and traverse the adjList
    * first is John take its list add Jon to John's freq and go to Jon,
    * in similar way we can do DFS and get the final answer.
    *
    * */

    public void getFinalBabyNamesList(HashMap<String,Integer> freqMap,
                                        ArrayList<String> p1,ArrayList<String> p2)
    {
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();

        for(int i=0;i<p1.size();i++){
            String key = p1.get(i);
            String value = p2.get(i);
            if(adjList.containsKey(key)){
                adjList.get(key).add(value);
            }else{
                ArrayList<String> l = new ArrayList<>();
                l.add(value);
                adjList.put(key,l);
            }
            if(adjList.containsKey(value)){
                adjList.get(value).add(key);
            }else{
                ArrayList<String> l = new ArrayList<>();
                l.add(key);
                adjList.put(value,l);
            }
        }

        HashSet<String> visited  = new HashSet<>();
        HashMap<String,Integer> res = new HashMap<>();
        for(int i=0;i<p1.size();i++) {
            if(!visited.contains(p1.get(i))){
                int cnt = addMatchingWords(p1.get(i), freqMap, adjList, visited);
                if(cnt!=0)
                res.put(p1.get(i),cnt );
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator2 = res.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Integer> next = iterator2.next();
            System.out.println(next.getKey() + "\t" + next.getValue());
        }
    }

    private int addMatchingWords(String name,HashMap<String, Integer> freqMap, HashMap<String, ArrayList<String>> adjList, HashSet<String> names) {
        if(names.contains(name))
            return 0;
        names.add(name);
        ArrayList<String> synonyms = adjList.get(name);
        int cnt = 0;
        cnt += freqMap.get(name);
        for(String s : synonyms){
            cnt += addMatchingWords(s,freqMap,adjList,names);;
        }
        return cnt;

    }

    public static void main(String[] args) {
        BabyNames bn = new BabyNames();
        /*
          Names: John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
          Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
        */

        ArrayList<String> p1 = new ArrayList<>(Arrays.asList("Jon","John","Chris","Chris"));
        ArrayList<String> p2 = new ArrayList<>(Arrays.asList("John","Johnny","Kris","Christopher"));


        HashMap<String,Integer> freq = new HashMap<>();
        freq.put("Jon",12);
        freq.put("John",15);
        freq.put("Johnny",10);
        freq.put("Chris",13);
        freq.put("Kris",4);
        freq.put("Christopher",19);

        bn.getFinalBabyNamesList(freq,p1,p2);

    }


}
