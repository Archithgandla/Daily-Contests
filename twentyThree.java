//1832. Check if the Sentence Is Pangram
//This problem can be solved using frequency array,set and hashmap
//I have solved using frequency array
//Other approaches
//https://leetcode.com/problems/check-if-the-sentence-is-pangram/discuss/2712517/Java-oror-using-Frequency-array-oror-using-Set-oror-using-HashMap

//Time and space : O(1)
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        
        for(int i=0;i<sentence.length();i++)
            arr[sentence.charAt(i)-'a']+=1;
        
        for(int i=0;i<26;i++){
            if(arr[i] == 0)
                return false;
        }
        return true;
    }
}
