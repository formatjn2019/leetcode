package problems

func firstCompleteIndex(arr []int, mat [][]int) int {
	m, n := len(mat), len(mat[0])
	tArr := make([][2]int, len(arr))
	// 遍历记录索引
	for i, line := range mat {
		for j, n := range line {
			tArr[n-1][0] = i
			tArr[n-1][1] = j
		}
	}
	lineCount, rowCount := make([]int, len(mat)), make([]int, len(mat[0]))

	for i, num := range arr {
		l, r := tArr[num-1][0], tArr[num-1][1]
		lineCount[l]++
		rowCount[r]++
		if lineCount[l] == n || rowCount[r] == m {
			return i
		}
	}
	return -1
}
