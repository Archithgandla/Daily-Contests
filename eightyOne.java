//Reverse Integer

class Solution {
    public int reverse(int x) {
        int sum = 0,temp = x;
        int count = 0;
        while(Math.abs(x)>0){
            int digit = x%10;
            sum = sum*10+digit;
            x = x/10;
            count+=1;
        } 
        // System.out.println((int)(temp/(Math.pow(10,count-1))));
        // System.out.println(sum%10);

        if((int)(temp/(Math.pow(10,count-1))) != sum%10)
            return 0;
        return sum;
    }
}
