package main

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

////数学法
//func addDigits(num int) int {
//	return (num-1)%9 + 1
//}
//func main() {
//	println(addDigits(38))
//}
