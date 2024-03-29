package problems

func vowelStrings(words []string, queries [][]int) []int {
	result := make([]int, len(queries))
	vowelMap := map[byte]bool{
		'a': true, 'e': true, 'i': true, 'o': true, 'u': true,
	}
	prefixSumArr := make([]int, len(words)+1)
	for i, word := range words {
		prefixSumArr[i+1] = prefixSumArr[i]
		if vowelMap[word[0]] && vowelMap[word[len(word)-1]] {
			prefixSumArr[i+1]++
		}
	}
	for i, arr := range queries {
		result[i] = prefixSumArr[arr[1]+1] - prefixSumArr[arr[0]]
	}
	return result
}
