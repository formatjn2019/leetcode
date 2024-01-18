package problems

func deleteDuplicates(head *ListNode) *ListNode {
	for tp := head; tp != nil; tp = tp.Next {
		for tp.Next != nil && tp.Val == tp.Next.Val {
			tp.Next = tp.Next.Next
		}
	}
	return head
}
