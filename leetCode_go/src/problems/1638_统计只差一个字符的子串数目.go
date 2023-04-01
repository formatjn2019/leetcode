package problems

func CountSubstrings(s string, t string) int {
	return countSubstrings(s, t)
}
func countSubstrings(s string, t string) int {
	ln, rn := len(s), len(t)
	lSubs, rSubs := map[string]int{}, map[string]int{}
	for i := 0; i < ln; i++ {
		for j := i + 1; j <= ln; j++ {
			lSubs[s[i:j]]++
		}
	}
	for i := 0; i < rn; i++ {
		for j := i + 1; j <= rn; j++ {
			rSubs[t[i:j]]++
		}
	}
	result := 0
	for str, cln := range lSubs {
		for i := 0; i < len(str); i++ {
			tArr := []byte(str)
			for j := 1; j < 26; j++ {
				tArr[i] = (tArr[i]-'a'+1)%26 + 'a'
				if crn, ok := rSubs[string(tArr)]; ok {
					result += cln * crn
				}
			}
		}
	}
	return result
}
