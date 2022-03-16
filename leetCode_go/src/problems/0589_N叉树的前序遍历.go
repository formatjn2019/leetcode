package problems

func Preorder(root *Node) []int {
	return preorder(root)
}

func preorder_stack(root *Node) []int {
	result := make([]int, 0)

	return result
}

func preorder(root *Node) []int {
	return preorder_recursion(root, make([]int, 0))
}

func preorder_recursion(root *Node, result []int) []int {
	if root == nil {
		return result
	}
	result = append(result, root.Val)
	for _, v := range root.Children {
		result = preorder_recursion(v, result)
	}
	return result
}
