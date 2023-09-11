package problems

func canPermutePalindrome(s string) bool {
	charMap := map[rune]bool{}
	for _, c := range []rune(s) {
		if !charMap[c] {
			charMap[c] = true
		} else {
			delete(charMap, c)
		}
	}
	return len(charMap) < 2
}
