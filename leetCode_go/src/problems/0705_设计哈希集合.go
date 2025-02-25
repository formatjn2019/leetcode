package problems

var MyHashNum = 10001

type MyHashSet struct {
	MyHashArr []*ListNode
}

func MyHashSetConstructor() MyHashSet {
	nodes := make([]*ListNode, MyHashNum)
	for i, _ := range nodes {
		nodes[i] = &ListNode{}
	}
	return MyHashSet{MyHashArr: nodes}
}

func (this *MyHashSet) Add(key int) {
	idx := key % MyHashNum

	for start := this.MyHashArr[idx].Next; start != nil; start = start.Next {
		if start.Val == key {
			return
		}
	}
	this.MyHashArr[idx].Next = &ListNode{Val: key, Next: this.MyHashArr[idx].Next}
}

func (this *MyHashSet) Remove(key int) {
	idx := key % MyHashNum
	for pre := this.MyHashArr[idx]; pre.Next != nil; pre = pre.Next {
		if pre.Next.Val == key {
			pre.Next = pre.Next.Next
		}
	}
}

func (this *MyHashSet) Contains(key int) bool {
	idx := key % MyHashNum
	for start := this.MyHashArr[idx].Next; start != nil; start = start.Next {
		if start.Val == key {
			return true
		}
	}
	return false
}
