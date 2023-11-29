package problems

type FrontMiddleBackQueue struct {
	head      *LinkedNode
	medium    *LinkedNode
	tail      *LinkedNode
	mediumIdx int
	lenth     int
}

type LinkedNode struct {
	val  int
	pre  *LinkedNode
	next *LinkedNode
}

func FrontMiddleBackQueueConstructor() FrontMiddleBackQueue {
	//哨兵节点
	node := &LinkedNode{}
	return FrontMiddleBackQueue{
		head:      node,
		tail:      node,
		medium:    node,
		lenth:     0,
		mediumIdx: -1,
	}
}

func (this *FrontMiddleBackQueue) insertNode(pre *LinkedNode, val int) {
	newNode := &LinkedNode{
		val:  val,
		pre:  pre,
		next: pre.next,
	}
	pre.next = newNode
	if newNode.next != nil {
		newNode.next.pre = newNode
	}
}

func (this *FrontMiddleBackQueue) deleteNode(pre *LinkedNode) int {
	result := pre.next.val
	if pre.next == this.medium {
		this.medium = this.medium.pre
	}
	if pre.next == this.tail {
		this.tail = this.tail.pre
	}
	pre.next = pre.next.next
	if pre.next != nil {
		pre.next.pre = pre
	}
	return result
}

func (this *FrontMiddleBackQueue) movePoint() {
	// 中指针定位
	if this.mediumIdx < (this.lenth-1)/2-1 {
		this.mediumIdx++
		this.medium = this.medium.next
	} else if this.mediumIdx > (this.lenth-1)/2-1 {
		this.mediumIdx--
		this.medium = this.medium.pre
	}
	if this.tail != this.head {
		this.tail = this.tail.pre
	}
	// 尾指针后移
	if this.tail.next != nil {
		for this.tail.next.next != nil {
			this.tail = this.tail.next
		}
	}
}
func (this *FrontMiddleBackQueue) PushFront(val int) {
	this.lenth++
	if this.mediumIdx >= 0 {
		this.mediumIdx++
	}
	this.insertNode(this.head, val)
	this.movePoint()
}

func (this *FrontMiddleBackQueue) moveMedium() {
	if this.mediumIdx < (this.lenth-1)/2-1 {
		this.mediumIdx++
		this.medium = this.medium.next
	} else if this.mediumIdx > (this.lenth-1)/2-1 {
		this.mediumIdx--
		this.medium = this.medium.pre
	}

	// 尾指针移动
	if this.tail != this.head {
		this.tail = this.tail.pre
		for this.tail.next != nil && this.tail.next.next != nil {
			this.tail = this.tail.next
		}
	}
}

func (this *FrontMiddleBackQueue) PushMiddle(val int) {
	this.lenth++
	this.movePoint()
	this.insertNode(this.medium, val)
	this.movePoint()
}

func (this *FrontMiddleBackQueue) PushBack(val int) {
	this.lenth++
	if this.lenth == 1 {
		this.insertNode(this.head, val)
	} else {
		this.insertNode(this.tail.next, val)
	}
	this.movePoint()
}

func (this *FrontMiddleBackQueue) PopFront() int {
	if this.lenth == 0 {
		return -1
	}
	this.lenth--
	if this.mediumIdx >= 0 {
		this.mediumIdx--
	}
	result := this.deleteNode(this.head)
	this.movePoint()
	return result
}

func (this *FrontMiddleBackQueue) PopMiddle() int {
	if this.lenth == 0 {
		return -1
	}
	this.lenth--
	result := this.deleteNode(this.medium)
	this.movePoint()
	return result
}

func (this *FrontMiddleBackQueue) PopBack() int {
	if this.lenth == 0 {
		return -1
	}
	this.lenth--
	result := this.deleteNode(this.tail)
	this.movePoint()
	return result
}
