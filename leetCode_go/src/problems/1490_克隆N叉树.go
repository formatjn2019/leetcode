package problems

func cloneTree(root *Node) *Node {
	if root == nil {
		return nil
	}
	var children []*Node
	for _, child := range root.Children {
		children = append(children, cloneTree(child))
	}
	return &Node{Val: root.Val, Children: children}
}
