package problems

func numJewelsInStones(jewels string, stones string) int {
	jewelMap := map[rune]bool{}
	for _, c := range []rune(jewels) {
		jewelMap[c] = true
	}
	result := 0
	for _, c := range stones {
		if jewelMap[c] {
			result++
		}
	}
	return result
}
