class DynamicArray {
    int[] arr;
    int size;

    public DynamicArray(int capacity) {
        this.size = 0;
        this.arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if (this.size == this.arr.length) this.resize();
        this.arr[this.size++] = n;
    }

    public int popback() {
        System.out.println(this.size-1 + " " + this.arr[this.size-1]);
        return this.arr[--this.size];
    }

    private void resize() {
        int[] tmp = new int[2*this.arr.length];
        System.arraycopy(this.arr, 0, tmp, 0, this.arr.length);
        this.arr = tmp;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.arr.length;
    }
}
