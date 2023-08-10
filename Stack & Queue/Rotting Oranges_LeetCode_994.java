class Solution {
    class Point{        
        int x;
        int y;   
        
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] grid) {
        
        Queue<Point> q = new LinkedList<>();
        int x[] = new int[]{0,0,1,-1};
        int y[] = new int[]{1,-1,0,0};
        int count =0;
        
        for(int i=0;i<grid.length;i++){
            
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j]==2){
                    q.add(new Point(i,j));
                }
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean timeFlag = false;
            
            for(int i=0;i<size;i++){
                Point p = q.remove();
                
                for(int k=0;k<4;k++){
                    int newX = p.x+x[k];
                    int newY = p.y+y[k];
                    
                    if(newX>=0 && newY>=0 && newX< grid.length && newY<grid[0].length && grid[newX][newY]==1){
                   
                 q.add(new Point(newX, newY));
                        grid[newX][newY]=2;
                             if(!timeFlag){
                            count++;
                            timeFlag = true;
                        }
                    }
                }
            }
        }
        
               for(int i=0;i<grid.length;i++){
            
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return count;
    }
}