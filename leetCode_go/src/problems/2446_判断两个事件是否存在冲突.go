package problems

import "strconv"

func haveConflict(event1 []string, event2 []string) bool {
	return !(event1[0] > event2[1] || event2[0] > event1[1])
}

func haveConflict_parse(event1 []string, event2 []string) bool {
	parseTime := func(s string) int {
		hour, _ := strconv.Atoi(s[:2])
		minute, _ := strconv.Atoi(s[3:])
		return hour*60 + minute
	}
	s1, e1 := parseTime(event1[0]), parseTime(event1[1])
	s2, e2 := parseTime(event2[0]), parseTime(event2[1])
	s := s1
	if s1 > s2 {
		s = s2
	}
	e := e1
	if e1 < e2 {
		e = e2
	}
	// 存在冲突，则区间小于等于两段区间和
	return e-s <= e1-s1+e2-s2
}
