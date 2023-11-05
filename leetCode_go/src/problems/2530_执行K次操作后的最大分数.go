package problems

import "container/heap"

type preQuery []int

func (q preQuery) Swap(i, j int) {
	q[i], q[j] = q[j], q[i]
}

func (q preQuery) Len() int {
	return len(q)
}
func (q preQuery) Less(i, j int) bool {
	return q[i] > q[j]
}

func (q *preQuery) Push(x any) {
	*q = append(*q, x.(int))
}

func (q *preQuery) Pop() any {
	x := (*q)[len(*q)-1]
	*q = (*q)[:len(*q)-1]
	return x
}

func maxKelements(nums []int, k int) int64 {
	q := (*preQuery)(&nums)
	heap.Init(q)
	var result int64
	for i := 0; i < k; i++ {
		x := heap.Pop(q).(int)
		result += int64(x)
		heap.Push(q, (x+2)/3)
	}
	return result
}
