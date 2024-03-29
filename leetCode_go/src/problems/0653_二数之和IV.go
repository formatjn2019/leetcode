package problems

func findTarget(root *TreeNode, k int) bool {
	result := false
	hashTab := make([]bool, 20001)
	var walkTree func(root *TreeNode)
	walkTree = func(root *TreeNode) {
		if root == nil || result {
			return
		} else if targetIndex := k - root.Val + 10000; targetIndex >= 0 && targetIndex < 20001 && hashTab[targetIndex] {
			//有确定的值
			result = true
			return
		} else if currentIndex := root.Val + 10000; currentIndex >= 0 && currentIndex < 20001 {
			hashTab[currentIndex] = true
		}
		walkTree(root.Left)
		walkTree(root.Right)
	}
	walkTree(root)

	return result
}
