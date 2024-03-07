package problems

func divisibilityArray(word string, m int) []int {
	result := make([]int, len(word))
	num := 0
	for i, n := range word {
		num += int(n - '0')
		if num%m == 0 {
			result[i] = 1
		}
		num = (num % m) * 10
	}
	return result
}
