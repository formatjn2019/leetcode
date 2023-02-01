package problems

func CheckXMatrix(grid [][]int) bool {
	return checkXMatrix(grid)
}

func checkXMatrix(grid [][]int) bool {
	result := true
	isOnDiagonal := func(x, y int) bool {
		return x == y || x == len(grid)-y-1
	}
	for i, arr := range grid {
		for j, num := range arr {
			if isOnDiagonal(i, j) {
				result = result && num != 0
			} else {
				result = result && num == 0
			}
		}
	}
	return result
}
