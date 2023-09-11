package problems

func findMaxConsecutiveOnes(nums []int) int {
	var result int
	pre, cur := 0, 0
	for idx, num := range nums {
		if num == 1 {
			cur++
		} else {
			pre, cur = cur, 0
		}
		if pre+cur+1 > idx {
			result = idx + 1
		} else if pre+cur+1 > result {
			result = pre + cur + 1
		}
	}
	return result
}
