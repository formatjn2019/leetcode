package problems


func maxScoreSightseeingPair(values []int) int {
	result:=0
	preMax:=values[0]
	for i:=1;i<len(values);i++ {
		now:=values[i]
		preMax--
		if now+preMax>result {
			result=now+preMax
		}
		if now>preMax {
			preMax=now
		}
	}
	return result
}