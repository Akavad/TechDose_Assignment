class DLLNode{
    int key;
    int val;
    DLLNode next;
    DLLNode prev;

    public DLLNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    DLLNode head;
    DLLNode tail;
    Map<Integer, DLLNode> map;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        DLLNode node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            remove(map.get(key));
        }

        DLLNode node = new DLLNode(key, value);
        add(node);
        map.put(key, node);
        

        if(map.size()>capacity){
            DLLNode temp = head;
            remove(temp);
            map.remove(temp.key);
        }

    }

    public void add(DLLNode node){
        if(head == null){
            head = node;
        }
        else if(tail == null){
            head.next = node;
            node.prev = head;
            tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
            node.next = null;
           
        }
        
    }

    public void remove(DLLNode node){
        if(node.prev == null && node.next == null){
            head = null;
            tail = null;
        }
        else if(node.prev == null){
            head = node.next;
            node.next = null;
            head.prev = null;
            tail = head == tail ? null : tail;
        }
        else if(node.next == null){
            tail = node.prev;
            node.prev = null;
            tail.next = null;
            tail = head == tail ? null : tail;
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
    }
}
