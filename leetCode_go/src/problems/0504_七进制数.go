package problems

import (
	"strings"
)

func ConvertToBase7(num int) string {
	return convertToBase7(num)
}
func convertToBase7(num int) string {
	if num == 0 {
		return "0"
	}
	result := strings.Builder{}
	if num < 0 {
		result.WriteRune('-')
		num = -num
	}
	arr := []rune{}
	//取绝对值，循环
	for ; num > 0; num /= 7 {
		arr = append(arr, '0'+rune(num%7))
	}
	for i := len(arr) - 1; i >= 0; i-- {
		result.WriteRune(arr[i])
	}

	return result.String()
}

//func main() {
//	println(convertToBase7(100))
//	println(convertToBase7(-7))
//}
