package challenge.weekly.Septmember27;

import java.util.*;

class ThroneInheritance {

    HashMap<String, List<String>> map = new HashMap<>();
    HashSet<String> dead = new HashSet<>();
    String king;
    public ThroneInheritance(String kingName) {
        map.put(kingName,new ArrayList<>());
        this.king = kingName;
    }

    public void birth(String parentName, String childName) {
        if(map.containsKey(parentName)){
            map.get(parentName).add(childName);
        }else{
            List<String> l = new ArrayList<String>();
            l.add(childName);
            map.put(parentName,l);
        }
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        ArrayList<String> order = new ArrayList<>();
        dfs(king,order);
        Iterator<String> iterator = order.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            if(dead.contains(next))
                iterator.remove();
        }
        return order;
    }

    public void dfs(String name,ArrayList<String> order){
        order.add(name);
        if(map.containsKey(name)){
            List<String> children = map.get(name);
            Iterator<String> iterator = children.iterator();
            while(iterator.hasNext()){
                dfs(iterator.next(), order);
            }
        }
    }
}