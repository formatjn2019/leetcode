package problems

func numKLenSubstrNoRepeats(s string, k int) int {
	var result int
	charMap, sArr := map[rune]int{}, []rune(s)
	for idx, c := range sArr {
		if idx >= k {
			ec := sArr[idx-k]
			charMap[ec]--
			if charMap[ec] == 0 {
				delete(charMap, ec)
			}
		}
		charMap[c]++
		if len(charMap) == k {
			result++
		}
	}
	return result
}
