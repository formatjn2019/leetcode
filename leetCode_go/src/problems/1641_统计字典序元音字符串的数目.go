package problems

func CountVowelStrings(n int) int {
	return countVowelStrings(n)
}
func countVowelStrings(n int) int {
	tempArr := [2][5]int{
		{0, 0, 0, 0, 0},
		{1, 1, 1, 1, 1},
	}
	for i := 2; i <= n; i++ {
		sum := 0
		for j := 0; j < 5; j++ {
			sum += tempArr[(i+1)%2][j]
			tempArr[i%2][j] = sum
		}
	}
	result := 0
	for j := 0; j < 5; j++ {
		result += tempArr[n%2][j]
	}
	return result
}
