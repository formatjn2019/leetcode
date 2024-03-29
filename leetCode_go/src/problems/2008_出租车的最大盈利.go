package problems

import (
	"sort"
)

func maxTaxiEarnings_timeout(n int, rides [][]int) int64 {
	max := func(x, y int64) int64 {
		if x > y {
			return x
		}
		return y
	}
	var result int64
	var dfs func(start int, current int64)
	dfs = func(start int, current int64) {
		result = max(result, current)
		for _, ride := range rides {
			if start <= ride[0] {
				dfs(ride[1], current+int64(ride[1]+ride[2]-ride[0]))
			}
		}
	}
	dfs(0, 0)
	return result
}

func MaxTaxiEarnings(n int, rides [][]int) int64 {
	return maxTaxiEarnings(n, rides)
}

func maxTaxiEarnings(n int, rides [][]int) int64 {
	max := func(x, y int64) int64 {
		if x > y {
			return x
		}
		return y
	}
	l := len(rides)
	matrix := make([]int64, l+1)
	sort.Slice(rides, func(i, j int) bool {
		return rides[i][1] < rides[j][1]
	})
	findMap := map[int]int{}
	for i, ride := range rides {
		if _, ok := findMap[ride[0]]; !ok {
			for l, r := 0, i; l < r; {
				md := (l + r) / 2
				if rides[md][1] <= ride[0] {
					findMap[ride[0]] = md
					l = md + 1
				} else {
					r = md
				}
			}
		}
	}
	for i := 1; i <= l; i++ {
		ride := rides[i-1]
		t := int64(ride[1] + ride[2] - ride[0])
		if pre, ok := findMap[ride[0]]; ok {
			t += matrix[pre+1]
		}
		matrix[i] = max(matrix[i-1], t)
	}
	return matrix[l]
}
