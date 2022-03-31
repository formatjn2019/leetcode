package problems
func MissingRolls(rolls []int, mean int, n int) []int {
	return missingRolls(rolls,mean,n)
}
func missingRolls(rolls []int, mean int, n int) []int {
	sum:=(len(rolls)+n)*mean
	for _,num :=range rolls{
		sum-=num
	}
	adv:=sum/n
	remain:=sum%n
	result:=make([]int,0)
	if (adv>0 && adv<6) ||(adv ==6 && remain==0) {
		result=make([]int,n)
		for i:=0;i<n;i++ {
			result[i]=adv
			if remain>0 {
				result[i]++
				remain--
			}
		}
	}
	return result
}