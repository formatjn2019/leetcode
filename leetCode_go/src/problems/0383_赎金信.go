package problems

import "fmt"

func CanConstruct(ransomNote string, magazine string) bool {
	return canConstruct(ransomNote, magazine)
}

func canConstruct(ransomNote string, magazine string) bool {
	cCount := [26]int{}
	for _, c := range ransomNote {
		cCount[c-'a']++
	}
	for _, c := range magazine {
		cCount[c-'a']--
	}
	fmt.Println(cCount)
	for _, cn := range cCount {
		if cn > 0 {
			return false
		}
	}
	return true
}
