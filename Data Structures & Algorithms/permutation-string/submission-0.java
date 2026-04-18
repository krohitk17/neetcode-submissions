class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (n < m) return false;

        int[] s1count = new int[26], s2count = new int[26];

        for (int i = 0; i < m; i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++)
            if (s1count[i] == s2count[i]) matches++;

        for (int l = 0, r = m; r < n; l++, r++) {
            if (matches == 26) return true;
            
            int index = s2.charAt(r) - 'a';
            s2count[index]++;
            if (s2count[index] == s1count[index]) matches++;
            else if (s2count[index] - 1 == s1count[index]) matches--;

            index = s2.charAt(l) - 'a';
            s2count[index]--;
            if (s2count[index] == s1count[index]) matches++;
            else if (s2count[index] + 1 == s1count[index]) matches--;
        }
        return matches == 26;
    }
}
