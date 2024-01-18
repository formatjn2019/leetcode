package problems

func deleteDuplicatesII(head *ListNode) *ListNode {
	// 哨兵节点
	result := &ListNode{Val: -1000, Next: head}
	pre := result
	for tp := result; tp != nil; tp = tp.Next {
		if tp.Next != nil && tp.Val == tp.Next.Val {
			for tp.Next != nil && tp.Next.Val == tp.Val {
				tp = tp.Next
			}
			pre.Next = tp.Next
		} else {
			pre = tp
		}
	}
	return result.Next
}
