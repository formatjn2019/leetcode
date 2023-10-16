package problems

func maximumAverageSubtree(root *TreeNode) float64 {
	var result float64
	var dfs func(node *TreeNode) (sum int64, con int)

	dfs = func(node *TreeNode) (sum int64, con int) {
		if node == nil {
			return 0, 0
		}
		ls, lc := dfs(node.Left)
		rs, rc := dfs(node.Right)
		sum = ls + rs + int64(node.Val)
		con = lc + rc + 1
		avg := float64(sum) / float64(con)
		if avg > result {
			result = avg
		}
		return sum, con
	}

	dfs(root)
	return result
}
