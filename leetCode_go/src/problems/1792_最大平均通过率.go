package problems

import (
	"container/heap"
)

func MaxAverageRatio(classes [][]int, extraStudents int) float64 {
	return maxAverageRatio(classes, extraStudents)
}

// leetcode官解
// https://leetcode.cn/problems/maximum-average-pass-ratio/solution/zui-da-ping-jun-tong-guo-lu-by-leetcode-dm7y3/
func maxAverageRatio(classes [][]int, extraStudents int) (ans float64) {
	h := hp(classes)
	heap.Init(&h)
	for ; extraStudents > 0; extraStudents-- {
		h[0][0]++
		h[0][1]++
		heap.Fix(&h, 0)
	}
	for _, c := range h {
		ans += float64(c[0]) / float64(c[1])
	}
	return ans / float64(len(classes))
}

type hp [][]int

func (h hp) Len() int { return len(h) }
func (h hp) Less(i, j int) bool {
	a, b := h[i], h[j]
	return (a[1]-a[0])*b[1]*(b[1]+1) > (b[1]-b[0])*a[1]*(a[1]+1)
}
func (h hp) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (hp) Push(interface{})     {}
func (hp) Pop() (_ interface{}) { return }
