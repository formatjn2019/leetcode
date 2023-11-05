package problems

import "sort"

func maxArea(h int, w int, horizontalCuts []int, verticalCuts []int) int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	sort.Ints(horizontalCuts)
	sort.Ints(verticalCuts)
	mh, mw := max(horizontalCuts[0], h-horizontalCuts[len(horizontalCuts)-1]), max(verticalCuts[0], w-verticalCuts[len(verticalCuts)-1])
	for i := 1; i < len(horizontalCuts); i++ {
		mh = max(mh, horizontalCuts[i]-horizontalCuts[i-1])
	}
	for i := 1; i < len(verticalCuts); i++ {
		mw = max(mw, verticalCuts[i]-verticalCuts[i-1])
	}
	return int((int64(mh) * int64(mw)) % (1e9 + 7))
}
