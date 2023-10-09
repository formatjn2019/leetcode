package problems

import "sort"

func splitNum(num int) int {
	arr := make([]int, 0)
	for ; num > 0; num /= 10 {
		arr = append(arr, num%10)
	}
	sort.Ints(arr)
	l, r := 0, 0
	for p := 0; p < len(arr); p++ {
		if l < r {
			l = l*10 + arr[p]
		} else {
			r = r*10 + arr[p]
		}
	}
	return l + r
}
