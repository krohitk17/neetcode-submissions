func findTargetSumWays(nums []int, target int) int {
	n := len(nums)

    var bt func (i, curr int) int
	bt = func (i, curr int) int {
		if i == n {
			if curr == target {
				return 1
			}
			return 0
		}

		return bt(i+1, curr + nums[i]) + bt(i+1, curr - nums[i])
	}

	return bt(0, 0)
}
