package problems

func findLeaves(root *TreeNode) [][]int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	result := make([][]int, 0)
	var dfs func(node *TreeNode) int
	dfs = func(node *TreeNode) int {
		if node == nil {
			return 0
		}
		dep := max(dfs(node.Left), dfs(node.Right))
		if dep == len(result) {
			result = append(result, make([]int, 0))
		}
		result[dep] = append(result[dep], node.Val)
		return dep + 1
	}
	dfs(root)
	return result
}
