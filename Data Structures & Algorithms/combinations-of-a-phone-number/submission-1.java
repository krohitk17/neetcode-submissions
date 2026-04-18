class Solution {
    Map<Character, String> letters = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> sol = new ArrayList<>();
        if (digits.length() > 0) bt(0, digits, new StringBuilder(), sol);
        return sol;
    }

    void bt(int i, String digits, StringBuilder curr, List<String> sol) {
        if (i == digits.length()) {
            sol.add(curr.toString());
            return;
        }

        for (char c : letters.get(digits.charAt(i)).toCharArray()) {
            curr.append(c);
            bt(i+1, digits, curr, sol);
            curr.deleteCharAt(i);
        }
    }
}
