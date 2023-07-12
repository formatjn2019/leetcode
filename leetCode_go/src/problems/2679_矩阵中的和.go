package problems

import "sort"

func matrixSum(nums [][]int) int {
	m, n := len(nums), len(nums[0])
	for _, arr := range nums {
		sort.Ints(arr)
	}
	result := 0
	for j := n - 1; j >= 0; j-- {
		max := nums[0][j]
		for i := 1; i < m; i++ {
			if max < nums[i][j] {
				max = nums[i][j]
			}
		}
		result += max
	}
	return result
}
