package problems

import "sort"

func deleteGreatestValue(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	for _, line := range grid {
		sort.Ints(line)
	}
	result := 0
	for j := 0; j < n; j++ {
		LineMax := grid[0][j]
		for i := 0; i < m; i++ {
			if grid[i][j] > LineMax {
				LineMax = grid[i][j]
			}
		}
		result += LineMax
	}
	return result
}
