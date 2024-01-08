package problems

func insertGreatestCommonDivisors(head *ListNode) *ListNode {
	//碾转相除法
	nzxc := func(x, y int) int {
		if x < y {
			x, y = y, x
		}
		for x%y != 0 {
			x, y = y, x%y
		}
		return y
	}

	var insertNewNode func(node *ListNode) int

	insertNewNode = func(node *ListNode) int {
		if node.Next != nil {
			node.Next = &ListNode{Val: nzxc(node.Val, insertNewNode(node.Next)), Next: node.Next}
		}
		return node.Val
	}
	insertNewNode(head)
	return head
}
