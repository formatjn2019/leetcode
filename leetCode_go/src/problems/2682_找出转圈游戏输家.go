package problems

func circularGameLosers(n int, k int) []int {
	arr := make([]bool, n)
	arr[0] = true
	for i, idx := 1, 0; ; i++ {
		idx = (idx + i*k) % n
		if arr[idx] == true {
			break
		} else {
			arr[idx] = true
		}
	}
	result := []int{}
	for i, res := range arr {
		if !res {
			result = append(result, i+1)
		}
	}
	return result
}
