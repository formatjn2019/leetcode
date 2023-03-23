package problems

import (
	"sort"
)

func AnswerQueries(nums []int, queries []int) []int {
	return answerQueries(nums, queries)
}
func answerQueries(nums []int, queries []int) []int {
	sort.Ints(nums)
	for i := 1; i < len(nums); i++ {
		nums[i] += nums[i-1]
	}
	result := make([]int, len(queries))
	for i, num := range queries {
		for j, sum := range nums {
			if sum > num {
				break
			}
			result[i] = j + 1
		}
	}
	return result
}
