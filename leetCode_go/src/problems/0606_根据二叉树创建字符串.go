package problems

import (
	"fmt"
)

func tree2str(root *TreeNode) string {
	if root == nil {
		return ""
	}
	left := tree2str(root.Left)
	right := tree2str(root.Right)
	result := fmt.Sprintf("%d", root.Val)
	if right != "" {
		result += fmt.Sprintf("(%s)(%s)", left, right)
	} else if left != "" {
		result += fmt.Sprintf("(%s)", left)
	}
	return result
}
