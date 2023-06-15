package problems

func canMakePaliQueries(s string, queries [][]int) []bool {
	prefixSumMatrix := make([]int, len(s)+1)
	for i, c := range s {
		prefixSumMatrix[i+1] = prefixSumMatrix[i] ^ (1 << (c - 'a'))
	}
	result := make([]bool, 0, len(queries))
	for _, arr := range queries {
		start, end, count, sum := arr[0], arr[1], arr[2], 0
		//tmp := prefixSumMatrix[end+1] ^ prefixSumMatrix[start]
		for tmp := prefixSumMatrix[end+1] ^ prefixSumMatrix[start]; tmp > 0; tmp >>= 1 {
			if tmp&1 == 1 {
				sum++
			}
		}
		result = append(result, sum/2 <= count)
	}
	return result
}

func canMakePaliQueries_array(s string, queries [][]int) []bool {
	prefixSumMatrix := make([][26]int, len(s)+1)
	for i, c := range s {
		prefixSumMatrix[i+1][c-'a']++
		for j, num := range prefixSumMatrix[i] {
			prefixSumMatrix[i+1][j] += num
		}
	}
	result := make([]bool, 0, len(queries))
	for _, arr := range queries {
		start, end, count, sum := arr[0], arr[1], arr[2], 0
		for j := 0; j < 26; j++ {
			sum += (prefixSumMatrix[end+1][j] - prefixSumMatrix[start][j]) % 2
		}
		result = append(result, sum/2 <= count)
	}
	return result
}

func canMakePaliQueries_timeout(s string, queries [][]int) []bool {
	changeCount := map[string]int{}
	result := make([]bool, 0, len(queries))
	for _, arr := range queries {
		str := s[arr[0] : arr[1]+1]
		if _, ok := changeCount[str]; !ok {
			charCount := make([]int, 26)
			for _, c := range str {
				charCount[c-'a']++
			}
			sum := 0
			for _, con := range charCount {
				sum += con % 2
			}
			changeCount[str] = sum / 2
		}
		result = append(result, changeCount[str] <= arr[2])
	}
	return result
}
