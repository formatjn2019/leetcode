package problems

func reverseOddLevels(root *TreeNode) *TreeNode {
	var rev func(left, right *TreeNode, level bool)

	rev = func(left, right *TreeNode, revFlag bool) {
		if left == right {
			return
		}
		if revFlag {
			left.Val, right.Val = right.Val, left.Val
		}
		rev(left.Left, right.Right, !revFlag)
		rev(left.Right, right.Left, !revFlag)
	}
	rev(root.Left, root.Right, true)
	return root
}
