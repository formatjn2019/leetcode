package problems

func deleteNodes(head *ListNode, m int, n int) *ListNode {
	var pre *ListNode
	for tNode, tm, tn := head, m, n; tNode != nil; tNode = tNode.Next {
		if tm > 0 {
			pre = tNode
			tm--
		} else if tn == 0 {
			pre.Next = tNode
			pre = tNode
			tm, tn = m-1, n
		} else {
			pre.Next = nil
			tn--
		}
	}
	return head
}
