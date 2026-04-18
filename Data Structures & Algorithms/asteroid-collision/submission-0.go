func asteroidCollision(asteroids []int) []int {
    n := len(asteroids)
	res := make([]int, 0, n)

    for _, i := range asteroids {
        if i > 0 {
            res = append(res, i)
        } else {
            for j := len(res)-1; j >= 0 && res[j] > 0 && res[j] <= -i; j-- {
                if res[j] == -i {
                    res = res[:j]
                    i = 0
                    break
                }
                res = res[:j]
            }
            if i != 0 && (len(res) == 0 || res[len(res)-1] < 0) {
                res = append(res, i)
            }
        }
    }

    return res
}
