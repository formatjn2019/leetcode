package problems

func LongestWPI(hours []int) int {
	return longestWPI(hours)
}

// 前缀和 哈希表
func longestWPI(hours []int) int {
	prefixSumArr := make([]int, len(hours)+1)
	result := 0
	sumPrefixMap := map[int]int{0: 0}
	for idx, hour := range hours {
		if hour > 8 {
			prefixSumArr[idx+1] = prefixSumArr[idx] + 1
		} else {
			prefixSumArr[idx+1] = prefixSumArr[idx] - 1
		}
		if _, ok := sumPrefixMap[prefixSumArr[idx+1]]; !ok {
			sumPrefixMap[prefixSumArr[idx+1]] = idx + 1
		}
	}
	// fmt.Println(strings.Repeat("*", 100))
	for i := 1; i <= len(hours); i++ {
		if prefixSumArr[i] > 0 {
			result = i
		} else {
			if idx, ok := sumPrefixMap[prefixSumArr[i]-1]; ok {
				if result < i-idx {
					result = i - idx
				}
			}
		}
	}
	// println(result)
	return result
}

// 前缀和 模拟
func longestWPI_simulate(hours []int) int {
	prefixSumArr := make([]int, len(hours)+1)
	result := 0
	for idx, hour := range hours {
		if hour > 8 {
			prefixSumArr[idx+1] = prefixSumArr[idx] + 1
		} else {
			prefixSumArr[idx+1] = prefixSumArr[idx] - 1
		}
	}
	// fmt.Println(prefixSumArr)
	// fmt.Println(strings.Repeat("*", 100))
	for i := 1; i <= len(hours); i++ {
		//剪枝
		for j := 0; j < i-result; j++ {
			if prefixSumArr[i]-prefixSumArr[j] > 0 {
				result = i - j
			}
		}
	}
	// println(result)
	return result
}
