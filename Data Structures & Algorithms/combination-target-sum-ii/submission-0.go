func combinationSum2(nums []int, target int) [][]int {
    n, sol, curr := len(nums), [][]int{}, []int{}

    sort.Ints(nums)

    var bt func (i int, sum int)
    bt = func (i int, sum int) {
        if (sum == target) {
            sol = append(sol, append([]int{}, curr...))
            return
        }

        for j := i; j < n; j++ {
            if sum + nums[j] > target {
                return
            }
            curr = append(curr, nums[j])
            bt(j+1, sum + nums[j])
            curr = curr[:len(curr)-1]
            for j < n-1 && nums[j] == nums[j+1] {
                j++
            }
        }
    }

    bt(0, 0)
    return sol
}
