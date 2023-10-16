package problems

func boundaryOfBinaryTree(root *TreeNode) []int {
	var result []int
	var dfsl func(selected bool, root *TreeNode)
	var dfsr func(selected bool, root *TreeNode)
	// 前序遍历找左边界及叶节点
	dfsl = func(selected bool, node *TreeNode) {
		if node == nil {
			return
		}
		// 叶子节点 或者被选中
		if selected || node.Left == node.Right {
			result = append(result, node.Val)
		}
		dfsl(selected, node.Left)
		dfsl(selected && node.Left == nil, node.Right)

	}
	// 后序遍历找右边界及叶节点
	dfsr = func(selected bool, node *TreeNode) {
		if node == nil {
			return
		}
		dfsr(selected && node.Right == nil, node.Left)
		dfsr(selected, node.Right)
		// 叶子节点 或者被选中
		if node.Left == node.Right || selected {
			result = append(result, node.Val)
		}
	}
	result = append(result, root.Val)
	dfsl(true, root.Left)
	dfsr(true, root.Right)
	return result
}
