func insert(intervals [][]int, newInterval []int) [][]int {
    sol := [][]int{}
    for i, interval := range intervals {
        if newInterval[1] < interval[0] {
            sol = append(sol, newInterval)
            return append(sol, intervals[i:]...)
        } else if newInterval[0] > interval[1] {
            sol = append(sol, interval)
        } else {
            if intervals[i][0] < newInterval[0] {
			    newInterval[0] = intervals[i][0]
			}
			if intervals[i][1] > newInterval[1] {
    			newInterval[1] = intervals[i][1]
			}
        }
    }
    sol = append(sol, newInterval)
    return sol
}
