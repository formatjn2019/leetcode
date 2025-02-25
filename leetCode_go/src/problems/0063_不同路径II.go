package problems

var UniquePathsWithObstacles = uniquePathsWithObstacles

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	m, n := len(obstacleGrid), len(obstacleGrid[0])
	matrix := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		matrix[i] = make([]int, n+1)
	}
	matrix[0][1] = 1
	for i, row := range obstacleGrid {
		for j, cell := range row {
			if cell == 1 {
				continue
			}
			matrix[i+1][j+1] = matrix[i+1][j] + matrix[i][j+1]
		}
	}
	return matrix[m][n]
}
