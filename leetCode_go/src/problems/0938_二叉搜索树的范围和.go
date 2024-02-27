package problems

func rangeSumBST(root *TreeNode, low int, high int) int {
	var result int
	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		if node.Val >= low && node.Val <= high {
			result += node.Val
			dfs(node.Left)
			dfs(node.Right)
		}
		if node.Val < low {
			dfs(node.Right)
		}
		if node.Val > high {
			dfs(node.Left)
		}
	}
	dfs(root)
	return result
}
