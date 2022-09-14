package problems

import (
	"sort"
)

func TrimMean(arr []int) float64 {
	return trimMean(arr)
}

func trimMean(arr []int) float64 {
	sort.Ints(arr)
	sum := 0
	for i := len(arr) / 20; i < len(arr)-len(arr)/20; i++ {
		sum += arr[i]
	}
	return float64(sum) / (float64(len(arr)) * float64(0.9))
}
