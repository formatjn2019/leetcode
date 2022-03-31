package problems

func trailingZeroes(n int) int {
	result:=0
	for n>0 {
		n/=5
		result+=n
	}
	return result
}