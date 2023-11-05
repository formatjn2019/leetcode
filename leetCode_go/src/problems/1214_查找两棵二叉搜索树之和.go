package problems

func twoSumBSTs(root1 *TreeNode, root2 *TreeNode, target int) bool {
	var dfs1 func(node *TreeNode)
	var dfs2 func(node *TreeNode) bool
	memMap := map[int]bool{}
	dfs1 = func(node *TreeNode) {
		if node == nil {
			return
		}
		memMap[node.Val] = true
		dfs1(node.Left)
		dfs1(node.Right)
	}
	dfs2 = func(node *TreeNode) bool {
		if node == nil {
			return false
		}
		if memMap[target-node.Val] {
			return true
		}
		return dfs2(node.Left) || dfs2(node.Right)
	}
	dfs1(root1)
	return dfs2(root2)
}
