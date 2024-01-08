package problems

func removeNodes(head *ListNode) *ListNode {
	stack := make([]*ListNode, 0)
	for temp := head; temp != nil; temp = temp.Next {
		for len(stack) != 0 && stack[len(stack)-1].Val < temp.Val {
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, temp)
	}

	for i := 0; i < len(stack)-1; i++ {
		stack[i].Next = stack[i+1]
	}
	return stack[0]
}
