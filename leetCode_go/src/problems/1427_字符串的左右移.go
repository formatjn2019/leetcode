package problems

func stringShift(s string, shift [][]int) string {
	dif := 0
	for _, a := range shift {
		if a[0] == 1 {
			dif -= a[1]
		} else {
			dif += a[1]
		}
	}
	for dif < 0 {
		dif += len(s)
	}
	dif %= len(s)
	return s[dif:] + s[0:dif]
}
