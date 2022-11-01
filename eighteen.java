//1995. Count increasing triplets


public class eighteen {
    public boolean increasingTriplet(int[] nums) {
        
        if(nums.length<3)
            return false;
        
        int left = Integer.MAX_VALUE,mid = Integer.MAX_VALUE;
        
        for(int ele : nums){
            //First this will be called let index be i
            if(ele<left)
                left = ele;
            
            //Second this will be called,let index be j
            //i<j
            else if(ele>left && ele<mid)
                mid = ele;
            
            
            //Finally this will be called
            //so i<j<k
            if(ele>left && ele>mid)
                return true;
                        
        }
        
        return false;
    } 
}
