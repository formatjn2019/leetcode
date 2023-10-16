package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestPlusOne(t *testing.T) {
	node1 := &problems.ListNode{Val: 1}
	node2 := &problems.ListNode{Val: 2}
	node3 := &problems.ListNode{Val: 3}
	node1.Next, node2.Next = node2, node3
	one := problems.PlusOne(node1)
	fmt.Println(one)
	node9 := &problems.ListNode{Val: 9}
	po := problems.PlusOne(node9)
	fmt.Println(po)
}
