package problems

func MinPathCost(grid [][]int, moveCost [][]int) int {
	return minPathCost(grid, moveCost)
}

func minPathCost(grid [][]int, moveCost [][]int) int {
	min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	m, n := len(grid), len(grid[0])
	matrix := make([][]int, m)
	matrix[0] = make([]int, n)
	for i := 0; i < len(grid)-1; i++ {
		matrix[i+1] = make([]int, n)
		for j := 0; j < n; j++ {
			matrix[i+1][j] = 1 << 31
		}
		for j, num := range grid[i] {
			for k, cos := range moveCost[num] {
				matrix[i+1][k] = min(cos+num+matrix[i][j], matrix[i+1][k])
			}
		}
	}
	result := 1 << 31
	for i, num := range matrix[m-1] {
		result = min(result, num+grid[m-1][i])
	}
	return result
}
