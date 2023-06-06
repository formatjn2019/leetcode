package problems

func applyOperations(nums []int) []int {
	for i := 0; i < len(nums)-1; i++ {
		if nums[i] == nums[i+1] {
			nums[i] *= 2
			nums[i+1] = 0
		}
	}
	lp := 0
	for rp := 0; rp < len(nums); rp++ {
		if nums[rp] != 0 {
			if lp != rp {
				nums[lp] = nums[rp]
				nums[rp] = 0
			}
			lp++
		}
	}
	return nums
}
