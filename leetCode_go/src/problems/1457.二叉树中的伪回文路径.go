package problems

func pseudoPalindromicPaths(root *TreeNode) int {
	var dfs func(node *TreeNode, numCount []int) int
	dfs = func(node *TreeNode, numCount []int) int {
		if node == nil {
			return 0
		}
		numCount[node.Val]++
		var rt int
		if node.Left == node.Right {
			count := 0
			for _, t := range numCount {
				if t%2 == 1 {
					count++
				}
			}
			if count < 2 {
				rt = 1
			}
		} else {
			l := dfs(node.Left, numCount)
			r := dfs(node.Right, numCount)
			rt = l + r
		}
		numCount[node.Val]--
		return rt
	}
	return dfs(root, make([]int, 10))
}
