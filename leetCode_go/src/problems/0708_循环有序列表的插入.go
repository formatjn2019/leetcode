package problems

func InsertNode(aNode *Node, x int) *Node {
	return insertNode(aNode, x)
}

func insertNode(aNode *Node, x int) *Node {
	if aNode == nil {
		node := &Node{Val: x}
		node.Next = node
		return node
	}
	tNode := aNode.Next
	for tNode.Val <= tNode.Next.Val && tNode != aNode {
		tNode = tNode.Next
	}
	// 插入开头
	if tNode.Val < x || tNode.Next.Val > x {
		tNode.Next = &Node{Val: x, Next: tNode.Next}
	} else {
		for tNode.Next.Val < x {
			tNode = tNode.Next
		}
		tNode.Next = &Node{Val: x, Next: tNode.Next}
	}
	return aNode
}
