func coinChange(coins []int, amount int) int {
    dp := make([]int, amount+1)
	for i := range dp {
		dp[i] = amount+1
	}
	dp[0] = 0
	sort.Ints(coins)
	for _, coin := range coins {
		for i := coin; i <= amount; i++ {
			c := dp[i - coin]
			if dp[i] > c {
				dp[i] = c + 1
			}
		}
	}
	if dp[amount] == amount + 1 {
		return -1
	}
	return dp[amount]
}