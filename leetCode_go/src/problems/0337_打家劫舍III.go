package problems

func Rob(root *TreeNode) int {
	return rob(root)
}
func rob(root *TreeNode) int {
	var search func(node *TreeNode) (int, int)
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	search = func(node *TreeNode) (int, int) {
		if node == nil {
			return 0, 0
		}
		maxLS, maxLU := search(node.Left)
		maxRS, maxRU := search(node.Right)
		return node.Val + maxLU + maxRU, max(maxLS, maxLU) + max(maxRS, maxRU)
	}
	maxS, maxU := search(root)
	return max(maxS, maxU)
}
