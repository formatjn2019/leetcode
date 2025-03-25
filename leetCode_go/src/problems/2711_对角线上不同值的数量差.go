package problems

func DifferenceOfDistinctValues(grid [][]int) [][]int {
	return differenceOfDistinctValues(grid)
}

func differenceOfDistinctValues(grid [][]int) [][]int {
	topLeftMatrix, bottomRightMatrix := make([][]int, len(grid)), make([][]int, len(grid))
	m, n := len(grid), len(grid[0])
	result := make([][]int, m)
	// 矩阵初始化
	for i := 0; i < m; i++ {
		topLeftMatrix[i], bottomRightMatrix[i], result[i] = make([]int, n), make([]int, n), make([]int, n)
	}

	// 右下移动
	for j := 0; j < n; j++ {
		numCount := make(map[int]int)
		for k := 0; j+k < n-1 && k < m-1; k++ {
			numCount[grid[k][j+k]]++
			topLeftMatrix[k+1][j+k+1] = len(numCount)
		}
	}
	for i := 1; i < m; i++ {
		numCount := make(map[int]int)
		for k := 0; i+k < m-1 && k < n-1; k++ {
			numCount[grid[i+k][k]]++
			topLeftMatrix[i+k+1][k+1] = len(numCount)
		}
	}

	// 左上移动
	for i := m - 1; i >= 0; i-- {
		numCount := make(map[int]int)
		for k := 0; i-k > 0 && n-1-k > 0; k++ {
			numCount[grid[i-k][n-1-k]]++
			bottomRightMatrix[i-k-1][n-1-k-1] = len(numCount)
		}
	}

	for j := n - 1; j >= 0; j-- {
		numCount := make(map[int]int)
		for k := 0; j-k > 0 && m-1-k > 0; k++ {
			numCount[grid[m-1-k][j-k]]++
			bottomRightMatrix[m-1-k-1][j-k-1] = len(numCount)
		}
	}

	abs := func(x int) int {
		if x < 0 {
			return -x
		}
		return x
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			result[i][j] = abs(topLeftMatrix[i][j] - bottomRightMatrix[i][j])
		}
	}

	return result
}
