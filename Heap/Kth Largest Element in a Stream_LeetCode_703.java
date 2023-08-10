class KthLargest {

    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
        
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size()>k){
            heap.poll();
        }
        return heap.peek();
    }
}
