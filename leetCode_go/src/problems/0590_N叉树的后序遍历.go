package problems

func postorder(root *Node) []int {
	result := make([]int, 0)
	if root == nil {
		return result
	}
	var walk func(*Node)

	walk = func(tr *Node) {
		for _, v := range tr.Children {
			walk(v)
		}
		result = append(result, tr.Val)
	}
	walk(root)
	return result
}
