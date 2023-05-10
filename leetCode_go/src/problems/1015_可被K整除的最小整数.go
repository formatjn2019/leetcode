package problems

func smallestRepunitDivByK(k int) int {
	if k%10%2 == 0 || k%5 == 0 {
		return -1
	}
	result, remain := 1, 1
	for ; remain != 0 && result < k; result++ {
		remain = (remain*10 + 1) % k
	}
	return result
}
