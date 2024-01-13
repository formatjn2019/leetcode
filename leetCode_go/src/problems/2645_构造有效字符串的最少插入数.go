package problems

func addMinimum(word string) int {
	var result int
	cArr := []rune(word)
	expect := 0
	for p := 0; p < len(word); expect++ {
		if c := cArr[p]; c == rune(expect%3+'a') {
			p++
		} else {
			result++
		}
	}
	result += int('c' - cArr[len(cArr)-1])
	return result
}
