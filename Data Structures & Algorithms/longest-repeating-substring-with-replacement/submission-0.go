func characterReplacement(s string, k int) int {
    freq := map[byte]int{}
    maxFreq, sol := 0, 0
    for l, r := 0, 0; r < len(s); r++ {
        freq[s[r]] = freq[s[r]]+1
        maxFreq = max(maxFreq, freq[s[r]])

        for (r-l+1) - maxFreq > k {
            freq[s[l]]--
            l++
        }

        sol = max(sol, (r-l+1));
    }
    return sol
}
