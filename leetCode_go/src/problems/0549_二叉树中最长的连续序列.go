package problems

func longestConsecutive(root *TreeNode) int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	var result int
	var dfs func(n *TreeNode) (ic, dc int)
	dfs = func(n *TreeNode) (ic, dc int) {
		if n == nil {
			return 0, 0
		}
		ic, dc = 1, 1
		lic, ldc := dfs(n.Left)
		ric, rdc := dfs(n.Right)
		if lic > 0 && n.Val == n.Left.Val-1 {
			ic = lic + 1
		}
		if ric > 0 && n.Val == n.Right.Val-1 {
			ic = max(ic, ric+1)
		}
		if ldc > 0 && n.Val == n.Left.Val+1 {
			dc = ldc + 1
		}
		if rdc > 0 && n.Val == n.Right.Val+1 {
			dc = max(dc, rdc+1)
		}
		result = max(ic+dc-1, result)
		return ic, dc
	}
	dfs(root)
	return result
}
