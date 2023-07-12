package problems

func alternateDigitSum(n int) int {
	result, sign := 0, 1
	for ; n > 0; n /= 10 {
		result += sign * (n % 10)
		sign *= -1
	}
	return -sign * result
}
