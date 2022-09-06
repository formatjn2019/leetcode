package problems

func UniqueLetterString(s string) int {
	return uniqueLetterString(s)
}

//数学
func uniqueLetterString(s string) int {
	result := 0
	charIndexs := make([][]int, 26)
	for index, char := range []byte(s) {
		charIndexs[char-'A'] = append(charIndexs[char-'A'], index)
	}

	for _, arr := range charIndexs {
		if len(arr) == 0 {
			continue
		}
		arr = append([]int{-1}, arr...)
		arr = append(arr, len(s))
		for i := 1; i < len(arr)-1; i++ {
			result += (arr[i] - arr[i-1]) * (arr[i+1] - arr[i])
		}
	}
	return result

}

//暴力
func uniqueLetterString_enumeration(s string) int {
	result := 0
	var strCont []int
	charArr := []byte(s)
	for i := 0; i < len(s); i++ {
		strCont = make([]int, 26)
		allRepeat := 0
		preCount := 0
		for j := i; j < len(s) && allRepeat < 26; j++ {
			if strCont[charArr[j]-'A'] == 0 {
				strCont[charArr[j]-'A']++
				preCount++
			} else if strCont[charArr[j]-'A'] == 1 {
				strCont[charArr[j]-'A']++
				allRepeat++
				preCount--
			} else {
				strCont[charArr[j]-'A']++
			}
			result += preCount
		}
	}
	return result
}
