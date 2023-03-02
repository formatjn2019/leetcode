package problems

import (
	"fmt"
	"strings"
)

func LargestLocal(grid [][]int) [][]int {
	fmt.Println(strings.Repeat("*", 100))
	result := largestLocal(grid)
	for _, arr := range grid {
		fmt.Println(arr)
	}
	fmt.Println(strings.Repeat("-", 100))
	for _, arr := range result {
		fmt.Println(arr)
	}
	return result
}
func largestLocal(grid [][]int) [][]int {
	m, n := len(grid), len(grid[0])
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	tpMatix := make([][]int, m)
	//横向缩紧
	for i := 0; i < m; i++ {
		tpMatix[i] = make([]int, len(grid[i]))
		for j := 1; j < len(grid[i])-1; j++ {
			tpMatix[i][j] = max(grid[i][j], max(grid[i][j-1], grid[i][j+1]))
		}
	}
	result := make([][]int, m-2)
	//纵向缩紧
	for i := 1; i < m-1; i++ {
		result[i-1] = make([]int, n-2)
		for j := 1; j < n-1; j++ {
			result[i-1][j-1] = max(tpMatix[i][j], max(tpMatix[i-1][j], tpMatix[i+1][j]))
		}
	}

	return result
}
