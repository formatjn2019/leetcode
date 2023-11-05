package problems

func LargestBSTSubtree(root *TreeNode) int {
	return largestBSTSubtree(root)
}

func largestBSTSubtree(root *TreeNode) int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	var dfs func(node *TreeNode) (isBT bool, minV, maxV, count int)
	var result int
	dfs = func(node *TreeNode) (isBT bool, minV, maxV, count int) {
		if node == nil {
			return true, 0, 0, 0
		}
		minV, maxV = node.Val, node.Val
		lf, lmin, lmax, lc := dfs(node.Left)
		rf, rmin, rmax, rc := dfs(node.Right)
		flag := lf && rf
		// 更新极值
		if lc > 0 {
			if lmax >= node.Val {
				flag = false
			}
			minV = min(minV, lmin)
			maxV = max(maxV, lmax)
		}
		if rc > 0 {
			if rmin <= node.Val {
				flag = false
			}
			minV = min(minV, rmin)
			maxV = max(maxV, rmax)
		}

		if flag && lc+rc+1 > result {
			result = lc + rc + 1
		}
		return flag, minV, maxV, lc + rc + 1
	}
	dfs(root)
	return result
}
