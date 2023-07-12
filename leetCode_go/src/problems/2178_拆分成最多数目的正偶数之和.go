package problems

func maximumEvenSplit(finalSum int64) []int64 {
	if finalSum%2 == 1 {
		return []int64{}
	}
	result := make([]int64, 0)
	var max int64
	for finalSum > 0 {
		max += 2
		if 2*max < finalSum {
			result = append(result, max)
			finalSum -= max
		} else {
			result = append(result, finalSum)
			break
		}
	}
	return result
}
