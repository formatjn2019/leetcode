package problems

import "math"

func PivotInteger(n int) int {
	return pivotInteger(n)
}

func pivotInteger(n int) int {
	result := math.Sqrt(float64(n*n+n) / 2)
	if math.Ceil(result) == result {
		return int(result)
	}
	return -1
}
