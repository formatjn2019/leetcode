package problems

func CanFormArray(arr []int, pieces [][]int) bool {
	return canFormArray(arr, pieces)
}

func canFormArray(arr []int, pieces [][]int) bool {
	headMap := map[int][]int{}
	for _, arr := range pieces {
		headMap[arr[0]] = arr
	}
	for index := 0; index < len(arr); {
		tArr := headMap[arr[index]]
		if tArr == nil {
			return false
		}
		for i := 0; i < len(tArr); i++ {
			if tArr[i] != arr[index] {
				return false
			}
			index++
		}
	}
	return true
}
