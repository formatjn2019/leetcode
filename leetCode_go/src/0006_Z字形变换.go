package main

import (
	"strings"
)

func convert(s string, numRows int) string {
	if numRows == 1 {
		return s
	}
	judge := make([][]rune, numRows)
	for i := 0; i < numRows; i++ {
		judge[i] = make([]rune, 0)
	}
	cArr := []rune(s)
	for index := 0; index < len(cArr); {
		//正向
		for i := 0; i < len(judge) && index < len(s); i++ {
			judge[i] = append(judge[i], cArr[index])
			index++
		}
		//逆向
		for i := len(judge) - 2; i > 0 && index < len(cArr); i-- {
			judge[i] = append(judge[i], cArr[index])
			index++
		}
	}
	result := strings.Builder{}
	for _, line := range judge {
		for _, c := range line {
			result.WriteRune(c)
		}
	}
	return result.String()
}

//func main() {
//	println(convert("1234567890", 3))
//}
