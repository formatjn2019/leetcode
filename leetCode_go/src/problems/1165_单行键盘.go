package problems

func calculateTime(keyboard string, word string) int {
	idxMap := map[rune]int{}
	kArr, wArr := []rune(keyboard), []rune(word)
	abs := func(x, y rune) int {
		if idxMap[x] > idxMap[y] {
			return idxMap[x] - idxMap[y]
		}
		return idxMap[y] - idxMap[x]
	}
	for idx, c := range []rune(keyboard) {
		idxMap[c] = idx
	}
	result := abs(kArr[0], wArr[0])
	for i := 1; i < len(wArr); i++ {
		result += abs(wArr[i-1], wArr[i])
	}
	return result
}
