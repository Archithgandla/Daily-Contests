//433. Minimum Genetic Mutation
//Almost similar to wordladder

import java.util.*;


public class thirtySeven {
    boolean search(String[] bank,String a){
        for(int i=0;i<bank.length;i++){
            if(bank[i].equals(a)){      
                return true;
            }
        }
        
        return false;
    }
    

    public int minMutation(String start, String end, String[] bank) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        Queue<String>  q = new LinkedList<>();
        int level = 0;
        
        q.add(start);
        hm.put(start,1);
        
        while(q.size() !=0 ){
            
            int count = q.size();
            
            while(count>0){
                
                String s = q.remove();
                
                //System.out.println(temp);
                if(s.equals(end)){
                    return level;
                }
                
                
                for(char c : "ACGT".toCharArray()){
                    
                    // for(int i=0;i<temp.length;i++)
                    //     System.out.print(temp[i]);
                    // System.out.println("");
                    
                    for(int i=0;i<s.length();i++){
                        char[] neighbour = new char[8];
                        
                        //Creating a temp array neigbour beacuse the changes made for one node should not reflect in another
                        for(int j=0;j<s.length();j++)
                            neighbour[j] = s.charAt(j);
                               
                        neighbour[i] = c;
                        
                        String p = "";
                        
                        //Manually creating a string beacuse toString() method is not working with search function
                        for(int j=0;j<s.length();j++)
                            p = p+neighbour[j];
                        
                        
                        if(search(bank,p) == true && !hm.containsKey(p)){       
                            hm.put(p,1);
                            q.add(p);
                        } 
                        
                
                        
                    }
                }
                count-=1;
                    
            }
            
            level+=1;
        }
        return -1;
        
    }    
}
