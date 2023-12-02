package problems

func closeStrings(word1 string, word2 string) bool {
	getTag := func(word string) (id int, countMap map[int]int) {
		countMap = map[int]int{}
		arr := [26]int{}
		for _, c := range word {
			arr[c-'a']++
		}
		for i, c := range arr {
			if c > 0 {
				id |= 1 << i
				countMap[c]++
			}
		}
		return id, countMap
	}

	id, countMap := getTag(word1)
	id2, countMap2 := getTag(word2)
	if id != id2 {
		return false
	}
	for k, v := range countMap {
		if countMap2[k] != v {
			return false
		}
	}
	return true
}
