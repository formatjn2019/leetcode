package problems

func diameter(root *Node) int {
	var result int
	var dfs func(node *Node) int
	dfs = func(node *Node) int {
		if node == nil {
			return 0
		}
		mx1, mx2 := 0, 0
		for _, child := range node.Children {
			t := dfs(child)
			if t > mx1 {
				mx1, mx2 = t, mx1
			} else if t > mx2 {
				mx2 = t
			}
		}
		if tr := mx1 + mx2; tr > result {
			result = tr
		}
		return mx1 + 1
	}
	dfs(root)
	return result
}
