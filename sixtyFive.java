//380. Insert Delete GetRandom O(1)
import java.util.*;

class RandomizedSet {
    
    HashMap<Integer,Integer> hm;
    ArrayList<Integer> Al;
    Random r;
    
    public RandomizedSet() {
         hm = new HashMap<>();
         Al = new ArrayList<>();
         r = new Random();     
    }
    
    public boolean insert(int val) {
        if(!hm.containsKey(val)){
            hm.put(val,Al.size());
            Al.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val))
            return false;
        
        int index = hm.get(val);
        hm.remove(val);

        if(index == Al.size()-1){
            Al.remove(Al.size()-1);
            return true;
        }
        
       
        //Swapping
        Al.set(index,Al.get(Al.size()-1));        
        Al.remove(Al.size()-1);
        hm.put(Al.get(index),index);
        
        return true;
    }
    
    public int getRandom() {
        //System.out.println(hm);
        int randomIndex = r.nextInt(0,Al.size());
        return Al.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */