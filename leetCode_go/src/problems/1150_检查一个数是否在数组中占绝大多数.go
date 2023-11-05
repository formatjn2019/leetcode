package problems

func IsMajorityElement(nums []int, target int) bool {
	return isMajorityElement(nums, target)
}

func isMajorityElement(nums []int, target int) bool {
	idx := len(nums) / 2
	lp, rp := idx, idx
	for lp >= 0 && nums[lp] == target {
		lp--
	}
	for rp < len(nums) && nums[rp] == target {
		rp++
	}
	return rp-lp-1 > len(nums)/2
}
