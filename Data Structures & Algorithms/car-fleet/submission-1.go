import "slices"

func carFleet(target int, position []int, speed []int) int {
	n := len(speed)
	cars := make([][]int, n)

	for i := 0; i < n; i++ {
		cars[i] = []int{position[i], speed[i]}
	}

	slices.SortFunc(cars, func (a, b []int) int {
		return b[0] - a[0]
	})

	prev, fleets := 0.0, 0
	for i := 0; i < n; i++ {
		time := float64(target - cars[i][0])/float64(cars[i][1])
		if time > prev {
			prev = time
			fleets++
		}
	}

	return fleets
}