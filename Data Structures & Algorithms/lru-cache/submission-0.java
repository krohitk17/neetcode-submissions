class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    Node head, tail;
    int cap;

    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cap = capacity;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void moveToHead(Node node) {
        if (this.head.next == node) return;

        this.head.next.prev = node;
        node.next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
    }
    
    public int get(int key) {
        if (this.map.containsKey(key)) {
            Node cache = this.map.get(key);
            this.remove(cache);
            this.moveToHead(cache);
            return cache.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node cache = this.map.get(key);
            cache.val = value;
            this.remove(cache);
            this.moveToHead(cache);
        } else {
            Node cache = new Node(key, value);
            if (this.map.size() == this.cap) {
                this.map.remove(this.tail.prev.key);
                this.remove(this.tail.prev);
            }
            this.map.put(key, cache);
            this.moveToHead(cache);
            if (this.tail.prev == this.head) this.tail.prev = cache;
        }
    }
}
