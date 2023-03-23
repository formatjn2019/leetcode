package _30312

func vowelStrings(words []string, left int, right int) int {
	charSet := map[rune]bool{'a': true, 'e': true, 'u': true, 'i': true, 'o': true}
	arr := words[left : right+1]
	result := 0
	for _, word := range arr {
		if charSet[[]rune(word)[0]] && charSet[[]rune(word)[len(word)-1]] {
			result++
		}
	}
	return result
}
