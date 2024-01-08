package problems

func MinCost(nums []int, x int) int64 {
	return minCost(nums, x)
}

func minCost(nums []int, x int) int64 {
	//n := len(nums)
	resultArr := make([]int, len(nums))
	var result int64
	copy(resultArr, nums)
	for _, num := range resultArr {
		result += int64(num)
	}
	for replaceFlag, repl := true, 1; replaceFlag; repl++ {
		replaceFlag = false
		diffSum := 0
		// 位移
		nums = append(nums, nums[0])[1:]
		for i, num := range nums {
			if dif := num - resultArr[i]; dif < 0 {
				diffSum -= dif
				resultArr[i] = num
			}
		}
		if diffSum > x {
			result -= int64(diffSum - x)
			replaceFlag = true
		}
	}
	return result
}
