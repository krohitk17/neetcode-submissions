// type Union struct {
//     parents []int
// }

// func (this *Union) find(i int) int {
//     if this.parents[i] != i {
//         this.parents[i] = this.find(this.parents[i])
//     }
//     return this.parents[i]
// }

// func (this *Union) connect(i, j int) {
//     ip, jp := this.find(i), this.find(j)
//     if ip != jp {
//         this.parents[jp] = ip
//     }
// }

// func countComponents(n int, edges [][]int) int {
//     union := Union{ parents: make([]int, n, n) }

//     for i := 0; i < n; i++ { union.parents[i] = i }

//     for _, edge := range edges {
//         union.connect(edge[0], edge[1])
//     }

//     count := make(map[int]bool)
//     for _, p := range union.parents {
//         // x := union.find(p)
//         count[p] = true
//     }

//     return len(count)
// }

type DSU struct {
    parent []int
}

func NewDSU(n int) *DSU {
    p := make([]int, n)
    for i := 0; i < n; i++ {
        p[i] = i
    }
    return &DSU{p}
}

func (d *DSU) find(x int) int {
    if d.parent[x] != x {
        d.parent[x] = d.find(d.parent[x])
    }
    return d.parent[x]
}

func (d *DSU) union(a, b int) {
    pa, pb := d.find(a), d.find(b)
    if pa != pb {
        d.parent[pa] = pb
    }
}

func countComponents(n int, edges [][]int) int {
    dsu := NewDSU(n)
    for _, e := range edges {
        dsu.union(e[0], e[1])
    }

    roots := map[int]bool{}
    for i := 0; i < n; i++ {
        roots[dsu.find(i)] = true
    }
    return len(roots)
}

