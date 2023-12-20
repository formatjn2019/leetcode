package problems

func FindPeakGrid(mat [][]int) []int {
	return findPeakGrid(mat)
}

func findPeakGrid(mat [][]int) []int {
	findMax := func(arr []int) int {
		idx := 0
		for i, num := range arr {
			if num > arr[idx] {
				idx = i
			}
		}
		return idx
	}
	m := len(mat)
	lp, rp := 0, m
	for lp < rp {
		mid := (lp + rp) / 2
		maxI := findMax(mat[mid])
		if mid == 0 || mat[mid][maxI] > mat[mid-1][maxI] {
			if mid == m-1 || mat[mid][maxI] > mat[mid+1][maxI] {
				return []int{mid, maxI}
			}
			lp = mid + 1
		} else {
			rp = mid
		}
	}
	return []int{}
}
