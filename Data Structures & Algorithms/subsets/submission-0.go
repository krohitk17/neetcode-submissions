func subsets(nums []int) [][]int {
    n, sol := len(nums), [][]int{}

    var bt func (start int, curr []int)
    bt = func (start int, curr []int) {
        sol = append(sol, append([]int{}, curr...))
        if start == n {
            return
        }
        for i := start; i < n; i++ {
            curr = append(curr, nums[i])
            bt(i+1, curr)
            curr = curr[:len(curr)-1]
        }
    }

    bt(0, []int{})
    return sol
}
