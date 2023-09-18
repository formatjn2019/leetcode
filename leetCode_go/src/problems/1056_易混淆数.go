package problems

func confusingNumber(n int) bool {
	nn := 0
	revMap := map[int]int{
		0: 0,
		1: 1,
		6: 9,
		8: 8,
		9: 6,
	}
	for t := n; t > 0; t /= 10 {
		if rev, ok := revMap[t%10]; !ok {
			return false
		} else {
			nn = nn*10 + rev
		}
	}
	return nn != n
}
