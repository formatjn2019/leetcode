package problems

func MaxAncestorDiff(root *TreeNode) int {
	return maxAncestorDiff(root)
}
func maxAncestorDiff(root *TreeNode) int {
	result := 0
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
	var dfsSearch func(*TreeNode, int, int)
	dfsSearch = func(root *TreeNode, preMax, preMin int) {
		if root == nil {
			return
		}
		result = max(result, max(preMax-root.Val, root.Val-preMin))
		newMax, newMin := max(root.Val, preMax), min(root.Val, preMin)
		dfsSearch(root.Left, newMax, newMin)
		dfsSearch(root.Right, newMax, newMin)
	}
	dfsSearch(root, root.Val, root.Val)
	return result
}
