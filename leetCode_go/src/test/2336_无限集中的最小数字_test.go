package test

import (
	"src/problems"
	"testing"
)

func TestSmallestInfiniteSet(t *testing.T) {
	sifs := problems.Constructor()
	sifs.AddBack(2)
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	sifs.AddBack(1)
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
}

func TestSmallestInfiniteSet2(t *testing.T) {
	sifs := problems.Constructor()
	//println(sifs.PopSmallest())
	//sifs.AddBack(1)
	//println(sifs.PopSmallest())
	//println(sifs.PopSmallest())
	//println(sifs.PopSmallest())
	//sifs.AddBack(2)
	//sifs.AddBack(3)
	//println(sifs.PopSmallest())
	//println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	sifs.AddBack(5)
	sifs.AddBack(1)
	sifs.AddBack(3)
	sifs.AddBack(2)
	sifs.AddBack(4)
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
	println(sifs.PopSmallest())
}

//// Item 结构体表示堆中的元素
//type Item struct {
//	value    string // 值
//	priority int    // 优先级
//	index    int    // 元素在堆中的索引
//}

// PriorityQueue 实现了堆接口
type PriorityQueue []int

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i] < pq[j]
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
	//item := x.(*Item)
	//item.index = len(*pq)
	*pq = append(*pq, x.(int))
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	//item.index = -1 // 标记为删除
	*pq = old[0 : n-1]
	return item
}

//// 更新指定元素的值和优先级
//func (pq *PriorityQueue) update(item *Item, value string, priority int) {
//	item.value = value
//	item.priority = priority
//	heap.Fix(pq, item.index)
//}

func TestSmallestInfiniteSet3(t *testing.T) {
	problems.TFG()
	// 创建一个空的优先队列
	//pq := make(PriorityQueue, 0)
	//
	//// 向优先队列中添加元素
	//heap.Push(&pq, 3)
	//heap.Push(&pq, 5)
	//heap.Push(&pq, 1)
	//
	//// 更新元素的优先级
	////item := pq[1] // 假设需要更新索引为1的元素
	////pq.update(item, item.value, 4)
	//
	//// 从优先队列中取出元素并打印
	//for pq.Len() > 0 {
	//	item := heap.Pop(&pq)
	//	fmt.Println(item)
	//}
}
