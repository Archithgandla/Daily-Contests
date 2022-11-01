//981. Time Based Key-Value Store
import java.util.*;


class Pair{
    String value;
    int timestamp;
    
    Pair(){}
    Pair(String value,int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
    
}



class TimeMap {

    HashMap<String,ArrayList<Pair>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(hm.get(key) == null){
            ArrayList<Pair> Al = new ArrayList<>();
            Al.add(new Pair(value,timestamp));
            hm.put(key,Al);
        }
        else{
            ArrayList<Pair> temp = hm.get(key);
            temp.add(new Pair(value,timestamp));            
            hm.put(key,temp);
        }
        
    }
    
    public String get(String key, int timestamp) {
        
        ArrayList<Pair> temp = hm.get(key);
        Pair ans = new Pair("-",Integer.MIN_VALUE);
        
        //We could have used linear search like below 
        //but it gives n time,where as bs takes logn

        
        
        if(temp == null)
            return "";
        
        int low = 0,high = temp.size()-1;
        int mid = low+(high-low)/2;
        
        //Here we are applying binary search in increasing order
        //because timestamps are always in strictly increasing order
        //So by default it is in ascending order(Check test cases)
        
        
        while(low<=high){
            if(temp.get(mid).timestamp == timestamp)
                return temp.get(mid).value;
            
            else if(temp.get(mid).timestamp>timestamp){
                high = mid-1;
            }
            else{
                ans = temp.get(mid);
                low = mid+1;
            }
            mid = low+(high-low)/2;
        }
        
        if(ans.value != "-")
            return ans.value;
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
