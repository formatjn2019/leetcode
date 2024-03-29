package problems

type MyLinkedList struct {
	head *MyLinkedListNode
}
type MyLinkedListNode struct {
	val  int
	next *MyLinkedListNode
}

func MyLinkedListConstructor() MyLinkedList {
	return MyLinkedList{head: &MyLinkedListNode{val: -1}}
}

func (this *MyLinkedList) Get(index int) int {
	node := this.head
	for i := 0; i <= index && node != nil; i++ {
		node = node.next
	}
	if node == nil {
		return this.head.val
	} else {
		return node.val
	}
}

func (this *MyLinkedList) AddAtHead(val int) {
	nNode := MyLinkedListNode{val: val, next: this.head.next}
	this.head.next = &nNode
}

func (this *MyLinkedList) AddAtTail(val int) {
	node := this.head
	for node.next != nil {
		node = node.next
	}
	node.next = &MyLinkedListNode{val: val}
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index < 0 {
		this.AddAtHead(val)
	} else {
		node := this.head
		for i := 0; i < index && node != nil; i++ {
			node = node.next
		}
		if node != nil {
			node.next = &MyLinkedListNode{val: val, next: node.next}
		}
	}
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	node := this.head
	for i := 0; i < index && node != nil; i++ {
		node = node.next
	}
	if node != nil && node.next != nil {
		node.next = node.next.next
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * obj := AuthenticationConstructor();
 * param_1 := obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */
