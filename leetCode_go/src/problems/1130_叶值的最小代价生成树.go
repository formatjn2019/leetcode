package problems

func MctFromLeafValues(arr []int) int {
	return mctFromLeafValues(arr)
}
func mctFromLeafValues(arr []int) int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	result := 0
	for len(arr) > 1 {
		minIdx, product := 0, arr[0]*arr[1]
		for i := 1; i < len(arr)-1; i++ {
			if product > arr[i]*arr[i+1] {
				minIdx = i
				product = arr[i] * arr[i+1]
			}
		}
		arr[minIdx+1] = max(arr[minIdx], arr[minIdx+1])
		arr = append(arr[:minIdx], arr[minIdx+1:]...)
		result += product
	}
	return result
}
