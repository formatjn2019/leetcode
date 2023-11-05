package problems

func InsertNode(aNode *LinkNode, x int) *LinkNode {
	return insertNode(aNode, x)
}

func insertNode(aNode *LinkNode, x int) *LinkNode {
	if aNode == nil {
		node := &LinkNode{Val: x}
		node.Next = node
		return node
	}
	tNode := aNode.Next
	for tNode.Val <= tNode.Next.Val && tNode != aNode {
		tNode = tNode.Next
	}
	// 插入开头
	if tNode.Val < x || tNode.Next.Val > x {
		tNode.Next = &LinkNode{Val: x, Next: tNode.Next}
	} else {
		for tNode.Next.Val < x {
			tNode = tNode.Next
		}
		tNode.Next = &LinkNode{Val: x, Next: tNode.Next}
	}
	return aNode
}
