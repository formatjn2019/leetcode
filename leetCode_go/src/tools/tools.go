package tools

import (
	"fmt"
	"strconv"
	"strings"
)

func ParseArr(str string) [][]int {
	var result = make([][]int, 0)
	if len(str)==2 {
		return result
	}
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

func ShowArray(arr [][]int) {
	for i := 0; i < len(arr); i++ {
		for j := 0; j < len(arr[i]); j++ {
			print(arr[i][j], " ")
		}
		println()
	}
}
func ShowRuneArray(arr [][]rune) {
	for i := 0; i < len(arr); i++ {
		for j := 0; j < len(arr[i]); j++ {
			fmt.Printf("%c\t", arr[i][j])
		}
		println()
	}
}
func main() {
	fmt.Println(ParseArr("[[3,0],[2,2],[3,0],[0,1],[1,2],[0,0],[3,2],[1,2]]"))
}
