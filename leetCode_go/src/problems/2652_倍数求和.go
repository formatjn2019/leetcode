package problems

func SumOfMultiples(n int) int {
	return sumOfMultiples(n)
}
func sumOfMultiples(n int) int {
	nums := []int{3, 5, 7, 3 * 5 * 7}
	subs := []int{3 * 5, 3 * 7, 5 * 7}
	var sum int
	for _, num := range nums {
		con := n / num
		sum += num * (con * (con + 1)) / 2
	}
	for _, num := range subs {
		con := n / num
		sum -= num * (con * (con + 1)) / 2
	}
	return sum
}
