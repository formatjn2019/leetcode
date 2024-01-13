package problems

func countWords(words1 []string, words2 []string) int {
	wordCount := map[string]int{}
	for _, word := range words1 {
		wordCount[word] += 1
	}
	for _, word := range words2 {
		wordCount[word] += 1 << 10
	}
	var result int
	for _, count := range wordCount {
		if count == (1 | (1 << 10)) {
			result++
		}
	}
	return result
}
