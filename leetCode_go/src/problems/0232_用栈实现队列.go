package problems

type MyQueue struct {
	sti []int
	sto []int
	l   int
	// 翻转状态 输入/输出状态
	flag bool
}

func MyQueueConstructor() MyQueue {
	return MyQueue{}
}

func (this *MyQueue) rev() {
	// 输入切换输出
	if this.flag {
		for len(this.sti) > 0 {
			this.sto = append(this.sto, this.sti[len(this.sti)-1])
			this.sti = this.sti[:len(this.sti)-1]
		}
	} else {
		for len(this.sto) > 0 {
			this.sti = append(this.sti, this.sto[len(this.sto)-1])
			this.sto = this.sto[:len(this.sto)-1]
		}
	}
	this.flag = !this.flag
}

func (this *MyQueue) Push(x int) {
	// 输入状态切换为输入
	if !this.flag {
		this.rev()
	}
	// 入栈
	this.sti = append(this.sti, x)
	this.l++
}

func (this *MyQueue) Pop() int {
	var x int
	if !this.Empty() {
		//输入状态切换为输出
		if this.flag {
			this.rev()
		}
		x = this.sto[this.l-1]
		this.l--
		this.sto = this.sto[:this.l]
	}
	return x
}

func (this *MyQueue) Peek() int {
	var x int
	if !this.Empty() {
		//输入状态切换为输出
		if this.flag {
			this.rev()
		}
		x = this.sto[this.l-1]
	}
	return x
}

func (this *MyQueue) Empty() bool {
	return this.l == 0
}
