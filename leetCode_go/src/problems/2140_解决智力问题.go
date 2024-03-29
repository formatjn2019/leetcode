package problems

func MostPoints(questions [][]int) int64 {
	return mostPoints(questions)
}
func mostPoints(questions [][]int) int64 {
	maxNum := func(n1, n2 int64) int64 {
		if n1 > n2 {
			return n1
		}
		return n2
	}

	lenth := len(questions)
	maxs := make([]int64, lenth)
	max := int64(0)
	for i := lenth - 1; i >= 0; i-- {
		//fmt.Println(i,questions[i][0],questions[i][1])
		nextIndex := questions[i][1] + i + 1
		if nextIndex < lenth {
			max = maxNum(max, int64(questions[i][0])+maxs[nextIndex])
		} else {
			max = maxNum(max, int64(questions[i][0]))
		}

		maxs[i] = max
	}
	return max
}
