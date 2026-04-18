func longestCommonSubsequence(text1 string, text2 string) int {
	m, n := len(text1), len(text2)
	if n > m {
		text1, text2 = text2, text1
		m, n = n, m
	}

	dp := make([]int, n+1)
	prev := 0
	for i := 0; i < m; i++ {
		prev = 0
		for j := 0; j < n; j++ {
			curr := 0
			if text1[i] == text2[j] {
				curr = dp[j] + 1
			} else {
				curr = max(prev, dp[j+1])
			}
			dp[j] = prev
			prev = curr
		}
		dp[n] = prev
	}

	return dp[n]
}
