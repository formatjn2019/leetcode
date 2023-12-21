package problems

func myPow(x float64, n int) float64 {
	if n < 0 {
		return 1 / myPow(x, -n)
	} else if n == 0 {
		return 1
	} else if n == 1 {
		return x
	} else if n%2 == 0 {
		t := myPow(x, n/2)
		return t * t
	} else {
		return myPow(x, n-1) * x
	}
}
