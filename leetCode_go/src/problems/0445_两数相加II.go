package problems

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	st1, st2 := make([]int, 0), make([]int, 0)
	for ; l1 != nil; l1 = l1.Next {
		st1 = append(st1, l1.Val)
	}
	for ; l2 != nil; l2 = l2.Next {
		st2 = append(st2, l2.Val)
	}
	var result *ListNode
	var carry int
	for carry > 0 || len(st1) > 0 || len(st2) > 0 {
		val := carry
		if len(st1) > 0 {
			val += st1[len(st1)-1]
			st1 = st1[:len(st1)-1]
		}
		if len(st2) > 0 {
			val += st2[len(st2)-1]
			st2 = st2[:len(st2)-1]
		}
		result = &ListNode{Val: val % 10, Next: result}
		carry = val / 10
	}
	return result
}
