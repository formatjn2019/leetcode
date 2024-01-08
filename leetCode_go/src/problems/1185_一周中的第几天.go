package problems

var mountDaySum []int = []int{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}

var translateArr []string = []string{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}

func dayOfTheWeek(day int, month int, year int) string {
	//调包
	//return time.Date(year, time.Month(month), day, 0, 0, 0, 0, time.UTC).Weekday().String()
	//相较于1971年的日数
	//年
	dify := year - 1971
	//闰年数量，因为不会包含被100整除，不被400整除的情况
	days := dify*365 + (dify+2)/4
	//月份
	days += mountDaySum[month-1]
	if month > 2 && ((year%100 != 0 && year%4 == 0) || (year%400 == 0)) {
		days += 1
	}
	//日
	days += day
	return translateArr[(days+4)%7]
}
