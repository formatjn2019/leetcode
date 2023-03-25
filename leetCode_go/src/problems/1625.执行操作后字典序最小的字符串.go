package problems

func FindLexSmallestString(s string, a int, b int) string {
	return findLexSmallestString(s, a, b)
}
func findLexSmallestString(s string, a int, b int) string {
	resultSet, n := map[string]bool{}, len(s)
	result := s
	var dfsSearch func(string)
	dfsSearch = func(s string) {
		if _, ok := resultSet[s]; !ok {
			if s < result {
				result = s
			}
			resultSet[s] = true
			arr := []rune(s)
			//加
			for t := 1; t < n; t += 2 {
				arr[t] = (arr[t]-'0'+rune(a))%10 + '0'
			}
			dfsSearch(string(arr))
			//转
			dfsSearch(string(append(arr[b%n:], arr[0:b%n]...)))
		}
	}
	dfsSearch(s)
	return result
}
