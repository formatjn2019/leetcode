package problems

import "sort"

var SubsetsWithDup = subsetsWithDup

func subsetsWithDup(nums []int) [][]int {
	sort.Ints(nums)
	result := [][]int{{}}
	numSet := make(map[int64]struct{})
	for i := 0; i < len(nums); i++ {
		nr := make([][]int, 0)
		for _, o := range result {
			nr = append(nr, append([]int{nums[i]}, o...))
		}
		for _, n := range nr {
			hash := subsetsWithDupHash(n)
			if _, ok := numSet[hash]; !ok {
				result = append(result, n)
				numSet[hash] = struct{}{}
			}
		}
	}
	return result
}

func subsetsWithDupHash(nums []int) int64 {
	var result int64
	for _, n := range nums {
		result = (result << 5) | int64(n+10)
	}
	return result
}
