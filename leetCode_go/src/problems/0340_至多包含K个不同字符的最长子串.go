package problems

func lengthOfLongestSubstringKDistinct(s string, k int) int {
	var result int
	arr := []rune(s)
	countMap := map[rune]int{}
	lp, rp := 0, 0
	for rp < len(arr) && lp < len(arr) {
		//扩张
		if len(countMap) < k || countMap[arr[rp]] > 0 {
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
