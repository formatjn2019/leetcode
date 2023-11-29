package problems

func sumSubarrayMins(arr []int) int {
	var searchAndCount func(l, r int) int
	searchAndCount = func(l, r int) int {
		if l == r {
			return 0
		}
		mp := l
		for tp := l; tp < r; tp++ {
			if arr[mp] > arr[tp] {
				mp = tp
			}
		}
		lc, rc := mp-l+1, r-mp
		return (searchAndCount(l, mp) + searchAndCount(mp+1, r) + lc*rc*arr[mp]) % (1e9 + 7)
	}
	return searchAndCount(0, len(arr))
}

func sumSubarrayMins_timeout(arr []int) int {
	l := len(arr)
	var result int
	for i := 0; i < l; i++ {
		mp := i
		for j := i; j < l; j++ {
			if arr[mp] > arr[j] {
				mp = j
			}
			result = (result + arr[mp]) % (1e9 + 7)
		}
	}
	return result
}
