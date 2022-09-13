package problems

import "strconv"

func MaximumSwap(num int) int {
	return maximumSwap(num)
}

func maximumSwap(num int) int {
	arr := []rune(strconv.Itoa(num))
	max := num
	for i := 0; i < len(arr)-1 && max == num; i++ {
		for j := len(arr) - 1; j > i; j-- {
			if arr[i] < arr[j] {
				arr[i], arr[j] = arr[j], arr[i]
				tm, _ := strconv.Atoi(string(arr))
				if tm > max {
					max = tm
				}
				arr[i], arr[j] = arr[j], arr[i]
			}
		}
	}
	return max
}
