package problems

func BaseNeg2(n int) string {
	return baseNeg2(n)
}

func baseNeg2(n int) string {
	resultArr := []byte{}
	for ; n != 0; n /= -2 {
		if n%-2 != 0 {
			resultArr = append(resultArr, '1')
			n--
		} else {
			resultArr = append(resultArr, '0')
		}
	}
	for i := 0; i < len(resultArr)/2; i++ {
		resultArr[i], resultArr[len(resultArr)-i-1] = resultArr[len(resultArr)-i-1], resultArr[i]
	}
	return string(resultArr)
}
