class Solution {
    public int evalRPN(String[] tokens) {
        return dfs(new ArrayList<>(Arrays.asList(tokens)));
    }

    int dfs(List<String> tokens) {
        String token = tokens.remove(tokens.size()-1);

        System.out.println(token);

        if (!"+-/*".contains(token)) return Integer.parseInt(token);
        else return solve(token.charAt(0), dfs(tokens), dfs(tokens));
    }

    int solve(char op, int y, int x) {
        if (op == '+') return x + y;
        if (op == '-') return x - y;
        if (op == '*') return x * y;
        if (op == '/' && y != 0) return x / y;
        return 0;
    }
}
