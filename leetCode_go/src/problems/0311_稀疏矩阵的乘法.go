package problems

func multiply(mat1 [][]int, mat2 [][]int) [][]int {
	m, n := len(mat1), len(mat2[0])
	result := make([][]int, m)
	for i, arr := range mat1 {
		result[i] = make([]int, n)
		for t, n1 := range arr {
			for j := 0; j < n; j++ {
				result[i][j] += n1 * mat2[t][j]
			}
		}
	}
	return result
}
