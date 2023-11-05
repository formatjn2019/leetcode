package problems

func countDigits(num int) int {
	var result int
	for tn := num; tn > 0; tn /= 10 {
		if tn%10 != 0 && num%(tn%10) == 0 {
			result++
		}
	}
	return result
}
