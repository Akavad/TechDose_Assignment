class Server{
    int time;
    int weight;
    int index;
    Server(int weight, int index, int time){
        this.weight= weight;
        this.index = index;
        this.time = time;
    }
}

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        PriorityQueue<Server> availableServer = new PriorityQueue<>((s1,s2)-> s1.weight!=s2.weight ? s1.weight-s2.weight : s1.index-s2.index);

        PriorityQueue<Server> runningServer = new PriorityQueue<>((s1,s2)->s1.time != s2.time ? s1.time-s2.time : s1.weight != s2. weight ? s1.weight - s2.weight : s1.index-s2.index);
        
        int n = tasks.length;
        int ans[] = new int[n];

        for(int i=0;i<servers.length;i++){
            availableServer.add(new Server(servers[i],i,0));
        }

        for(int i=0;i<n;i++){

            while(!runningServer.isEmpty() && runningServer.peek().time <= i){
                availableServer.add(runningServer.poll());
            }

            if(!availableServer.isEmpty()){

                Server currentServer = availableServer.poll();
                ans[i]= currentServer.index;
                currentServer.time = i+tasks[i];

                runningServer.add(currentServer);

            }
            else{

                Server currentServer = runningServer.poll();
                ans[i] = currentServer.index;
                currentServer.time+=tasks[i];
                runningServer.add(currentServer);
            }

        }

        return ans;
    }
}