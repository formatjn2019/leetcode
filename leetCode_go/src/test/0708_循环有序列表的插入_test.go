package test

import (
	"src/problems"
	"testing"
)

func TestInsertNode(t *testing.T) {
	node1 := &problems.Node{Val: 3}
	node2 := &problems.Node{Val: 3}
	node3 := &problems.Node{Val: 5}
	node1.Next, node2.Next, node3.Next = node2, node3, node1
	problems.InsertNode(node1, 0)
}
