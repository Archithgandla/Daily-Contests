//976. Largest Perimeter Triangle
import java.util.*;

//we could have directly taken three greatest numbers
//but the sum of last two greatest numbers might not be greater than greatest element ,in that case greatest element should not be considered
//so now try including second last as the largest element


public class ninteen {
    public int largestPerimeter(int[] nums) {
        
        if(nums.length<3)
            return 0;
        
        
        Arrays.sort(nums);
        
        for(int i=nums.length-1;i>=2;i--){
            //We are not checking the other two
            //because
            //obviously ith num is greater than other two
            //and if we add another num to greater num it becomes even more greater
            if(nums[i-1]+nums[i-2]>nums[i])
                return nums[i-1]+nums[i-2]+nums[i];
        }
        return 0;
    }    
}
