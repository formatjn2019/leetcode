package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestMyLinkedList(t *testing.T) {
	ll := problems.MyLinkedListConstructor()
	ll.AddAtHead(1)
	ll.AddAtTail(2)
	ll.AddAtIndex(0, 0)
	// ll.DeleteAtIndex(5)
	// ll.DeleteAtIndex(2)
	// ll.DeleteAtIndex(2)
	for i := 0; i < 10; i++ {
		fmt.Printf("ll.Get(i): %v\n", ll.Get(i))
	}
}
