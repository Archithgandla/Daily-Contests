//692. Top K Frequent Words
//Comparable cannot be written to pair of hashmap
//and we cannot directly store frequencies using pairs
//So first we stored frequencies and then stored them in a maxheap using 
//Priority Queue



class Pair implements Comparable<Pair>{
    
    String str;
    int frequency;
    
    Pair(String str,int frequency){
        this.str = str;
        this.frequency = frequency;
    }
    
    
    public int compareTo(Pair p){
        if(this.frequency != p.frequency)
            return -(this.frequency-p.frequency);
        
        return this.str.compareTo(p.str);
        
    }
    
}


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        List<String> ans = new ArrayList<>();
        
        for(int i=0;i<words.length;i++)
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue();
        
        for(String s:hm.keySet())
            maxHeap.add(new Pair(s,hm.get(s)));
        
        
        while(k>0){
            Pair temp = maxHeap.poll();
            ans.add(temp.str);
            k-=1;
        }
        return ans;
    }
}
