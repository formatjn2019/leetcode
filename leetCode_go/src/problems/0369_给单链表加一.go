package problems

func PlusOne(head *ListNode) *ListNode {
	return plusOne(head)
}
func plusOne(head *ListNode) *ListNode {
	var rev func(node *ListNode) *ListNode
	rev = func(node *ListNode) *ListNode {
		hd := &ListNode{}
		hd.Next = node
		for tp := hd.Next; tp != nil; {
			tt := tp.Next
			tp.Next = hd.Next
			hd.Next = tp
			tp = tt
		}
		node.Next = nil
		return hd.Next
	}
	nHead := rev(head)
	carry := 1
	for tNode, pre := nHead, nHead; carry > 0; tNode = tNode.Next {
		if tNode == nil {
			tNode = &ListNode{Val: 0}
			pre.Next = tNode
		}
		carry = (tNode.Val + carry) / 10
		tNode.Val = (tNode.Val + 1) % 10
		pre = tNode
	}
	return rev(nHead)
}
