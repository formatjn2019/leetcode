package problems

func FindNumberOfLIS(nums []int) int {
	return findNumberOfLIS(nums)
}

func findNumberOfLIS_timeout(nums []int) int {
	lenth:=len(nums)
	var dfsSearch func(int,int,int)
	result,max:=0,0
	dfsSearch= func(pre,count,index int){
		if index == lenth {
			if count==max {
				result++
			}else if count>max {
				max=count
				result=1
			}
			return
		}else if count+lenth-count<max {
			//剪枝
			return
		}
		if pre<nums[index] {
			dfsSearch(nums[index],count+1,index+1)
		}
		dfsSearch(pre,count,index+1)
	}
	dfsSearch(-10000000,0,0)
	return result
}

func findNumberOfLIS(nums []int) int {
	lenth:=len(nums)
	judge:=make([][2]int,lenth)
	max:=0
	for i :=range judge{
		judge[i][1]=1
		for j:=0;j<=i;j++ {
			new:=1
			if nums[j]<nums[i] {
				new=judge[j][0]+1
			}
			//有更新，则计数
			if new>judge[i][0] {
				judge[i][0]=new
				judge[i][1]=judge[j][1]
			}else if new==judge[i][0] && new!=1 {
				judge[i][1]+=judge[j][1]
			}
		}
		if judge[i][0]>max {
			max=judge[i][0]
		}
	}
	result:=0
	for _,arr:=range judge{
		if arr[0]==max {
			result+=arr[1]
		}
	}
	return result
}
