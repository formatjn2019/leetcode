package problems

import "fmt"

func MaxValue(grid [][]int) int {
	return maxValue(grid)
}
func maxValue(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	matrix := make([][]int, m+1)
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	for i := 0; i < m+1; i++ {
		matrix[i] = make([]int, n+1)
	}
	fmt.Println(matrix)
	for i, arr := range grid {
		for j, num := range arr {
			matrix[i+1][j+1] = max(matrix[i+1][j], matrix[i][j+1]) + num
		}
	}
	return matrix[m][n]
}
