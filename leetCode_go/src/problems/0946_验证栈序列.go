package problems

func ValidateStackSequences(pushed []int, popped []int) bool {
	result := validateStackSequences(pushed, popped)

	print(result)
	return result
}

func validateStackSequences(pushed []int, popped []int) bool {
	return stackDFS(pushed, popped, 0, make([]int, 0), make([]int, 0))
}

func stackDFS(pushed []int, popped []int, index int, stack []int, temp []int) bool {
	//卫语句
	//结束
	if len(temp) == len(popped) {
		return true
	} else {
		//可以出栈,则尝试出栈
		if len(stack) > 0 && stack[len(stack)-1] == popped[len(temp)] {
			temp = append(temp, stack[len(stack)-1])
			stack = stack[0 : len(stack)-1]
			return stackDFS(pushed, popped, index, stack, temp)
		}

		//入栈
		if index == len(pushed) {
			return false
		} else {
			stack = append(stack, pushed[index])
			return stackDFS(pushed, popped, index+1, stack, temp)
		}
	}

}
