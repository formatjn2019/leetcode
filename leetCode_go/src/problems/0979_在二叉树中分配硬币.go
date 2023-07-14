package problems

import "math"

func DistributeCoins(root *TreeNode) int {
	return distributeCoins(root)
}
func distributeCoins(root *TreeNode) int {
	result := 0
	var distribute func(node *TreeNode) int
	distribute = func(node *TreeNode) int {
		if node == nil {
			return 0
		}
		diff := distribute(node.Left) + distribute(node.Right) + node.Val - 1
		result += int(math.Abs(float64(diff)))
		return diff
	}
	distribute(root)
	return result
}
