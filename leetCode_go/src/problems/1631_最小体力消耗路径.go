package problems

import (
	"sort"
)

func MinimumEffortPath(heights [][]int) int {
	return minimumEffortPath(heights)
}

func minimumEffortPath(heights [][]int) int {
	m, n := len(heights), len(heights[0])
	matrix := make([]int, m*n)
	for i := 0; i < m*n; i++ {
		matrix[i] = i
	}
	abs := func(x int) int {
		if x > 0 {
			return x
		}
		return -x
	}

	var find func(x int) int
	find = func(x int) int {
		if x == matrix[x] {
			return x
		} else {
			matrix[x] = find(matrix[x])
			return matrix[x]
		}
	}
	var merge func(x, y int)
	merge = func(x, y int) {
		matrix[find(x)] = find(y)
	}
	type edge struct {
		x1, y1 int
		x2, y2 int
		diff   int
	}
	newEdge := func(x1, y1, x2, y2 int) (e edge, ok bool) {
		if x2 == m || y2 == n {
			return edge{}, false
		} else {
			return edge{x1, y1, x2, y2, abs(heights[x1][y1] - heights[x2][y2])}, true
		}
	}
	edges := make([]edge, 0)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if e, ok := newEdge(i, j, i+1, j); ok {
				edges = append(edges, e)
			}
			if e, ok := newEdge(i, j, i, j+1); ok {
				edges = append(edges, e)
			}
		}
	}
	sort.Slice(edges, func(i, j int) bool {
		return edges[i].diff < edges[j].diff
	})
	for _, e := range edges {
		merge(e.x1*n+e.y1, e.x2*n+e.y2)
		if find(0) == find(m*n-1) {
			return e.diff
		}
	}
	return 0
}

//abs := func(x int) int {
//	if x > 0 {
//		return x
//	}
//	return -x
//}
//find := func(x, y int) int {
//	if x*m+y == matrix[x][y] {
//		return
//	}
//}

func minimumEffortPath_timeout(heights [][]int) int {

	result := 1 << 30
	m, n := len(heights), len(heights[0])
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	abs := func(x int) int {
		if x > 0 {
			return x
		}
		return -x
	}
	var dfs func(maxDepth, pre int, x, y int, walked [][]bool)
	dfs = func(maxDepth, pre int, x, y int, walked [][]bool) {
		// 越界判定
		if x < 0 || y < 0 || x == m || y == n {
			return
		}
		// 更新差值
		maxDepth = max(maxDepth, abs(pre-heights[x][y]))
		if maxDepth >= result || walked[x][y] {
			return
		} else if x == m-1 && y == n-1 {
			result = maxDepth
		} else {
			walked[x][y] = true
			dfs(maxDepth, heights[x][y], x-1, y, walked)
			dfs(maxDepth, heights[x][y], x+1, y, walked)
			dfs(maxDepth, heights[x][y], x, y-1, walked)
			dfs(maxDepth, heights[x][y], x, y+1, walked)
			walked[x][y] = false
		}
	}
	matrix := make([][]bool, m)
	for i := 0; i < m; i++ {
		matrix[i] = make([]bool, n)
	}
	dfs(0, heights[0][0], 0, 0, matrix)
	return result
}
