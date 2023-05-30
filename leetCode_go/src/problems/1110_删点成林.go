package problems

func delNodes(root *TreeNode, to_delete []int) []*TreeNode {
	result := make([]*TreeNode, 0)
	deleteMap := map[int]bool{}
	for _, num := range to_delete {
		deleteMap[num] = true
	}
	var dfs func(root *TreeNode) *TreeNode
	dfs = func(root *TreeNode) *TreeNode {
		if root == nil {
			return nil
		}
		root.Left = dfs(root.Left)
		root.Right = dfs(root.Right)
		if deleteMap[root.Val] {
			if root.Left != nil {
				result = append(result, root.Left)
			}
			if root.Right != nil {
				result = append(result, root.Right)
			}
			return nil
		}
		return root
	}
	if dfs(root) != nil {
		result = append(result, root)
	}
	return result
}
