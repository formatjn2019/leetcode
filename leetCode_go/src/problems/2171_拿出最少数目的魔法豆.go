package problems

import (
	"math"
	"sort"
)

var MinimumRemoval = minimumRemoval

func minimumRemoval(beans []int) int64 {
	sort.Ints(beans)
	n := len(beans)
	var sum int64
	for _, bean := range beans {
		sum += int64(bean)
	}
	result := int64(math.MaxInt64)
	for i, bean := range beans {
		if remove := sum - int64(bean*(n-i)); remove < result {
			result = remove
		}
	}
	return result
}
