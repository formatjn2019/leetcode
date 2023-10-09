package problems

func PassThePillow(n int, time int) int {
	return passThePillow(n, time)
}

func passThePillow(n int, time int) int {
	time %= (n - 1) * 2
	if time < n {
		return time + 1
	} else {
		return 2*n - time - 1
	}
}
