//841. Keys and Rooms
import java.util.*;

class Solution {

    public boolean Util(List<List<Integer>> rooms,boolean[] visited,int index){
                
        visited[index] = true;
        for(Integer a:rooms.get(index)){
            if(visited[a] != true && Util(rooms,visited,a))
                return true;
        }

        for(int i=0;i<visited.length;i++){
            if(visited[i] == false)
                break;
            if(i == visited.length-1)
                return true;
        }



        return false;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        return Util(rooms,visited,0);

    }
}
