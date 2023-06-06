package problems

import "bytes"

func equalPairs(grid [][]int) int {
	result, n := 0, len(grid)
	lineCount := map[string]int{}
	for _, lineArr := range grid {
		var bf bytes.Buffer
		for _, num := range lineArr {
			bf.WriteRune(rune(num))
		}
		lineCount[bf.String()]++
	}
	for j := 0; j < n; j++ {
		var bf bytes.Buffer
		for i := 0; i < n; i++ {
			bf.WriteRune(rune(grid[i][j]))
		}
		result += lineCount[bf.String()]
	}
	return result
}
