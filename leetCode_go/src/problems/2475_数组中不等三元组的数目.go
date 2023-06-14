package problems

func UnequalTriplets(nums []int) int {
	return unequalTriplets(nums)
}
func unequalTriplets(nums []int) int {
	numCount := map[int]int{}
	for _, num := range nums {
		numCount[num]++
	}

	// map转array
	keys := make([]int, 0, len(numCount))
	for k := range numCount {
		keys = append(keys, k)
	}
	result := 0
	var dfs func(int, int, int)
	dfs = func(idx, product, count int) {
		if idx == len(keys) {
			if count == 3 {
				result += product
			}
			return
		}
		if count < 3 {
			if product == 0 {
				dfs(idx+1, numCount[keys[idx]], count+1)
			} else {
				dfs(idx+1, numCount[keys[idx]]*product, count+1)
			}
		}
		dfs(idx+1, product, count)
	}
	dfs(0, 0, 0)
	//println(result)
	return result
}
