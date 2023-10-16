package problems

func VerticalOrder(root *TreeNode) [][]int {
	return verticalOrder(root)
}

func verticalOrder(root *TreeNode) [][]int {
	result := make([][]int, 0)
	centerIndex := 0
	var bfs func(nodes []*TreeNode, rows []int)
	bfs = func(nodes []*TreeNode, rows []int) {
		if len(nodes) == 0 {
			return
		}
		nextNodeList, nextRowList := make([]*TreeNode, 0), make([]int, 0)
		for i := 0; i < len(nodes); i++ {
			node, row := nodes[i], rows[i]
			//fmt.Println(node.Val, row)
			for centerIndex+row < 0 {
				centerIndex++
				result = append([][]int{make([]int, 0)}, result...)
			}
			for centerIndex+row >= len(result) {
				result = append(result, []int{})
			}
			result[centerIndex+row] = append(result[centerIndex+row], node.Val)
			if node.Left != nil {
				nextNodeList = append(nextNodeList, node.Left)
				nextRowList = append(nextRowList, row-1)
			}
			if node.Right != nil {
				nextNodeList = append(nextNodeList, node.Right)
				nextRowList = append(nextRowList, row+1)
			}
		}
		bfs(nextNodeList, nextRowList)
	}
	if root != nil {
		bfs([]*TreeNode{root}, []int{0})
	}
	return result
}
