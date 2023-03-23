package problems

import (
	"sort"
)

func BestTeamScore(scores []int, ages []int) int {
	return bestTeamScore(scores, ages)
}

// 动态规划
func bestTeamScore(scores []int, ages []int) int {
	tpMatrix := make([][2]int, len(scores))
	for idx, _ := range tpMatrix {
		tpMatrix[idx][0], tpMatrix[idx][1] = scores[idx], ages[idx]
	}
	sort.Slice(tpMatrix, func(i, j int) bool {
		return tpMatrix[i][0]<<15+tpMatrix[i][1] < tpMatrix[j][0]<<15+tpMatrix[j][1]
	})
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	resultMatrix, result := make([]int, len(scores)), 0
	for i, _ := range resultMatrix {
		maxSum := 0
		for j := 0; j < i; j++ {
			if tpMatrix[j][1] <= tpMatrix[i][1] {
				maxSum = max(maxSum, resultMatrix[j])
			}
		}
		resultMatrix[i] = maxSum + tpMatrix[i][0]
		result = max(resultMatrix[i], result)
	}
	return result
}

// 动态规划，哈希表
func bestTeamScoreHash(scores []int, ages []int) int {
	tpMatrix := make([][2]int, len(scores))
	for idx, _ := range tpMatrix {
		tpMatrix[idx][0], tpMatrix[idx][1] = scores[idx], ages[idx]
	}
	sort.Slice(tpMatrix, func(i, j int) bool {
		return tpMatrix[i][0]<<15+tpMatrix[i][1] < tpMatrix[j][0]<<15+tpMatrix[j][1]
	})
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	prefixSum, result := map[int]int{}, 0
	for _, arr := range tpMatrix {
		score, age := arr[0], arr[1]
		maxScore := 0
		for oldage, sum := range prefixSum {
			if oldage <= age {
				maxScore = max(maxScore, sum)
			}
		}
		prefixSum[age] = maxScore + score
		result = max(prefixSum[age], result)
	}
	return result
}
