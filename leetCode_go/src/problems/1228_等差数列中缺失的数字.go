package problems

func missingNumber(arr []int) int {
	n := len(arr)
	for i := 0; i < n-2; i++ {
		if arr[i+2]-arr[i+1] == arr[i+1]-arr[i] {
			continue
		} else if arr[i+2]-arr[i+1] == 2*(arr[i+1]-arr[i]) {
			return (arr[i+2] + arr[i+1]) / 2
		} else {
			return (arr[i] + arr[i+1]) / 2
		}
	}
	return arr[0]
}
