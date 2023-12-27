package problems

import "container/heap"

func MinStoneSum(piles []int, k int) int {
	return minStoneSum(piles, k)
}

type hp2 []int

func (h hp2) Len() int {
	return len(h)
}
func (h hp2) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}
func (h hp2) Less(i, j int) bool {
	return h[i] > h[j]
}

func (h *hp2) Push(x interface{}) {
	*h = append(*h, x.(int))
}
func (h *hp2) Pop() interface{} {
	items := *h
	result := items[len(items)-1]
	*h = items[:len(items)-1]
	return result
}

func minStoneSum(piles []int, k int) int {
	myheap := make(hp2, 0)
	heap.Init(&myheap)
	var result int
	for _, pile := range piles {
		heap.Push(&myheap, pile)
		result += pile
	}
	for t := k; t > 0; t-- {
		pop := heap.Pop(&myheap).(int)
		result -= pop / 2
		pop = pop - pop/2
		heap.Push(&myheap, pop)
	}
	return result
}
