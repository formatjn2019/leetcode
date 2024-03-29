package problems

func LongestUnivaluePath(root *TreeNode) int {
	return longestUnivaluePath(root)
}

func longestUnivaluePath(root *TreeNode) int {
	if root == nil {
		return 0
	}

	max := func(x, y int) int {
		if x > y {
			return x
		} else {
			return y
		}
	}

	var dfsSearch func(*TreeNode) (int, int)

	dfsSearch = func(root *TreeNode) (int, int) {
		if root == nil {
			return 0, 0
		} else {
			ld, rd := 1, 1
			lfm, lfd := dfsSearch(root.Left)
			rtm, rtd := dfsSearch(root.Right)
			mxm := max(max(lfm, rtm), 1)
			//左子树非空且同值
			if root.Left != nil && root.Left.Val == root.Val {
				ld = ld + lfd
			}
			//右子树非空且同值
			if root.Right != nil && root.Right.Val == root.Val {
				rd = rd + rtd
			}
			mxm = max(max(ld, rd), mxm)
			if ld > 1 && rd > 1 && mxm < ld+rd-1 {
				mxm = ld + rd - 1
			}
			return mxm, max(ld, rd)
		}
	}
	result, _ := dfsSearch(root)
	return result - 1
}
