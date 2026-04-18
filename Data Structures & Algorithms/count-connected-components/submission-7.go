type Union struct {
    parents []int
}

func CreateUnion(n int) *Union {
    union := Union{ parents: make([]int, n, n) }
    for i := 0; i < n; i++ { union.parents[i] = i }
    return &union
}

func (this *Union) find(i int) int {
    if this.parents[i] != i {
        this.parents[i] = this.find(this.parents[i])
    }
    return this.parents[i]
}

func (this *Union) connect(i, j int) {
    ip, jp := this.find(i), this.find(j)
    if ip != jp {
        this.parents[jp] = ip
    }
}

func countComponents(n int, edges [][]int) int {
    union := CreateUnion(n)

    for _, edge := range edges {
        union.connect(edge[0], edge[1])
    }

    count := make(map[int]bool)
    for _, p := range union.parents {
        count[union.find(p)] = true
    }

    return len(count)
}