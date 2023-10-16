package problems

type FirstUnique struct {
	p      int
	arr    []int
	idxMap map[int]int
}

func Constructor(nums []int) FirstUnique {
	fu := FirstUnique{arr: make([]int, 0, len(nums)), idxMap: map[int]int{}}
	for _, num := range nums {
		fu.Add(num)
	}
	return fu
}

func (this *FirstUnique) ShowFirstUnique() int {
	if this.p == len(this.arr) {
		return -1
	}
	return this.arr[this.p]
}

func (this *FirstUnique) Add(value int) {
	if _, ok := this.idxMap[value]; !ok {
		this.idxMap[value] = len(this.arr)
	} else {
		this.idxMap[value] = -1
	}
	this.arr = append(this.arr, value)
	for this.p < len(this.arr) && this.idxMap[this.arr[this.p]] != this.p {
		this.p++
	}
}
