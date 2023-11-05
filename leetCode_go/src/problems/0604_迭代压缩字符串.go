package problems

type StringIterator struct {
	p   int
	arr []byte
	con []int
}

func ConstructorStringIterator(compressedString string) StringIterator {
	cArr, ncArr := make([]byte, 0), make([]int, 0)
	for _, c := range []byte(compressedString) {
		if c >= '0' && c <= '9' {
			ncArr[len(ncArr)-1] = ncArr[len(ncArr)-1]*10 + int(c-'0')
		} else {
			cArr = append(cArr, c)
			ncArr = append(ncArr, 0)
		}
	}
	return StringIterator{p: 0, arr: cArr, con: ncArr}
}

func (this *StringIterator) Next() byte {
	if this.p >= len(this.arr) {
		return ' '
	}
	result := this.arr[this.p]
	this.con[this.p]--
	if this.con[this.p] == 0 {
		this.p++
	}
	return result
}

func (this *StringIterator) HasNext() bool {
	return this.p < len(this.arr)
}
