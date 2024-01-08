package problems

import (
	"strconv"
	"strings"
)

var mountSum []int = []int{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}

func dayOfYear(date string) int {
	dateArr := strings.Split(date, "-")
	year, _ := strconv.Atoi(dateArr[0])
	mouth, _ := strconv.Atoi(dateArr[1])
	day, _ := strconv.Atoi(dateArr[2])
	result := mountSum[mouth-1] + day
	if mouth > 2 && (year%400 == 0 || year%4 == 0 && year%100 != 0) {
		result++
	}
	return result
}
