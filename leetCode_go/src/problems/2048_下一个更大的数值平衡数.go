package problems

import (
	"math"
	"strconv"
)

func NextBeautifulNumber(n int) int {
	println(n)
	return nextBeautifulNumber(n)
}

func nextBeautifulNumber(n int) int {
	if n == 0 {
		return 1
	}
	maxArr := [][]int{
		{1},
		{22},
		{333, 221},
		{4444, 3331},
		{55555, 33322, 44441},
		{666666, 444422, 555551, 333221},
		{7777777, 4444333, 5555522, 6666661, 4444221},
	}
	// 查找数字
	var result int
	numSize := int(math.Ceil(math.Log10(float64(n + 1))))

	//穷举排列
	var generateNum func(depth int, cArr []byte, bArr []bool, current int)
	generateNum = func(depth int, cArr []byte, bArr []bool, current int) {
		if depth == len(cArr) {
			//fmt.Println(current)
			if current > n && current < result {
				result = current
			}
		} else {
			for i := 0; i < len(cArr); i++ {
				if !bArr[i] {
					bArr[i] = true
					generateNum(depth+1, cArr, bArr, current*10+int(cArr[i]-'0'))
					bArr[i] = false
				}
			}
		}
	}
	var resultNums []int
	if maxArr[numSize-1][0] > n {
		result, resultNums = maxArr[numSize-1][0], maxArr[numSize-1]
	} else {
		result, resultNums = maxArr[numSize][0], maxArr[numSize]
	}
	for _, num := range resultNums {
		generateNum(0, []byte(strconv.Itoa(num)), make([]bool, len(strconv.Itoa(num))), 0)
	}
	return result
}
