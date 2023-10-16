package problems

import "math"

func closestValue(root *TreeNode, target float64) int {
	if root == nil {
		return 1 << 30
	}
	result := root.Val
	if lv := closestValue(root.Left, target); math.Abs(target-float64(lv))-math.Abs(target-float64(result)) < 0 || (math.Abs(target-float64(lv))-math.Abs(target-float64(result)) == 0 && lv < result) {
		result = lv
	}
	if rv := closestValue(root.Right, target); math.Abs(target-float64(rv))-math.Abs(target-float64(result)) < 0 || (math.Abs(target-float64(rv))-math.Abs(target-float64(result)) == 0 && rv < result) {
		result = rv
	}
	return result
}
