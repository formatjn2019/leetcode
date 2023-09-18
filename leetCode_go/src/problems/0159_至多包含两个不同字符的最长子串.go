package problems

func LengthOfLongestSubstringTwoDistinct(s string) int {
	return lengthOfLongestSubstringTwoDistinct(s)
}

func lengthOfLongestSubstringTwoDistinct(s string) int {
	var result int
	arr := []rune(s)
	countMap := map[rune]int{}
	lp, rp := 0, 0
	for rp < len(arr) && lp < len(arr) {
		//扩张
		if len(countMap) < 2 || countMap[arr[rp]] > 0 {
			countMap[arr[rp]]++
			rp++
			if rp-lp > result {
				result = rp - lp
			}
		} else {
			//收缩
			countMap[arr[lp]]--
			if countMap[arr[lp]] == 0 {
				delete(countMap, arr[lp])
			}
			lp++
		}
	}
	return result
}
