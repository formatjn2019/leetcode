package problems

func findSubarrays(nums []int) bool {
	sumMap := map[int]bool{}
	for i := 1; i < len(nums); i++ {
		if _, ok := sumMap[nums[i]+nums[i-1]]; ok {
			return true
		}
		sumMap[nums[i]+nums[i-1]] = true
	}
	return false
}
