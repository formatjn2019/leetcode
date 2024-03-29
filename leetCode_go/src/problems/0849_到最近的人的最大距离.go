package problems

func maxDistToClosest(seats []int) int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	//首尾最大距离
	result, n := 1, len(seats)
	//头
	for i := 0; i < n && seats[i] == 0; i++ {
		result = max(result, i-0+1)
	}
	//尾
	for i := n - 1; i >= 0 && seats[i] == 0; i-- {
		result = max(result, n-i)
	}
	//空
	start := -1
	for i := 0; i < n; i++ {
		if seats[i] == 1 {
			start = -1
		} else if seats[i] == 0 && start == -1 {
			start = i
		} else {
			result = max(result, (i-start+2)/2)
		}
	}
	return result
}
