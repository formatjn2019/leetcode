package problems

type MyStack struct {
	lenth int
	list  []int
}

func MyStackConstructor() MyStack {
	return MyStack{}
}

func (this *MyStack) Push(x int) {
	this.lenth++
	this.list = append(this.list, x)
	for i := 0; i < this.lenth-1; i++ {
		this.list = append(this.list[1:], this.list[0])
	}
}

func (this *MyStack) Pop() int {
	var x int
	if !this.Empty() {
		x = this.list[0]
		this.list = this.list[1:]
		this.lenth--
	}
	return x
}

func (this *MyStack) Top() int {
	if !this.Empty() {
		return this.list[0]
	}
	return 0
}

func (this *MyStack) Empty() bool {
	return this.lenth == 0
}
