package problems

func CountOfSubstrings(word string, k int) int {
	return countOfSubstrings(word, k)
}

func countOfSubstrings(word string, k int) int {
	var result int
	arr := []rune(word)
	lp, rp, oc := 0, 0, 0
	runeCount := map[rune]int{}
	for rp < len(arr) {
		// 右指针前移寻找有效值
	outter:
		for ; rp < len(arr); rp++ {
			switch c := arr[rp]; c {
			case 'a', 'e', 'i', 'o', 'u':
				runeCount[c]++
			default:
				oc++
				if oc > k {
					break outter
				}
			}
			if oc == k && len(runeCount) == 5 {
				result++
			}
		}
		if rp != len(arr) {
			oc--
		}

		// 左指针前移消除有效值
		for ; oc == k && lp < len(arr); lp++ {
			switch c := arr[lp]; c {
			case 'a', 'e', 'i', 'o', 'u':
				runeCount[c]--
				if runeCount[c] == 0 {
					delete(runeCount, c)
				}
			default:
				oc--
			}
			if oc == k && len(runeCount) == 5 {
				result++
			}
		}
	}
	return result
}
