package problems

func subtractProductAndSum(n int) int {
	sum, prod := 0, 1
	for t := n; t > 0; t /= 10 {
		sum += t % 10
		prod *= t % 10
	}
	return prod - sum
}
