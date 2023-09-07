package problems

func LcaDeepestLeaves(root *TreeNode) *TreeNode {
	return lcaDeepestLeaves(root)
}

func lcaDeepestLeaves(root *TreeNode) *TreeNode {
	var dfs func(root *TreeNode, depth int) int
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	var result *TreeNode
	maxDepth := -1
	dfs = func(node *TreeNode, depth int) int {
		if node == nil {
			return depth
		}
		ld, rd := dfs(node.Left, depth+1), dfs(node.Right, depth+1)
		if ld == rd && ld >= maxDepth {
			maxDepth = ld
			result = node
		}
		return max(ld, rd)
	}
	dfs(root, 0)
	return result
}
