func countSubstrings(s string) int {
    n := len(s)
    str := make([]byte, 2*n+1)
    for i := 0; i < n; i++ {
        str[2*i] = '*'
        str[2*i+1] = s[i]
    }
    str[2*n] = '*'
    fmt.Println(str)
    n = len(str)
    p := make([]int, n)
    l, r := 0, 0

    for i := 0; i < n; i++ {
        if i < r {
            p[i] = min(r - i, p[l + r - i])
        }
        for i + p[i] + 1 < n && i - p[i] - 1 >= 0 &&
            str[i + p[i] + 1] == str[i - p[i] - 1] {
            p[i]++
        }
        if i + p[i] > r {
            l, r = i - p[i], i + p[i]
        }
    }
    fmt.Println(p)
    sol := 0
    for _, i := range p {
        sol += (i+1)/2
    }
    return sol
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
