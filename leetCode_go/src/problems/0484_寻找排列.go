package problems

func FindPermutation(s string) []int {
	return findPermutation(s)
}
func findPermutation(s string) []int {
	result := make([]int, len(s)+1)
	for i := 0; i <= len(s); i++ {
		result[i] = i + 1
	}
	cArr := []rune(s)
	for i := 0; i < len(cArr); i++ {
		lp, rp := i, i
		for ; i < len(cArr) && cArr[i] != 'I'; i++ {
			rp++
		}
		for lp < rp {
			result[lp], result[rp] = result[rp], result[lp]
			lp++
			rp--
		}
	}
	return result
}
