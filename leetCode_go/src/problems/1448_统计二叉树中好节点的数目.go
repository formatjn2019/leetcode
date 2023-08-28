package problems

func goodNodes(root *TreeNode) int {
	var dfs func(*TreeNode, int) int
	dfs = func(node *TreeNode, maxValue int) int {
		if node == nil {
			return 0
		}
		if node.Val >= maxValue {
			return dfs(node.Left, node.Val) + dfs(node.Right, node.Val) + 1
		} else {
			return dfs(node.Left, maxValue) + dfs(node.Right, maxValue)
		}
	}
	return dfs(root, -(1 << 20))
}
