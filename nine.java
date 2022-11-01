//Satisfiability of equality equation || Graph theory


class nine {
    
    int[] parent;
    int[] Rank;
    
    //findind parent
    int findParent(int u){
        
        if(parent[u] == u)
            return u;
        
        return parent[u] = findParent(parent[u]);
        
    }
    
    
    //finding union
    void union(int a,int b){
        a = findParent(a);
        b = findParent(b);
        
        if(Rank[a]<Rank[b])
            parent[a] = b;
        else if(Rank[a]>Rank[b])
            parent[b] = a;
        //since depth increases only when two nodes of same rank are joined
        else{
            parent[a] = b;
            Rank[b]+=1;
        }
    }
    
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        Rank   = new int[26];
        
        //initializing the rank and parent arrays
        for(int i=0;i<26;i++){
            parent[i] = i;
            Rank[i] = 0;
        }
        
        
        //Finding union of all the euality functions
        //i.e all the variables with same value must belong to same set
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1) == '='){
                union(equations[i].charAt(0)-'a',equations[i].charAt(3)-'a');
            }
        }
        
        
        //If two variables belong to the same set but an inequality condtion is given 
        //then return false because two variables cannot be equal and not equal at the same time
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1) == '!' && findParent(equations[i].charAt(0)-'a') == findParent(equations[i].charAt(3)-'a'))
                return false;
        }
        
        return true;
    }
}