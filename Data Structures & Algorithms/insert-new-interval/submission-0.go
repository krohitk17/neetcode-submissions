func insert(intervals [][]int, newInterval []int) [][]int {
    sol := [][]int{}
    for i, interval := range intervals {
        if newInterval[1] < interval[0] {
            sol = append(sol, newInterval)
            return append(sol, intervals[i:]...)
        } else if newInterval[0] > interval[1] {
            sol = append(sol, interval)
        } else {
            newInterval = []int{
                min(newInterval[0], interval[0]),
                max(newInterval[1], interval[1]),
            }
        }
    }
    sol = append(sol, newInterval)
    return sol
}
