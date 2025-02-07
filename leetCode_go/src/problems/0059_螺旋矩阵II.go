package problems

var GenerateMatrix = generateMatrix

func generateMatrix(n int) [][]int {
	result := make([][]int, n)
	for i := 0; i < n; i++ {
		result[i] = make([]int, n)
	}
	dirs := [][]int{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}
	start, dir, x, y := 1, 0, 0, 0
	for {
		if start > n*n {
			break
		}
		result[y][x] = start
		start++
		// 能移动则移动，否则切换方向
		nx, ny := x+dirs[dir][0], y+dirs[dir][1]
		if nx < 0 || ny < 0 || nx == n || ny == n || result[ny][nx] != 0 {
			dir = (dir + 1) % 4
			x, y = x+dirs[dir][0], y+dirs[dir][1]
		} else {
			x, y = nx, ny
		}
	}

	return result
}
