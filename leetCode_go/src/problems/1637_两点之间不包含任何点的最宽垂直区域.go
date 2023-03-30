package problems

import (
	"sort"
)

func MaxWidthOfVerticalArea(points [][]int) int {
	return maxWidthOfVerticalArea(points)
}
func maxWidthOfVerticalArea(points [][]int) int {
	sort.Slice(points, func(i, j int) bool {
		return points[i][0] < points[j][0]
	})
	lp, rp := 0, 0
	result := 0
	for ; lp < len(points); lp = rp {
		for ; rp < len(points) && points[rp][0] == points[lp][0]; rp++ {
		}
		if rp < len(points) && points[rp][0]-points[lp][0] > result {
			result = points[rp][0] - points[lp][0]
		}
	}
	return result
}
