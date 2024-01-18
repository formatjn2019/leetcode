package problems

func maximumNumberOfStringPairs(words []string) int {
	var result int
	wordCount := map[string]int{}
	for _, word := range words {
		arr := []byte(word)
		n := len(arr)
		for i := 0; i < n/2; i++ {
			arr[i], arr[n-1-i] = arr[n-1-i], arr[i]
		}
		wordCount[word]++
		if nWord := string(arr); nWord != word {
			wordCount[nWord]++
		}
	}
	for _, count := range wordCount {
		if count > 1 {
			result++
		}
	}
	return result / 2
}
