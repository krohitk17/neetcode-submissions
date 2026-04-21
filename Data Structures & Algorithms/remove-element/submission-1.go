func removeElement(nums []int, val int) int {
    n := len(nums)
	for n > 0 && nums[n-1] == val {
		n--
	}

	for i := 0; i < n;  {
		if nums[i] == val {
			n--
			nums[i] = nums[n]
		} else {
			i++
		}
	}
	return n
}
