package problems

import "math"

func GetKthMagicNumber(k int) int {
	return getKthMagicNumber(k)
}

func getKthMagicNumber(k int) int {
	results := make([]int, k)
	results[0] = 1
	p3, p5, p7 := 0, 0, 0
	for i := 1; i < k; i++ {
		results[i] = int(math.Min(math.Min(float64(results[p3]*3), float64(results[p5]*5)), float64(results[p7]*7)))
		if results[p3]*3 == results[i] {
			p3++
		}
		if results[p5]*5 == results[i] {
			p5++
		}
		if results[p7]*7 == results[i] {
			p7++
		}
	}

	return results[k-1]
}

func getKthMagicNumber_timeout(k int) int {
	if k == 1 {
		return 1
	}
	used := map[int]bool{1: true}
	num := 1
	for ; k > 1; num++ {
		if (num%3 == 0 && used[num/3]) || (num%5 == 0 && used[num/5]) || (num%7 == 0 && used[num/7]) {
			used[num] = true
			k--
		}
	}
	return num - 1
}
