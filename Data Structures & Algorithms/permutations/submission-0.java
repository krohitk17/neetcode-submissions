class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        bt(nums, new ArrayList<>(), new HashSet<>(), sol);
        return sol;
    }

    void bt(int[] nums, List<Integer> curr, Set<Integer> visited, List<List<Integer>> sol) {
        if (curr.size() == nums.length) {
            sol.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) continue;
            curr.add(nums[i]);
            visited.add(i);
            bt(nums, curr, visited, sol);
            visited.remove(i);
            curr.remove(curr.size()-1);
        }
    }
}
