package problems

import (
	"fmt"
)

func CheckValidGrid(grid [][]int) bool {
	for _, arr := range grid {
		fmt.Println(arr)
	}
	return checkValidGrid(grid)
}

func checkValidGrid(grid [][]int) bool {
	if grid[0][0] != 0 {
		return false
	}
	n := len(grid)
	idxMap := map[int]int{}
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			idxMap[grid[i][j]] = i<<4 + j
		}
	}

	for i := 1; i < n*n; i++ {
		n1, n2 := idxMap[i-1], idxMap[i]
		if dis := (n1%16-n2%16)*(n1%16-n2%16) + (n1/16-n2/16)*(n1/16-n2/16); dis != 5 || n1/16 == n2/16 || n1%16 == n2%16 {
			return false
		}
	}
	return true
}
