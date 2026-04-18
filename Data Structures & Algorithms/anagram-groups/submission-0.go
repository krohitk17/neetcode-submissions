func groupAnagrams(strs []string) [][]string {
	hashmap := map[[26]int][]string{}

	for _, s := range strs {
		freq := [26]int{}

		for _, x := range s {
			freq[int(x)-int('a')]++
		}

		hashmap[freq] = append(hashmap[freq], s)
	}

	sol := [][]string{}

	for _, group := range hashmap {
		sol = append(sol, group)
	}

	return sol
}