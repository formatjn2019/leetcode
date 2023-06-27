package problems

func MaximumSum(arr []int) int {
	return maximumSum(arr)
}

func maximumSum(arr []int) int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	result, leftSum, leftMaxSum, n := arr[0], arr[0], 0, len(arr)
	for i := 1; i < n; i++ {
		leftSum, leftMaxSum = max(leftSum+arr[i], arr[i]), max(leftMaxSum+arr[i], leftSum)
		result = max(result, max(leftSum, leftMaxSum))
	}
	return result
}

func maximumSum_enum(arr []int) int {
	prefixSumArr, n := make([]int, len(arr)+1), len(arr)
	for i, num := range arr {
		prefixSumArr[i+1] = prefixSumArr[i] + num
	}
	min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	result := -100000
	for lp := 0; lp < n; lp++ {
		result = max(result, arr[lp])
		//从正数开始
		if arr[lp] > 0 {
			minNum := arr[lp]
			for rp := lp + 1; rp < n; rp++ {
				minNum = min(minNum, arr[rp])
				if arr[rp] > 0 {
					//前缀和足够，则选中，否则放弃
					if prefixSumArr[rp+1]-prefixSumArr[lp]-minNum <= 0 {
						break
					}
					result = max(result, max(prefixSumArr[rp+1]-prefixSumArr[lp]-minNum, prefixSumArr[rp+1]-prefixSumArr[lp]))
				}
			}
		}
	}
	return result
}

func maximumSum_timeout(arr []int) int {
	prefixSumArr, n := make([]int, len(arr)+1), len(arr)
	for i, num := range arr {
		prefixSumArr[i+1] = prefixSumArr[i] + num
	}
	min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	result := -100000
	for lp := 0; lp < n; lp++ {
		minNum := arr[lp]
		for rp := lp; rp < n; rp++ {
			minNum = min(minNum, arr[rp])
			if lp == rp {
				result = max(result, arr[lp])
			} else {
				result = max(result, max(prefixSumArr[rp+1]-prefixSumArr[lp]-minNum, prefixSumArr[rp+1]-prefixSumArr[lp]))
			}
		}
	}
	return result
}
