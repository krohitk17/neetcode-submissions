func generateParenthesis(n int) []string {
    res := []string{}

    var bt func (curr []byte, open int, total int)
    bt = func (curr []byte, open int, total int) {
        if len(curr) == 2*n {
            res = append(res, string(curr))
            return
        }
        if total < n {
            bt(append(curr, '('), open+1, total+1)
        }
        if open > 0 {
            bt(append(curr, ')'), open-1, total)
        }
    }

    bt([]byte{}, 0, 0)
    return res
}
