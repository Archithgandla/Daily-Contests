//2225. Find Players With Zero or One Losses
import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        
        for(int i=0;i<matches.length;i++)
            hm.put(matches[i][1],hm.getOrDefault(matches[i][1],0)+1);
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());
        
        
        //Players who lost single match
        for(int i=0;i<matches.length;i++){
            if(hm.get(matches[i][1]) == 1)
                ans.get(1).add(matches[i][1]);
        }
        
        
        //Players who did not lose any match
        //so they cannot be found on losers side
        for(int i=0;i<matches.length;i++){
            if(!hm.containsKey(matches[i][0])){
                ans.get(0).add(matches[i][0]);
                hm.put(matches[i][0],0);
            }
        }
        
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
        
    }
}
