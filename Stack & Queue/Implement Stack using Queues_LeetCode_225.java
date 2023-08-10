class MyStack {

    Queue<Integer>  q1;
    Queue<Integer>  q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        int top =  q1.poll();
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        return top;
    }
    
    public int top() {
        int top = pop();
        q1.add(top);
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

