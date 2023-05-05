package problems

import (
	"sort"
)

func LongestStrChain(words []string) int {
	return longestStrChain(words)
}
func longestStrChain(words []string) int {
	sort.Slice(words, func(i, j int) bool {
		return len(words[i]) < len(words[j])
	})
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	countDic := map[string]int{}
	result := 0
	for _, word := range words {
		for i := range word {
			pre := word[0:i] + word[i+1:]
			countDic[word] = max(countDic[word], countDic[pre]+1)
		}
		result = max(countDic[word], result)
	}
	return result
}
