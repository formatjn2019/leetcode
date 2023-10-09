package problems

func numSub(s string) int {
	result := int64(0)
	numCount := int64(0)
	for _, c := range s {
		switch c {
		case '1':
			numCount++
		default:
			if numCount > 0 {
				result = calculateMod(numCount, result)
				numCount = 0
			}
		}
	}
	result = calculateMod(numCount, result)
	return int(result)
}

func calculateMod(len, preCount int64) int64 {
	preCount += (1 + len) * len / 2
	return preCount % 1000000007
}
