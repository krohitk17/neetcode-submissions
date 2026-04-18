func characterReplacement(s string, k int) int {
    freq := map[byte]int{}
    maxFreq, sol := 0, 0
    for l, r := 0, 0; r < len(s); r++ {
        freq[s[r]]++
        if maxFreq < freq[s[r]] {
            maxFreq = freq[s[r]]
        }

        for (r-l+1) - maxFreq > k {
            freq[s[l]]--
            l++
        }

        if sol < (r-l+1) {
            sol = r-l+1
        }
    }
    return sol
}
