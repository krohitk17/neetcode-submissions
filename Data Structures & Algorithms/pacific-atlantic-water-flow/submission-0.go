func pacificAtlantic(heights [][]int) [][]int {
    m, n := len(heights), len(heights[0])
    
    pac, atl := make([][]bool, m), make([][]bool, m)
    for i := 0; i < m; i++ {
        pac[i] = make([]bool, n)
        atl[i] = make([]bool, n)
    }

    var dfs func (i, j int, set [][]bool, prev int)
    dfs = func (i, j int, set [][]bool, prev int) {
        if i < 0 || j < 0 || i >= m || j >= n ||
            set[i][j] || heights[i][j] < prev {
            return
        }

        set[i][j] = true
        dfs(i+1, j, set, heights[i][j])
        dfs(i-1, j, set, heights[i][j])
        dfs(i, j+1, set, heights[i][j])
        dfs(i, j-1, set, heights[i][j])
    }

    for i := 0; i < m; i++ {
        dfs(i, 0, pac, heights[i][0])
        dfs(i, n-1, atl, heights[i][n-1])
    }

    for j := 0; j < n; j++ {
        dfs(0, j, pac, heights[0][j])
        dfs(m-1, j, atl, heights[m-1][j])
    }

    sol := [][]int{}

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if pac[i][j] && atl[i][j] {
                sol = append(sol, []int{i, j})
            }
        }
    }

    return sol
}