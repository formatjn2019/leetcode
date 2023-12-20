package problems

func FindPeakElement(nums []int) int {
	return findPeakElement(nums)
}

func findPeakElement(nums []int) int {
	lp, rp, n := 0, len(nums), len(nums)
	for lp < rp {
		mid := (lp + rp) / 2
		if mid == 0 || (mid > 0 && nums[mid] > nums[mid-1]) {
			if mid == n-1 || (mid < n-1 && nums[mid] > nums[mid+1]) {
				return mid
			}
			lp = mid + 1
		} else {
			rp = mid
		}
	}
	return -1
}
