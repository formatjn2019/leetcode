package problems

func ShortestPathBinaryMatrix(grid [][]int) int {
	return shortestPathBinaryMatrix(grid)
}
func shortestPathBinaryMatrix(grid [][]int) int {
	n := len(grid)
	matrix := make([][]int, n+2)
	minNum := func(arr ...int) int {
		m := 1 << 20
		for _, num := range arr {
			if num < m {
				m = num
			}
		}
		return m
	}
	for i, _ := range matrix {
		matrix[i] = make([]int, n+2)
		for j := 0; j < n+2; j++ {
			matrix[i][j] = 1000
		}
	}
	if grid[0][0] == 0 {
		matrix[1][1] = 1
	}
	changedFlag := true
	for changedFlag {
		changedFlag = false
		for i, line := range grid {
			for j, num := range line {
				if num == 0 {
					if minRange := minNum(matrix[i][j], matrix[i][j+1], matrix[i][j+2], matrix[i+1][j], matrix[i+1][j+2],
						matrix[i+2][j], matrix[i+2][j+1], matrix[i+2][j+2]); matrix[i+1][j+1] > minRange+1 {
						changedFlag = true
						matrix[i+1][j+1] = minRange + 1
					}
				}
			}
		}
	}
	if matrix[n][n] >= 1000 {
		return -1
	}
	return matrix[n][n]
}
