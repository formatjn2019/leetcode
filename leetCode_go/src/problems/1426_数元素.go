package problems

func countElements(arr []int) int {
	countArr := make([]int, 1002)
	for _, num := range arr {
		countArr[num]++
	}
	var result int
	for i := 0; i < len(countArr)-1; i++ {
		if countArr[i+1] > 0 {
			result += countArr[i]
		}
	}
	return result
}
