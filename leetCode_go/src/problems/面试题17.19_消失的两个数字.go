package problems

func MissingTwo(nums []int) []int {
	return missingTwo(nums)
}

func missingTwo(nums []int) []int {
	tArr := make([]int, 2)
	getIndex := func(index int) int {
		if index < len(nums) {
			return nums[index]
		} else {
			return tArr[index-len(nums)]
		}
	}
	setIndex := func(index, num int) {
		if index < len(nums) {
			nums[index] = num
		} else {
			tArr[index-len(nums)] = num
		}
	}
	N := len(nums) + 2
	for i := 0; i < N; i++ {
		for getIndex(i) != 0 && getIndex(i) != i+1 {
			nNum := getIndex(i)
			setIndex(i, getIndex(nNum-1))
			setIndex(nNum-1, nNum)
		}
	}
	result := make([]int, 0, 2)
	for i := 0; i < N; i++ {
		if getIndex(i) == 0 {
			result = append(result, i+1)
		}
	}

	return result
}
