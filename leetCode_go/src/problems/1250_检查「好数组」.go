package problems

func isGoodArray(nums []int) bool {
	g := nums[0]
	gcd := func(x, y int) int {
		for x != 0 {
			x, y = y%x, x
		}
		return y
	}
	for _, num := range nums {
		g = gcd(g, num)
		if g == 1 {
			return true
		}
	}
	return false
}
