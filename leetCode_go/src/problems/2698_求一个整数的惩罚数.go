package problems

import (
	"strconv"
	"strings"
)

func PunishmentNumber(n int) int {
	return punishmentNumber(n)
}
func punishmentNumber(n int) int {
	var result int
	for i := 1; i <= n; i++ {
		if isPunishment(strconv.Itoa(i*i), 0, 0, i) {
			result += i * i
		}
	}
	return result
}

func isPunishment(s string, pos int, tot int, target int) bool {
	if pos == len(s) {
		return tot == target
	}
	sum := 0
	for i := pos; i < len(s); i++ {
		sum = sum*10 + int(s[i]-'0')
		if sum+tot > target {
			break
		}
		if isPunishment(s, i+1, sum+tot, target) {
			return true
		}
	}
	return false
}

func isPunishment_timeout(num int) bool {
	t := num * num
	itoa := strconv.Itoa(t)
	var sn func(num string) map[string]bool
	sn = func(num string) map[string]bool {
		if len(num) == 0 {
			return map[string]bool{}
		}
		tpSet := map[string]bool{}
		tpSet[num] = true
		for i := 1; i < len(num); i++ {
			l := sn(num[0:i])
			r := sn(num[i:])
			for lt := range l {
				for rt := range r {
					tpSet[lt+","+rt] = true
				}
			}
		}
		return tpSet
	}

	calResult := func(arr string) int {
		split := strings.Split(arr, ",")
		var sum int
		for _, sNum := range split {
			n, _ := strconv.Atoi(sNum)
			sum += n
		}
		return sum
	}
	for arr := range sn(itoa) {
		if calResult(arr) == num {
			return true
		}
	}
	return false
}
