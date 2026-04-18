func leastInterval(tasks []byte, n int) int {
    freq := [26]int{}
    maxfreq, maxcount := 0, 0
    for _, task := range tasks {
        ind := task - 'A'
        freq[ind]++
        if freq[ind] > maxfreq {
            maxfreq = freq[ind]
            maxcount = 0
        }
        if freq[ind] == maxfreq {
            maxcount++
        }
    }

    time := (maxfreq - 1) * (n + 1) + maxcount

    if time < len(tasks) {
        return len(tasks)
    }

    return time
}