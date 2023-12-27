package problems

import "math"

func MinimumPerimeter(neededApples int64) int64 {
	return minimumPerimeter(neededApples)
}

func minimumPerimeter(neededApples int64) int64 {
	ll, rl := int64(0), int64(math.Sqrt(float64(neededApples)))
	lenth := int64(1)
	for ll < rl {
		//公式
		mid := (ll + rl) / 2
		//println(mid, ll, rl)
		if t := 4*mid*mid*mid + 6*mid*mid + 2*mid; mid > int64(math.Cbrt(float64(neededApples))) || t >= neededApples {
			lenth = mid
			rl = mid
		} else {
			ll = mid + 1
		}
	}
	return 8 * lenth
}
