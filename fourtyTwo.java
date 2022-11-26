//1323. Maximum 69 Number

class Solution {
    public int maximum69Number (int num) {
        String temp = String.valueOf(num);
        char[] arr = temp.toCharArray();
        
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '6'){
                arr[i] = '9';
                break;
            }
        }
        
    
        int sum = 0;
        
        for(int i=0;i<arr.length;i++)
            sum = sum*10+arr[i]-'0';
        
        
        return sum;

        //Simpler Code
        // class Solution {
        //     public int maximum69Number (int num) {
        
        //         char[] arr = String.valueOf(num).toCharArray();                
        //         for(int i=0;i<arr.length;i++){
        //             if(arr[i] == '6'){
        //                 arr[i] = '9';
        //                 break;
        //             }
        //         }
                        
        //         return Integer.valueOf(String.valueOf(arr));
        //     }
        // }


    }
}
