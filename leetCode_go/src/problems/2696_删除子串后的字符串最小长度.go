package problems

func minLength(s string) int {
	stack := make([]int32, 0)
	for _, c := range s {
		if len(stack) > 0 && ((c == 'B' && stack[len(stack)-1] == 'A') || (c == 'D' && stack[len(stack)-1] == 'C')) {
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, c)
		}
	}
	return len(stack)
}
