package problems

func queensAttacktheKing(queens [][]int, king []int) [][]int {
	var result [][]int
	idxMap := map[int]bool{}
	for _, arr := range queens {
		idxMap[arr[0]<<3|arr[1]] = true
	}

	for xDir := -1; xDir < 2; xDir++ {
		for yDir := -1; yDir < 2; yDir++ {
			if xDir == 0 && yDir == 0 {
				continue
			}
			for distance := 1; ; distance++ {
				nx, ny := king[0]+distance*xDir, king[1]+distance*yDir
				if nx < 0 || nx > 7 || ny < 0 || ny > 7 {
					break
				}
				if idxMap[nx<<3|ny] {
					result = append(result, []int{nx, ny})
					break
				}
			}
		}
	}
	return result
}
