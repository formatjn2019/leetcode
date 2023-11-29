package problems

import (
	"container/heap"
)

type SmallestInfiniteSet struct {
	maxNum int
	st     map[int]bool
	q      query
}

type query []int

func (q query) Len() int {
	return len(q)
}
func (q query) Less(i, j int) bool {
	return q[i] < q[j]
}

func (q query) Swap(i, j int) {
	q[i], q[j] = q[j], q[i]
}

func (q *query) Push(x any) {
	*q = append(*q, x.(int))
}

func (q *query) Pop() any {
	x := (*q)[len(*q)-1]
	*q = (*q)[:len(*q)-1]
	return x
}

func Constructor() SmallestInfiniteSet {
	q := make(query, 0)
	heap.Init(&q)
	//return SmallestInfiniteSet{q: q, maxNum: 1}
	return SmallestInfiniteSet{q: q, st: map[int]bool{}, maxNum: 1}
}

func (this *SmallestInfiniteSet) PopSmallest() int {
	if this.q.Len() > 0 {
		if t := heap.Pop(&this.q).(int); t < this.maxNum {
			delete(this.st, t)
			return t
		} else {
			heap.Push(&this.q, t)
		}
	}

	this.maxNum++
	return this.maxNum - 1
}

func (this *SmallestInfiniteSet) AddBack(num int) {
	if num < this.maxNum && !this.st[num] {
		this.st[num] = true
		heap.Push(&this.q, num)
	}
}
