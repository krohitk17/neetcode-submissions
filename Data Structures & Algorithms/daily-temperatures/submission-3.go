func dailyTemperatures(arr []int) []int {
	n := len(arr)
	stack := make([]int, 0, n)
	sol := make([]int, n)

	for i := 0; i < n; i++ {
		// fmt.Println(stack, i, sol)
		for len(stack) > 0 && arr[i] > arr[stack[len(stack) - 1]] {
			j := stack[len(stack) - 1]
			// fmt.Println(j)
			sol[j] = i - j
			stack = stack[:len(stack) - 1]
		}
		stack = append(stack, i)
	}
	return sol
}
