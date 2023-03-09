package problems

func MinimumRecolors(blocks string, k int) int {
	return minimumRecolors(blocks, k)
}
func minimumRecolors(blocks string, k int) int {
	lc, rc, arr := 0, 0, []rune(blocks)
	for i := 0; i < k; i++ {
		if arr[i] == 'W' {
			rc++
		}
	}
	result := rc - lc
	for i := 0; result > 0 && i < len(arr)-k; i++ {
		if arr[i] == 'W' {
			lc++
		}
		if arr[i+k] == 'W' {
			rc++
		}
		if rc-lc < result {
			result = rc - lc
		}
	}
	return result
}
