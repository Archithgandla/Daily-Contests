
//345.reverse vowels of a string

class Solution {
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    
    
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        // HashMap<Character,Integer> hm = new HashMap<>();
        // hm.put('a',1);
        // hm.put('e',1);
        // hm.put('i',1);
        // hm.put('o',1);
        // hm.put('u',1);
        // hm.put('A',1);
        // hm.put('E',1);
        // hm.put('I',1);
        // hm.put('O',1);
        // hm.put('U',1);
        
        
        int i=0,j=s.length()-1;
        
        while(i<j){
            if(isVowel(arr[i]) && isVowel(arr[j])){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i+=1;
                j-=1;
            }
            else if(!isVowel(arr[i]))
                i+=1;
            else if(!isVowel(arr[j]))
                j-=1;
                  
        }
        
//         StringBuilder ans = new StringBuilder("");
        
//         for(char c :arr)
//             ans.append(c);
        
        return new String(arr);
        
    }
}
