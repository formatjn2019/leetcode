package problems

func mergeTrees(root1 *TreeNode, root2 *TreeNode) *TreeNode {
	if root1 != nil && root2 != nil {
		return &TreeNode{root1.Val + root2.Val, mergeTrees(root1.Left, root2.Left), mergeTrees(root1.Right, root2.Right)}
	} else if root1 != nil {
		return root1
	} else {
		return root2
	}
}
