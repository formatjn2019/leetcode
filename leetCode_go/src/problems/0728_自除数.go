package problems

func selfDividingNumbers(left int, right int) []int {
	result:=make([]int,0)
	for i:=left;i<=right;i++{
		if isDivding(i) {
			result = append(result, i)
		}
	}
	return result
}

func isDivding(num int)bool{
	for tp:=num;tp>0;tp/=10 {
		n:=tp%10
		if n==0 || num%n!=0{
			return false
		}
	}
	return true
}