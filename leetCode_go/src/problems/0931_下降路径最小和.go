package problems

func MinFallingPathSum(matrix [][]int) int {
	return minFallingPathSum(matrix)
}
func minFallingPathSum(matrix [][]int) int {
	n := len(matrix)
	calculateMatrix := make([][]int, n)
	for i := 0; i < n; i++ {
		calculateMatrix[i] = make([]int, n+2)
		calculateMatrix[i][0], calculateMatrix[i][n+1] = 1<<30, 1<<30
		copy(calculateMatrix[i][1:], matrix[i])
	}
	min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	for i := 1; i < n; i++ {
		for j := 1; j <= n; j++ {
			calculateMatrix[i][j] += min(calculateMatrix[i-1][j-1], min(calculateMatrix[i-1][j], calculateMatrix[i-1][j+1]))
		}
	}
	result := calculateMatrix[n-1][1]
	for _, num := range calculateMatrix[n-1][1 : n+1] {
		result = min(num, result)
	}
	return result
}
