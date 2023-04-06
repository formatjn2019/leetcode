package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestBaseNeg2(t *testing.T) {
	tpMap := map[int]string{}
	for i := 0; i < 1000; i++ {
		str := fmt.Sprintf("%b", i)
		tpMap[reverseParse(str)] = str
	}
	for i := 0; i < 100; i++ {
		fmt.Println(i, tpMap[i])
		//if i > 2 {
		//	fmt.Print(" ", i/2, " ", tpMap[i][:len(tpMap[i])-1])
		//}
		//if i > 4 {
		//	fmt.Print(" ", i/4, " ", tpMap[i][:len(tpMap[i])-2])
		//}
		fmt.Println(i, problems.BaseNeg2(i))
		fmt.Println()

	}
	//for i := 0; i < 1000; i++ {
	//	if _, ok := tpMap[i]; ok {
	//		fmt.Println(i, tpMap[i], i/2, tpMap[i][:len(tpMap[i])-1])
	//	}
	//}
}

func reverseParse(str string) int {
	tp, result, arr := 1, 0, []byte(str)
	for idx := len(str) - 1; idx >= 0; idx-- {
		if arr[idx] == '1' {
			result += tp
		}
		tp *= -2
	}
	return result
}
