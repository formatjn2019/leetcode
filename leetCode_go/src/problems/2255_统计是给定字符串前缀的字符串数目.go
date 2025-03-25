package problems

func CountPrefixes(words []string, s string) int {
	return countPrefixes(words, s)
}

func countPrefixes(words []string, s string) int {
	var result int

	prefixMap := make(map[string]struct{})

	for i := 1; i <= len(s); i++ {
		prefixMap[s[:i]] = struct{}{}
	}

	for _, w := range words {
		if _, ok := prefixMap[w]; ok {
			result++
		}
	}

	return result
}
