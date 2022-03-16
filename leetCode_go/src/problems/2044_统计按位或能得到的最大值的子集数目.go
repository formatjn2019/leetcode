package problems

func CountMaxOrSubsets(nums []int) int {
	return countMaxOrSubsets(nums)
}

func countMaxOrSubsets(nums []int) int {
	target := 0
	for _, num := range nums {
		target |= num
	}
	result := 0
	var dfsSearch func(int, int, []int)
	dfsSearch = func(depth, current int, ints []int) {
		if depth == len(ints) {
			if current == target {
				result++
			}
			return
		}
		dfsSearch(depth+1, current|ints[depth], ints)
		dfsSearch(depth+1, current, ints)
	}
	dfsSearch(0, 0, nums)
	return result
}
