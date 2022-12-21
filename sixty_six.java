//1207. Unique Number of Occurrences

import java.util.*;
public class sixty_six {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<arr.length;i++)
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        
        for(int i:hm.keySet()){
            if(!set.add(hm.get(i)))
                return false;
        }
        return true;
    }
}
