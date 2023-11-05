package problems

import "math"

func closestKValues(root *TreeNode, target float64, k int) []int {
	result := make([]int, k)
	for i := 0; i < k; i++ {
		result[i] = int(target) + 1e10
	}
	var p int
	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Left)
		if math.Abs(target-float64(node.Val)) < math.Abs(target-float64(result[p%k])) {
			result[p%k] = node.Val
			p++
		}
		dfs(node.Right)
	}
	dfs(root)
	return result
}
