package problems

type MyStack struct {
	lenth int
	list  []int
}

func Constructor() MyStack {
	return MyStack{}
}

func (this *MyStack) Push(x int) {
	this.lenth++
	this.list = append(this.list, x)
}

func (this *MyStack) Pop() int {
	var x int
	if !this.Empty() {
		x = this.list[this.lenth-1]
		this.list = this.list[:this.lenth-1]
		this.lenth--
	}
	return x
}

func (this *MyStack) Top() int {
	if !this.Empty() {
		return this.list[this.lenth-1]
	}
	return 0
}

func (this *MyStack) Empty() bool {
	return this.lenth == 0
}
