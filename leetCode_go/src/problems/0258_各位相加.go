package problems

func AddDigits(num int) int {
	return addDigits(num)
}

//模拟法
func addDigits(num int) int {
	result := num
	for result > 9 {
		tn := 0
		for ; result > 0; result /= 10 {
			tn += result % 10
		}
		result = tn
	}
	return result
}

//数学法
func addDigitsMath(num int) int {
	return (num-1)%9 + 1
}
