package problems

func diagonalSum(mat [][]int) int {
	n := len(mat)
	result := 0
	for i := 0; i < n; i++ {
		result += mat[i][i] + mat[i][n-i-1]
	}
	if n%2 == 1 {
		result -= mat[n/2][n/2]
	}
	return result
}
