func numDecodings(s string) int {
    if s[0] == '0' {
        return 0
    }

    dp2, dp1 := 0, 1
    for i := range s {
        next := 0
        if s[i] != '0' {
            next += dp1
        }
        if i > 0 && isValid(s[i-1], s[i]) {
            next += dp2
        }
        dp2, dp1 = dp1, next
    }
    return dp1
}

func isValid(i, j byte) bool {
    return i != '0' && (i == '1' || (i == '2' && j-'0' <= 6))
}
