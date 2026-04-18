class TimeMap {
    class Value {
        String value;
        int timestamp;

        public Value(String v, int t) {
            this.value = v;
            this.timestamp = t;
        }
    }

    Map<String, List<Value>> store;

    public TimeMap() {
        this.store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (this.store.containsKey(key)) this.store.get(key).add(new Value(value, timestamp));
        else this.store.put(key, new ArrayList(Arrays.asList(new Value(value, timestamp))));
    }
    
    public String get(String key, int timestamp) {
        if (this.store.containsKey(key)) {
            List<Value> values = this.store.get(key);
            for (int i = values.size()-1; i >= 0; i--) {
                if (values.get(i).timestamp <= timestamp) return values.get(i).value;
            }
        }
        return "";
    }
}
