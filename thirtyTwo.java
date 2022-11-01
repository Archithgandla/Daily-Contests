//49. Group Anagrams
import java.util.*;

public class thirtyTwo {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList<String>> hm = new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            HashMap<Character,Integer> temp = new HashMap<>();
            String s =  strs[i];
            
            for(int j=0;j<s.length();j++){
                temp.put(s.charAt(j),temp.getOrDefault(s.charAt(j),0)+1);
            }
            ArrayList<String> Al;
            if(hm.get(temp) == null){
                Al = new ArrayList<>();
                Al.add(s);
                hm.put(temp,Al);
            }
            else{
                Al = hm.get(temp);
                Al.add(s);
                hm.put(temp,Al);
            }
            
        }
        
        
        
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(hm.values());
        
        return ans;
    }
}
