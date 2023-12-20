package problems

func isAcronym(words []string, s string) bool {
	if len(words) != len(s) {
		return false
	}
	cArr := []rune(s)
	for i, word := range words {
		if cArr[i] != ([]rune(word))[0] {
			return false
		}
	}
	return true
}
