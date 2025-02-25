package problems

import "fmt"

type Allocator struct {
	data     []int
	pointMap map[int][]int
}

func AllocateConstructor(n int) Allocator {
	return Allocator{data: make([]int, n), pointMap: make(map[int][]int)}
}

func (this *Allocator) Allocate(size int, mID int) int {
	lp, rp := 0, 0
	for lp <= len(this.data)-size {
		for ; lp <= len(this.data)-size; lp++ {
			if this.data[lp] == 0 {
				break
			}
		}

		for rp = lp; rp <= len(this.data) && rp-lp < size; rp++ {
			if rp >= len(this.data) || this.data[rp] != 0 {
				break
			}
		}

		if rp-lp == size {
			break
		}
		lp = rp
	}

	if rp-lp == size {
		for i := lp; i < rp; i++ {
			this.data[i] = mID
		}
		this.pointMap[mID] = append(this.pointMap[mID], lp)
		fmt.Println(this.data)
		return lp
	}
	fmt.Println(this.data)
	return -1
}

func (this *Allocator) FreeMemory(mID int) int {
	var result int
	for _, p := range this.pointMap[mID] {
		for i := p; i < len(this.data) && this.data[i] == mID; i++ {
			this.data[i] = 0
			result++
		}
	}
	delete(this.pointMap, mID)
	return result
}
