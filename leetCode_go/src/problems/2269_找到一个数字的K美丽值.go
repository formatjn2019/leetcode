package problems

func DivisorSubstrings(num int, k int) int {
	return divisorSubstrings(num, k)
}

func divisorSubstrings(num int, k int) int {
	div, result := 1, 0
	for i := 0; i < k; i++ {
		div *= 10
	}
	for n := num; n*10 >= div; n /= 10 {
		d := n % div
		if d != 0 && num%d == 0 {
			result++
		}
	}
	return result
}
