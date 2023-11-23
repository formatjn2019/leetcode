package problems

func checkTree(root *TreeNode) bool {
	var getSum func(root *TreeNode) int
	getSum = func(rt *TreeNode) int {
		if rt == nil {
			return 0
		}
		return rt.Val + getSum(rt.Left) + getSum(rt.Right)
	}
	return getSum(root) == root.Val*2
}
