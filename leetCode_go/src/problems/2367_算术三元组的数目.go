package problems

func ArithmeticTriplets(nums []int, diff int) int {
	return arithmeticTriplets(nums, diff)
}

func arithmeticTriplets(nums []int, diff int) int {
	l1Dic,l2Dic :=map[int]bool{},map[int]bool{}
	result:=0
	for _,num := range nums {
		if _,ok:=l2Dic[num -diff];ok{
			result++
			l2Dic[num]=true
		}else if _,ok2:=l1Dic[num -diff];ok2 {
			l2Dic[num]=true
		}else{
			l1Dic[num]=true
		}
	}
	return result
}
