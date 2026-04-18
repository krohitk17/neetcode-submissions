import "slices"

func merge(intervals [][]int) [][]int {
    slices.SortFunc(intervals, func(a, b []int) int {
		if a[0] == b[0] {
            return a[1] - b[1]
        }
        return a[0] - b[0]
	})

    sol := [][]int{intervals[0]}

    for _, interval := range intervals[1:] {
        start, end := interval[0], interval[1]
        lastEnd := sol[len(sol)-1][1]

        if start <= lastEnd {
            sol[len(sol)-1][1] = max(lastEnd, end)
        } else {
            sol = append(sol, []int{start, end})
        }
    }

    return sol
}
