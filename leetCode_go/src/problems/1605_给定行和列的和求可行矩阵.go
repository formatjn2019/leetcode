package problems

import "fmt"

func RestoreMatrix(rowSum []int, colSum []int) [][]int {
	fmt.Println(rowSum, colSum)
	result := restoreMatrix(rowSum, colSum)
	for _, arr := range result {
		fmt.Println(arr)
	}
	return result
}
func restoreMatrix(rowSum []int, colSum []int) [][]int {
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	m, n := len(rowSum), len(colSum)
	result := make([][]int, m)
	for i, _ := range result {
		result[i] = make([]int, n)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			result[i][j] = min(rowSum[i], colSum[j])
			rowSum[i] -= result[i][j]
			colSum[j] -= result[i][j]
		}
	}
	return result
}
