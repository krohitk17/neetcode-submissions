class LinkedList {
    class Node {
        int val;
        Node next;

        public Node() {
            this.val = 0;
            this.next = null;
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    
    Node head, tail;

    public LinkedList() {
        this.head = new Node();
        this.tail = head;
    }

    public int get(int index) {
        Node ptr = this.head.next;
        while (ptr != null && index-- > 0) {
            ptr = ptr.next;
        }
        return ptr != null ? ptr.val : -1;
    }

    public void insertHead(int val) {
        Node node = new Node(val, this.head.next);
        this.head.next = node;
        if (this.tail == this.head) this.tail = node;
    }

    public void insertTail(int val) {
        if (this.tail == this.head) {
            this.insertHead(val);
        } else {
            Node node = new Node(val);
            this.tail.next = node;
            this.tail = node;
        }
    }

    public boolean remove(int index) {
        Node ptr = this.head.next, prev = this.head;
        while (ptr != null && index-- > 0) {
            prev = ptr;
            ptr = ptr.next;
        }
        if (ptr == null) return false;

        prev.next = ptr.next;
        if (this.tail == ptr) this.tail = prev;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();

        Node ptr = this.head.next;
        while (ptr != null) {
            values.add(ptr.val);
            ptr = ptr.next;
        }

        return values;
    }
}
