package problems

func minCostClimbingStairs(cost []int) int {
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	arr := make([]int, len(cost)+1)
	for i := 2; i < len(arr); i++ {
		arr[i] = min(cost[i-1]+arr[i-1], cost[i-2]+arr[i-2])
	}
	return arr[len(arr)-1]
}
