package problems

import (
	"strings"
)

var MinExtraChar = minExtraChar

func minExtraChar(s string, dictionary []string) int {

	wordMap := [51][]string{}
	//记录末尾位置
	for _, word := range dictionary {
		start := 0
		for {
			idx := strings.Index(s[start:], word)
			if idx >= 0 {
				start += idx + len(word)
				wordMap[start] = append(wordMap[start], word)
			} else {
				break
			}
		}
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	result := make([]int, len(s)+1)

	for i := 1; i <= len(s); i++ {
		result[i] = result[i-1] + 1
		for _, word := range wordMap[i] {
			result[i] = min(result[i], result[i-len(word)])
		}
	}
	return result[len(s)]
}

func minExtraChar_timeout(s string, dictionary []string) int {
	dic := map[string]struct{}{}
	for _, word := range dictionary {
		dic[word] = struct{}{}
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	var dfs func(start, wc int) int
	dfs = func(start, wc int) int {
		if start == len(s) {
			return wc
		}
		result := len(s) - start + wc
		for i := 1; i+start <= len(s); i++ {
			// 跳过前i个字母
			result = min(result, dfs(i+start, wc+i))
			println(s[start : i+start])
			if _, ok := dic[s[start:i+start]]; ok {
				println(111)
				result = min(result, dfs(i+start, wc))
			}
		}
		return result
	}
	return dfs(0, 0)
}
