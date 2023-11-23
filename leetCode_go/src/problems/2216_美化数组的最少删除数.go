package problems

func minDeletion(nums []int) int {
	p := 0
	var result int
	for p < len(nums) {
		if p+1 < len(nums) && (p-result)%2 == 0 && nums[p] == nums[p+1] {
			p++
			result++
		} else {
			p += 2
		}
	}
	if (len(nums)-result)%2 == 0 {
		return result
	} else {
		return result + 1
	}
}
