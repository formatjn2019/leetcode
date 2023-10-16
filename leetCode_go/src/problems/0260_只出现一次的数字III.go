package problems

func SingleNumber(nums []int) []int {
	return singleNumber(nums)
}
func singleNumber(nums []int) []int {
	xorNum := 0
	for _, num := range nums {
		xorNum ^= num
	}
	tpN := xorNum & -xorNum
	n1, n2 := 0, 0
	for _, num := range nums {
		if num&tpN > 0 {
			n1 ^= num
		} else {
			n2 ^= num
		}
	}
	return []int{n1, n2}
}
