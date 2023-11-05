package problems

func countLetters(s string) int {
	pre, count := ' ', 0
	con := func(n int) int {
		return (n + 1) * n / 2
	}
	var result int
	for _, c := range s {
		if pre == c {
			count++
		} else {
			result += con(count)
			pre, count = c, 1
		}
	}
	result += con(count)
	return result
}
