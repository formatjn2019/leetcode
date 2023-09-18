package problems

func GroupStrings(strings []string) [][]string {
	return groupStrings(strings)
}
func groupStrings(strings []string) [][]string {
	var result [][]string
	resultMap := map[string][]string{}
	getUid := func(o string) string {
		arr := []rune(o)
		dif := arr[0] - 'a'
		for i := len(arr) - 1; i >= 0; i-- {
			arr[i] = (arr[i]-dif+26-'a')%26 + 'a'
		}
		return string(arr)
	}
	for _, str := range strings {
		k := getUid(str)
		resultMap[k] = append(resultMap[k], str)
	}
	for _, arr := range resultMap {
		result = append(result, arr)
	}
	return result
}
