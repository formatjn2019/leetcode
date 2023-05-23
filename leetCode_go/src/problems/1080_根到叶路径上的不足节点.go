package problems

func SufficientSubset(root *TreeNode, limit int) *TreeNode {
	return sufficientSubset(root, limit)
}
func sufficientSubset(root *TreeNode, limit int) *TreeNode {
	if root == nil {
		return nil
	}
	//根节点
	if root.Left == root.Right {
		if root.Val < limit {
			return nil
		} else {
			return root
		}
	} else {
		root.Left = sufficientSubset(root.Left, limit-root.Val)
		root.Right = sufficientSubset(root.Right, limit-root.Val)
		if root.Left == root.Right {
			return nil
		} else {
			return root
		}
	}
}
