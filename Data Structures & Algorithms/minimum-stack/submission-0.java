class MinStack {
    List<Integer> stack, min;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.min = new ArrayList<>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        if (this.min.size() > 0) {
            if (val < this.min.get(this.min.size()-1)) this.min.add(val);
            else this.min.add(this.min.get(this.min.size()-1));
        } else {
            this.min.add(val);
        }
    }
    
    public void pop() {
        this.stack.remove(this.stack.size()-1);
        this.min.remove(this.min.size()-1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size()-1);
    }
    
    public int getMin() {
        return this.min.get(this.min.size()-1);
    }
}
