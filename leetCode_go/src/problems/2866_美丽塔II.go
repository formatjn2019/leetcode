package problems

func MaximumSumOfHeights(maxHeights []int) int64 {
	return maximumSumOfHeights(maxHeights)
}

func maximumSumOfHeights(maxHeights []int) int64 {
	lSumArr, rSumArr := make([]int64, len(maxHeights)), make([]int64, len(maxHeights))
	//单增栈 上升求和
	stack := make([]int, 0)
	for i, height := range maxHeights {

		for len(stack) > 0 && maxHeights[stack[len(stack)-1]] > height {
			stack = stack[:len(stack)-1]
		}
		if len(stack) == 0 {
			lSumArr[i] = int64(height * (i + 1))
		} else {
			pre := stack[len(stack)-1]
			lSumArr[i] = lSumArr[pre] + int64((i-pre)*height)
		}
		stack = append(stack, i)
	}
	// 单增栈 逆序求和
	stack = make([]int, 0)
	for i := len(maxHeights) - 1; i >= 0; i-- {
		height := maxHeights[i]
		for len(stack) > 0 && maxHeights[stack[len(stack)-1]] > height {
			stack = stack[:len(stack)-1]
		}
		if len(stack) == 0 {
			rSumArr[i] = int64(height * (len(maxHeights) - i))
		} else {
			rear := stack[len(stack)-1]
			rSumArr[i] = rSumArr[rear] + int64((rear-i)*height)
		}
		stack = append(stack, i)
	}
	var result int64
	for i := 0; i < len(maxHeights); i++ {
		if nv := lSumArr[i] + rSumArr[i] - int64(maxHeights[i]); nv > result {
			result = nv
		}
	}
	return result
}

func maximumSumOfHeights_timeout(maxHeights []int) int64 {
	min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	var result int64
	for max := 0; max < len(maxHeights); max++ {
		tp := int64(maxHeights[max])
		pre := maxHeights[max]
		for i := max - 1; i >= 0; i-- {
			pre = min(pre, maxHeights[i])
			tp += int64(pre)
		}
		pre = maxHeights[max]
		for i := max + 1; i < len(maxHeights); i++ {
			pre = min(pre, maxHeights[i])
			tp += int64(pre)
		}
		if tp > result {
			result = tp
		}
	}
	return result
}
