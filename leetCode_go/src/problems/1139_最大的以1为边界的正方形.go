package problems

import "fmt"

func Largest1BorderedSquare(grid [][]int) int {
	result := largest1BorderedSquare(grid)
	fmt.Printf("result: %v\n", result)
	return result
}

func largest1BorderedSquare(grid [][]int) int {
	if len(grid) == 0 {
		return 0
	}
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	m, n := len(grid), len(grid[0])
	lineArr, rowArr := make([][]int, m), make([][]int, m)
	for i, arr := range grid {
		lineArr[i] = make([]int, n)
		rowArr[i] = make([]int, n)
		for j, n := range arr {
			if n == 1 {
				if j > 0 {
					lineArr[i][j] = lineArr[i][j-1] + 1
				} else {
					lineArr[i][j] = 1
				}
				if i > 0 {
					rowArr[i][j] = rowArr[i-1][j] + 1
				} else {
					rowArr[i][j] = 1
				}
			}
		}
	}
	result := 0
	//倒序遍历，贪心
	for i := m - 1; i >= result; i-- {
		for j := n - 1; j >= result; j-- {
			for k := min(i, j); k >= result; k-- {
				if grid[i][j] > 0 && lineArr[i-k][j] > k && lineArr[i][j] > k && rowArr[i][j-k] > k && rowArr[i][j] > k {
					result = max(k+1, result)
				}
			}
		}
	}
	return result * result
}
