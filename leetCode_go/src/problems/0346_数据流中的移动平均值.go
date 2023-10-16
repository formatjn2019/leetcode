package problems

type MovingAverage struct {
	arr     []int
	sum     int
	len     int
	current int
}

func ConstructorMA(size int) MovingAverage {
	return MovingAverage{arr: make([]int, size), len: size}
}

func (this *MovingAverage) Next(val int) float64 {
	this.sum = this.sum + val - this.arr[this.current%this.len]
	this.arr[this.current%this.len] = val
	this.current++
	if this.current < this.len {
		return float64(this.sum) / float64(this.current)
	} else {
		return float64(this.sum) / float64(this.len)
	}
}
