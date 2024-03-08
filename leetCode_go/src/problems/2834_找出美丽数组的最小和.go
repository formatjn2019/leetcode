package problems

var MinimumPossibleSum = minimumPossibleSum

func minimumPossibleSum(n int, target int) int {
	mod := 1000000007
	cal := func(x, y int) int {
		return ((x + y) * (y - x + 1) / 2) % mod
	}

	if n <= target/2 {
		return cal(1, n)
	} else {
		return (cal(1, target/2) + cal(target, target+n-target/2-1)) % mod
	}
}

func minimumPossibleSum_enum(n int, target int) int {
	result := 0

	memery := map[int]bool{}
	for t := 1; n > 0; n-- {
		for memery[target-t] {
			t++
		}
		result += t
		memery[t] = true
		memery[target-t] = true
	}
	return result
}
