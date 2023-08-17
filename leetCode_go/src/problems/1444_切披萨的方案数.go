package problems

func Ways(pizza []string, k int) int {
	//println(ways_timeout(pizza, k))
	return ways(pizza, k)
}

func ways_timeout(pizza []string, k int) int {
	REMAINDER := 1000000007
	m, n := len(pizza), len(pizza[0])
	matrix := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		matrix[i] = make([]int, n+1)
	}
	area := func(i, j int) int {
		//面积差值
		return matrix[i-1][j-1] + matrix[m][n] - matrix[i-1][n] - matrix[m][j-1]
	}
	for i := 1; i <= m; i++ {
		sum := 0
		for j := 1; j <= n; j++ {
			//自身
			if pizza[i-1][j-1] == 'A' {
				sum++
			}
			matrix[i][j] = matrix[i-1][j] + sum

		}
	}

	var dfs func(x, y, depth int) int
	dfs = func(x, y, depth int) int {
		if depth == k {
			if area(x, y) > 0 {
				return 1
			} else {
				return 0
			}
		}
		result := 0
		//横切
		for i := x + 1; i <= m; i++ {
			if area(i, y) != area(x, y) {
				result += dfs(i, y, depth+1)
			}
		}
		//纵切
		for j := y + 1; j <= n; j++ {
			if area(x, j) != area(x, y) {
				result += dfs(x, j, depth+1)
			}
		}
		return result % REMAINDER
	}
	return dfs(1, 1, 1)
}

func ways(pizza []string, k int) int {
	REMAINDER := 1000000007
	m, n := len(pizza), len(pizza[0])
	matrix := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		matrix[i] = make([]int, n+1)
	}
	area := func(i, j int) int {
		//面积差值
		return matrix[i-1][j-1] + matrix[m][n] - matrix[i-1][n] - matrix[m][j-1]
	}
	for i := 1; i <= m; i++ {
		sum := 0
		for j := 1; j <= n; j++ {
			//自身
			if pizza[i-1][j-1] == 'A' {
				sum++
			}
			matrix[i][j] = matrix[i-1][j] + sum

		}
	}
	memMap := map[int]int{}
	hash := func(depth, x, y int) int {
		return (depth << 14) | (x << 7) | y
	}
	var dfs func(x, y, depth int) int
	dfs = func(x, y, depth int) int {
		if depth == k {
			if area(x, y) > 0 {
				memMap[hash(depth, x, y)] = 1
				return 1
			} else {
				memMap[hash(depth, x, y)] = 0
				return 0
			}
		}
		result := 0
		//横切
		for i := x + 1; i <= m; i++ {
			if area(i, y) != area(x, y) {
				if num, ok := memMap[hash(depth+1, i, y)]; !ok {
					result += dfs(i, y, depth+1)
				} else {
					result += num
				}
				result %= REMAINDER
			}
		}
		//纵切
		for j := y + 1; j <= n; j++ {
			if area(x, j) != area(x, y) {
				if num, ok := memMap[hash(depth+1, x, j)]; !ok {
					result += dfs(x, j, depth+1)
				} else {
					result += num
				}
				result %= REMAINDER
			}
		}
		memMap[hash(depth, x, y)] = result % REMAINDER
		return result % REMAINDER
	}
	return dfs(1, 1, 1)
}
