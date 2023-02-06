package problems

func EvaluateTree(root *TreeNode) bool {
	return evaluateTree(root)
}
func evaluateTree(root *TreeNode) bool {
	if root == nil {
		panic("输入有误")
	}
	switch root.Val {
	case 0:
		return false
	case 1:
		return true
	case 2:
		return evaluateTree(root.Left) || evaluateTree(root.Right)
	default:
		return evaluateTree(root.Left) && evaluateTree(root.Right)
	}
}
