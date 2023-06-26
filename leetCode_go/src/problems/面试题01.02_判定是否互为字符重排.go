package problems

func CheckPermutation(s1 string, s2 string) bool {
	charCon := map[rune]int{}
	for _, c := range s1 {
		charCon[c]++
	}
	for _, c := range s2 {
		charCon[c]--
	}
	for _, v := range charCon {
		if v != 0 {
			return false
		}
	}
	return true
}
