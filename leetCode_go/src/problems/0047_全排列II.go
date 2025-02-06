package problems

var PermuteUnique = permuteUnique

func permuteUnique(nums []int) [][]int {
	var result = make([][]int, 0)
	nc := make([]int, 21)
	for _, num := range nums {
		nc[num+10]++
	}

	count := len(nums)
	tArr := make([]int, count)
	var dfs func(int)
	dfs = func(remain int) {
		if remain == 0 {
			dist := make([]int, count)
			copy(dist, tArr)
			result = append(result, dist)
			return
		}
		for i := 0; i < len(nc); i++ {
			if nc[i] > 0 {
				nc[i]--
				tArr[count-remain] = i - 10
				dfs(remain - 1)
				nc[i]++
			}
		}
	}
	dfs(count)

	return result
}
