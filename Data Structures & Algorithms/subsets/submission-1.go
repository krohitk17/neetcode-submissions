func subsets(nums []int) [][]int {
    n, sol, curr := len(nums), [][]int{}, []int{}

    var bt func (i int)
    bt = func (i int) {
        if i == n {
            sol = append(sol, append([]int{}, curr...))
            return
        }
        curr = append(curr, nums[i])
        bt(i+1)
        curr = curr[:len(curr)-1]
        bt(i+1)
    }

    bt(0)
    return sol
}
