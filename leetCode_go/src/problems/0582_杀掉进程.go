package problems

func killProcess(pid []int, ppid []int, kill int) []int {
	parentMap := map[int][]int{}
	for i, p := range pid {
		pp := ppid[i]
		parentMap[pp] = append(parentMap[pp], p)
	}
	var deleteArr, result []int
	deleteArr = []int{kill}
	for len(deleteArr) > 0 {
		nextDelete := make([]int, 0)
		for _, deleteId := range deleteArr {
			for _, sub := range parentMap[deleteId] {
				nextDelete = append(nextDelete, sub)
			}
		}
		result = append(result, deleteArr...)
		deleteArr = nextDelete
	}
	return result
}
