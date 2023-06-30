package problems

func ReconstructMatrix(upper int, lower int, colsum []int) [][]int {
	return reconstructMatrix(upper, lower, colsum)
}
func reconstructMatrix(upper int, lower int, colsum []int) [][]int {
	n, con2, con1 := len(colsum), 0, 0
	for _, num := range colsum {
		if num == 2 {
			con2++
		} else if num == 1 {
			con1++
		}
	}
	if upper-con2 < 0 || lower-con2 < 0 || upper+lower != 2*con2+con1 {
		return [][]int{}
	}
	result := make([][]int, 2)
	result[0], result[1] = make([]int, n), make([]int, n)
	uc, lc := 0, 0
	for i, num := range colsum {
		switch num {
		case 2:
			result[0][i] = 1
			result[1][i] = 1
		case 1:
			if uc+con2 < upper {
				result[0][i] = 1
				uc++
			} else {
				result[1][i] = 1
				lc++
			}

		}
	}
	return result
}
