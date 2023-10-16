package problems

func longestConsecutive1(root *TreeNode) int {
	result := 1
	var dfs func(n *TreeNode, pv, cn int)
	dfs = func(n *TreeNode, pv, cn int) {
		if cn > result {
			result = cn
		}
		if n == nil {
			return
		}
		if n.Val == pv+1 {
			cn += 1
		} else {
			cn = 1
		}
		dfs(n.Left, n.Val, cn)
		dfs(n.Right, n.Val, cn)
	}
	dfs(root, -1000000, 1)
	return result
}
