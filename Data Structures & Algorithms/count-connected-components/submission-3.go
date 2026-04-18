type Union struct {
    parents []int
}

func (this *Union) find(i int) int {
    if this.parents[i] == i { return i }
    fmt.Println("Here")
    this.parents[i] = this.find(this.parents[i])
    return this.parents[i]
}

func (this *Union) connect(i, j int) {
    ip, jp := this.find(i), this.find(j)
    this.parents[jp] = ip
}

func countComponents(n int, edges [][]int) int {
    union := Union{ parents: make([]int, n, n) }

    for i := 0; i < n; i++ { union.parents[i] = i }

    for _, edge := range edges {
        union.connect(edge[0], edge[1])
    }

    fmt.Println(union.parents)

    count := make(map[int]bool)
    for _, p := range union.parents {
        x := union.find(p)
        if _, ok := count[x]; !ok {
            count[x] = true
        }
    }

    return len(count)
}
