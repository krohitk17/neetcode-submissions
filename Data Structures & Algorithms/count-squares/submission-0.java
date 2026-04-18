class CountSquares {
    Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        this.points = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        this.points.computeIfAbsent(x, key -> new HashMap<>())
            .put(y, this.points.get(x).getOrDefault(y, 0)+1);
    }
    
    public int count(int[] point) {
        int x1 = point[0], y1 = point[1], count = 0;
        if (!this.points.containsKey(x1)) return count;

        for (int y2 : this.points.get(x1).keySet()) {
            int side = y2 - y1;
            // same point
            if (side == 0) continue;

            int x2pos = x1 + side, x2neg = x1 - side;

            count += this.points.get(x1).get(y2) *
                this.points.getOrDefault(x2pos, new HashMap<>()).getOrDefault(y1, 0) *
                this.points.getOrDefault(x2pos, new HashMap<>()).getOrDefault(y2, 0);
            count += this.points.get(x1).get(y2) *
                this.points.getOrDefault(x2neg, new HashMap<>()).getOrDefault(y1, 0) *
                this.points.getOrDefault(x2neg, new HashMap<>()).getOrDefault(y2, 0);
        }

        return count;
    }
}
