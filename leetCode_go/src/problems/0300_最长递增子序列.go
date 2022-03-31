package problems

func LengthOfLIS(nums []int) int {
	return lengthOfLIS(nums)
}

func lengthOfLIS(nums []int) int {
	lenth:=len(nums)
	judge:=make([]int,lenth)
	result:=0
	for i :=range judge{
		for j:=0;j<=i;j++ {
			new:=1
			if nums[j]<nums[i] {
				new=judge[j]+1
			}
			//有更新，则计数
			if new>judge[i] {
				judge[i]=new
			}
		}
		if judge[i]>result {
			result=judge[i]
		}
	}
	return result
}