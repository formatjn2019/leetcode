package problems

func MinimumDeletions(s string) int {
	return minimumDeletions(s)
}
func minimumDeletions(s string) int {
	numCount, arr := make([]int, len(s)), []rune(s)
	ac, bc := 0, 0
	//b变a数量
	for i := 0; i < len(s); i++ {
		numCount[i] = bc
		if arr[i] == 'b' {
			bc++
		}
	}
	result := (len(arr) + 1) / 2
	//a变b数量
	for i := len(s) - 1; i >= 0; i-- {
		if numCount[i]+ac < result {
			result = numCount[i] + ac
		}
		if arr[i] == 'a' {
			ac++
		}
	}
	return result
}
