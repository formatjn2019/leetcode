package problems

func SumOfBeauties(nums []int) int {
	return sumOfBeauties(nums)
}

func sumOfBeauties(nums []int) int {
	lenth:=len(nums)
	judgeArr:=make([]int,lenth)
	result:=0
	minNum:=nums[lenth-1]
	for i:=lenth-2;i>0;i-- {
		if nums[i-1]<nums[i]&&nums[i+1]>nums[i] {
			result++
		}
		judgeArr[i]=minNum
		if nums[i]<minNum{
			minNum=nums[i]
		}
	}
	maxNum:=nums[0]
	for i:=1;i<lenth-1;i++ {
		if nums[i]>maxNum && nums[i]<judgeArr[i] {
			result++
		}
		if nums[i]>maxNum{
			maxNum=nums[i]
		}
	}
	//fmt.Println(judgeArr)
	//println(result)
	return result
}