package problems

func findKOr(nums []int, k int) int {
	bitArr := make([]int, 32)
	for _, num := range nums {
		for i := 0; num > 0; i++ {
			bitArr[i] += num & 1
			num = num >> 1
		}
	}
	var result int
	for i, c := range bitArr {
		if c >= k {
			result = result | (1 << i)
		}
	}
	return result
}
