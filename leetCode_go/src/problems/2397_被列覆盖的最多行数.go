package problems

import "math/bits"

func maximumRows(matrix [][]int, numSelect int) int {
	m, n := len(matrix), len(matrix[0])
	lineMasks := make([]int, m)
	for i, line := range matrix {
		for j, value := range line {
			if value == 1 {
				lineMasks[i] |= 1 << j
			}
		}
	}
	count := func(num int) int {
		var rt int
		for _, lm := range lineMasks {
			if (num&lm)^lm == 0 {
				rt++
			}
		}
		return rt
	}
	var result int
	for i := 0; i < 1<<n; i++ {
		if bits.OnesCount32(uint32(i)) != numSelect {
			continue
		}
		if newCount := count(i); result < newCount {
			result = newCount
		}
	}
	return result
}
