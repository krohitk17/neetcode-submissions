func majorityElement(nums []int) int {
    res, count := 0, 0

	for _, i := range nums {
		if count == 0 {
			res = i
		}
		if i == res {
			count++
		} else {
			count--
		}
	}

	return res
}
