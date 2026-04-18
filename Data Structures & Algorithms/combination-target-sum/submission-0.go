func combinationSum(nums []int, target int) [][]int {
    sol, curr := [][]int{}, []int{}

    sort.Ints(nums)

    var bt func (i int, sum int)
    bt = func (i int, sum int) {
        if (sum == target) {
            sol = append(sol, append([]int{}, curr...))
            return
        }

        for j := i; j < len(nums); j++ {
            if sum + nums[j] > target {
                return
            }
            curr = append(curr, nums[j])
            bt(j, sum + nums[j])
            curr = curr[:len(curr)-1]
        }
    }

    bt(0, 0)
    return sol
}
