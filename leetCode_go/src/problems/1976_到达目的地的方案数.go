package problems

import (
	"math"
)

var CountPaths = countPaths

func countPaths(n int, roads [][]int) int {
	matrix := make([][]int, n)
	for i := 0; i < n; i++ {
		matrix[i] = make([]int, n)
	}

	for _, road := range roads {
		matrix[road[0]][road[1]] = road[2]
		matrix[road[1]][road[0]] = road[2]
	}

	dp := make([]int, n)
	dist := make([]int, n)
	for i := 1; i < n; i++ {
		dist[i] = math.MaxInt64 / 2
	}
	dp[0] = 1
	dist[0] = 0
	visited := make([]bool, n)
	for i := 0; i < n; i++ {
		// 未走过的 距离最近的节点
		mn := -1
		for j := 0; j < n; j++ {
			if !visited[j] && (mn == -1 || dist[j] < dist[mn]) {
				mn = j
			}
		}
		visited[mn] = true
		for j := 0; j < n; j++ {
			if matrix[mn][j] == 0 {
				continue
			}
			if dist[mn]+matrix[mn][j] < dist[j] {
				dp[j] = dp[mn]
				dist[j] = dist[mn] + matrix[mn][j]
			} else if dist[mn]+matrix[mn][j] == dist[j] {
				dp[j] = (dp[j] + dp[mn]) % (1e9 + 7)
			}
		}
	}
	return dp[n-1]
}
