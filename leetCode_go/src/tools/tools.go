package tools

import (
	"fmt"
	"strconv"
	"strings"
)

func ParseArr(str string) [][]int {
	var result = make([][]int, 0)
	str = strings.TrimSpace(str)
	str = strings.TrimLeft(str, "[[")
	str = strings.TrimRight(str, "]]")
	split := strings.Split(str, "],[")
	for _, instr := range split {
		numArr := strings.Split(instr, ",")
		inArr := make([]int, 0)
		for _, v := range numArr {
			val, err := strconv.Atoi(v)
			if err != nil {
				println(numArr)
				println("转换失败")
			} else {
				inArr = append(inArr, val)
			}
		}
		result = append(result, inArr)
	}
	return result
}

func main() {
	fmt.Println(ParseArr("[[3,0],[2,2],[3,0],[0,1],[1,2],[0,0],[3,2],[1,2]]"))
}
