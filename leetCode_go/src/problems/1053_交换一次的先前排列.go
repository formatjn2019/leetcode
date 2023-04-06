package problems

func PrevPermOpt1(arr []int) []int {
	return prevPermOpt1(arr)
}
func prevPermOpt1(arr []int) []int {
	stack := make([]int, 0)
	for i := len(arr) - 1; i >= 0; i-- {
		//栈内无元素，入栈
		if len(stack) == 0 || arr[i] < arr[stack[0]] {
			stack = append([]int{i}, stack...)
		} else if arr[i] == arr[stack[0]] {
			stack[0] = i
		} else {
			tpIdx := stack[0]
			for _, j := range stack {
				if arr[i] > arr[j] {
					tpIdx = j
				}
			}
			arr[i], arr[tpIdx] = arr[tpIdx], arr[i]
			break
		}
	}
	return arr
}
