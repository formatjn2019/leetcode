package problems

func FinalPrices(prices []int) []int {
	return finalPrices(prices)
}

func finalPrices(prices []int) []int {
	stack := make([]int, 0)
	result := make([]int, len(prices))
	for i, v := range prices {
		result[i] = v
	}
	//单增栈
	for i, num := range prices {
		//出栈折扣
		for len(stack) > 0 && prices[stack[len(stack)-1]] >= num {
			result[stack[len(stack)-1]] -= num
			stack = stack[0 : len(stack)-1]
		}
		stack = append(stack, i)
	}
	return result
}
