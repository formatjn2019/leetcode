package problems

type Node struct {
	Val  int
	Next *Node
}

type TreeNodes struct {
	Val      int
	Children []*TreeNodes
}

type ListNode struct {
	Val  int
	Next *ListNode
}
