package problems

func climbStairs_timeout(n int) int {
	if n < 3 {
		return n
	} else {
		return climbStairs_timeout(n-1) + climbStairs_timeout(n-2)
	}
}
func climbStairs(n int) int {
	if n < 3 {
		return n
	}
	resultArr := []int{1, 2, 0}

	for p := 2; p < n; p++ {
		resultArr[p%3] = resultArr[(p+1)%3] + resultArr[(p+2)%3]
	}
	return resultArr[n%3]
}
