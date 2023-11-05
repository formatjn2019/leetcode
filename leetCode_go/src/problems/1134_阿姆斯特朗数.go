package problems

import "math"

func IsArmstrong(n int) bool {
	return isArmstrong(n)
}

func isArmstrong(n int) bool {
	var sum int
	length := math.Ceil(math.Log10(float64(n + 1)))
	for t := n; t > 0; t /= 10 {
		mod := t % 10
		sum += int(math.Pow(float64(mod), length))
	}
	return sum == n
}
