package problems

func Shuffle(nums []int, n int) []int {
	return shuffle(nums, n)
}

func shuffle(nums []int, n int) []int {
	result := make([]int, 2*n)
	for i := 0; i < 2*n; i += 2 {
		result[i] = nums[i/2]
		result[i+1] = nums[i/2+n]
	}
	return result
}
