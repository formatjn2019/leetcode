package problems

func InsertIntoMaxTree(root *TreeNode, val int) *TreeNode {
	return insertIntoMaxTree(root, val)
}

func insertIntoMaxTree(root *TreeNode, val int) *TreeNode {
	if root == nil || root.Val < val {
		return &TreeNode{Val: val, Left: root}
	}
	root.Right = insertIntoMaxTree(root.Right, val)
	return root
}
