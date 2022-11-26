//223. Rectangle Area


class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = Math.abs(ax1-ax2)*Math.abs(ay1-ay2);//6*4=24
        int b = Math.abs(bx1-bx2)*Math.abs(by1-by2);//9*3=27
        int common_x=0,common_y=0;
        
        //Merge Overlapping intervals
        //Calculate overlapping intervals seperately on x and y axis and multiply
        //to get the common area
        if(ax1<bx1){
            if(bx1<ax2){
                common_x = Math.min(ax2,bx2)-bx1;   
            }
        }
        else{
            if(ax1<bx2){
                common_x = Math.min(ax2,bx2)-ax1;
            }
        }
        
        if(ay1<by1){
            if(by1<ay2){
                common_y = Math.min(ay2,by2)-by1;   
            }
        }
        else{
            if(ay1<by2){
                common_y = Math.min(ay2,by2)-ay1;
            }
        }
              
        return a+b-(common_x*common_y);
        
    }
}