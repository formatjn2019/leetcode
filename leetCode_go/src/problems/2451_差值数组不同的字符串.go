package problems

func OddString(words []string) string {
	return oddString(words)
}
func oddString(words []string) string {
	//取得公共
	getArr := func(str string) string {
		arr := []rune(str)
		head := arr[0]
		for i, c := range arr {
			arr[i] = c - head + 'a'
		}
		return string(arr)
	}
	common := getArr(words[0])
	if common != getArr(words[1]) && common != getArr(words[2]) {
		return words[0]
	}
	for _, str := range words {
		if getArr(str) != common {
			return str
		}
	}
	return ""
}
