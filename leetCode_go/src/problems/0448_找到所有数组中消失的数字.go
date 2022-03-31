package problems
func FindDisappearedNumbers(nums []int) []int {
	return findDisappearedNumbers(nums)
}
func findDisappearedNumbers_hash(nums []int) []int {
	hashMap:= map[int]bool{}
	for _,num:=range nums{
		hashMap[num]=true
	}
	lenth:=len(nums)
	result:=make([]int,0)
	for i:=1;i<=lenth;i++ {
		if _,ok:=hashMap[i];!ok {
			result = append(result, i)
		}
	}
	return result
}

func findDisappearedNumbers(nums []int) []int {
	result:=make([]int,0)
	for i:=0;i<len(nums);i++{
		tp:=nums[i]
		for tp!=-1 {
			tp,nums[tp-1]=nums[tp-1],-1
		}
	}
	for i:=0;i<len(nums);i++ {
		if nums[i]!=-1 {
			result = append(result, i+1)
		}
	}
	return result
}