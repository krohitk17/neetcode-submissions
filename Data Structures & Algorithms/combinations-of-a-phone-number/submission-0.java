class Solution {
    Map<Character, Character[]> letters = Map.of(
        '2', new Character[]{'a', 'b', 'c'},
        '3', new Character[]{'d', 'e', 'f'},
        '4', new Character[]{'g', 'h', 'i'},
        '5', new Character[]{'j', 'k', 'l'},
        '6', new Character[]{'m', 'n', 'o'},
        '7', new Character[]{'p', 'q', 'r', 's'},
        '8', new Character[]{'t', 'u', 'v'},
        '9', new Character[]{'w', 'x', 'y', 'z'});

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

        for (char c : letters.get(digits.charAt(i))) {
            curr.append(c);
            bt(i+1, digits, curr, sol);
            curr.deleteCharAt(i);
        }
    }
}
