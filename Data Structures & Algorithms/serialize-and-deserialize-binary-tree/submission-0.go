/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Codec struct {}

func Constructor() Codec {
    return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
    if root == nil {
        return "N,"
    }

    codec := strconv.Itoa(root.Val) + "," +
        this.serialize(root.Left) + this.serialize(root.Right)
    
    fmt.Println(codec)
    return codec
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
    var dfs func () *TreeNode
    dfs = func () *TreeNode {
        if data[0] == 'N' {
            data = data[2:]
            return nil
        }

        node := &TreeNode{}
        val, ind := 0, 0

        for i := 0; i < len(data) && data[i] != ','; i++ {
            ind++
            val *= 10
            val += int(data[i] - '0')
        }

        node.Val = val
        data = data[ind+1:]
        node.Left = dfs()
        node.Right = dfs()

        return node
    }
    
    return dfs()
}
