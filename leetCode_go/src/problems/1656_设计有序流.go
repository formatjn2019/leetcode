package problems

type OrderedStream struct {
	point int
	data  []string
}

func OrderedStreamConstructor(n int) OrderedStream {
	return OrderedStream{data: make([]string, n)}
}

func (this *OrderedStream) Insert(idKey int, value string) []string {
	p := idKey - 1
	this.data[p] = value
	st := this.point
	for ; this.point < len(this.data); this.point++ {
		if this.data[this.point] == "" {
			break
		}
	}
	return this.data[st:this.point]
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * obj := AllocateConstructor(n);
 * param_1 := obj.Insert(idKey,value);
 */
