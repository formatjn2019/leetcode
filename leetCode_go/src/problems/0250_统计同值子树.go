package problems

func countUnivalSubtrees(root *TreeNode) int {
	var result int
	var dfs func(node *TreeNode) (bool, int)
	dfs = func(node *TreeNode) (it bool, n int) {
		if node == nil {
			return true, 0
		}
		it, n = true, node.Val
		if le, ln := dfs(node.Left); node.Left != nil {
			it = it && le
			if ln != node.Val {
				it = false
			}
		}
		if re, rn := dfs(node.Right); node.Right != nil {
			it = it && re
			if rn != node.Val {
				it = false
			}
		}
		if it {
			result++
		}
		return
	}
	dfs(root)
	return result
}
