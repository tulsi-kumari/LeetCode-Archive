class LRUCache {
    private class Node{
         int key,val;
        Node next,prev;
        Node(int key,int val){
           this.key=key;
            this.val=val;
        }
    }
    private void print(Node node){
        Node temp=node;
        while(temp!=null){
            System.out.print(temp.key+"-"+temp.val+" ");
            temp=temp.next;
        }
        System.out.println(this.capacity);
    }
    private void remove(Node node){
        Node nxtnbr=node.next;
        Node prevnbr=node.prev;
        prevnbr.next=nxtnbr;
        nxtnbr.prev=prevnbr;
        node.next=null;
        node.prev=null;
    }
    private void add(Node node){
        node.next=this.head.next;
        this.head.next.prev=node;
        node.prev=head;
        this.head.next=node;
    }
    private void moveToFirst(Node node){
        remove(node);
        add(node);
    }
    int capacity;
    HashMap<Integer,Node> cache;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
      this.capacity=capacity;
        this.cache=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)){
            return -1;
        }
        moveToFirst(this.cache.get(key));
        return this.cache.get(key).val;
    }
    
    public void put(int key, int value) {
        if(!this.cache.containsKey(key) && this.capacity==0){
            //System.out.println("remove"+" "+this.tail.prev.key);
            cache.remove(this.tail.prev.key);
            remove(this.tail.prev);
            
            this.capacity++;
        }
        if(!this.cache.containsKey(key)){
            Node node=new Node(key,value);
            this.cache.put(key,node);
            add(node);
            this.capacity--;
        }else{
            this.cache.get(key).val=value;
            moveToFirst(this.cache.get(key));
        }
        //print(head);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */