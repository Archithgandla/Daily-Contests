//17. Letter Combinations of a Phone Number

class Solution {

    HashMap<Character,char[]> hm;
    public void Util(String digits,List<String> li,int index,String s){
        if(index>=digits.length()){
            li.add(s);
            return;
        }

        for(char c:hm.get(digits.charAt(index)))
            Util(digits,li,index+1,s+c);

    }

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
            return new ArrayList<String>();

        hm = new HashMap<>();
        hm.put('1',new char[]{});
        hm.put('2',new char[]{'a','b','c'});
        hm.put('3',new char[]{'d','e','f'});
        hm.put('4',new char[]{'g','h','i'});
        hm.put('5',new char[]{'j','k','l'});
        hm.put('6',new char[]{'m','n','o'});
        hm.put('7',new char[]{'p','q','r','s'});
        hm.put('8',new char[]{'t','u','v'});
        hm.put('9',new char[]{'w','x','y','z'});

        List<String> li = new ArrayList<>();
        Util(digits,li,0,"");

        return li;
    }
}