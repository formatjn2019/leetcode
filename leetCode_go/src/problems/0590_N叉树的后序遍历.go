package problems

func postorder(root *TreeNodes) []int {
	result := make([]int, 0)
	if root == nil {
		return result
	}
	var walk func(*TreeNodes)

	walk = func(tr *TreeNodes) {
		for _, v := range tr.Children {
			walk(v)
		}
		result = append(result, tr.Val)
	}
	walk(root)
	return result
}
