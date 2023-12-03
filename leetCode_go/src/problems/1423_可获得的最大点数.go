package problems

func maxScore(cardPoints []int, k int) int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	sum, n := 0, len(cardPoints)
	//倒序
	for lp := n - 1; n-lp-1 < k; lp-- {
		sum += cardPoints[lp]
	}
	result := sum
	//正序
	for lp, rp := n-k, 0; lp < n; lp, rp = lp+1, rp+1 {
		sum = sum - cardPoints[lp] + cardPoints[rp]
		result = max(result, sum)
	}
	return result
}
