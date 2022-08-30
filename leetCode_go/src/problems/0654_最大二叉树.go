package problems

func ConstructMaximumBinaryTree(nums []int) *TreeNode {
	return constructMaximumBinaryTree(nums)
}

// 暴力，递归
func constructMaximumBinaryTree(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}
	index := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] > nums[index] {
			index = i
		}
	}
	root := &TreeNode{Val: nums[index]}
	root.Left = constructMaximumBinaryTree(nums[0:index])
	root.Right = constructMaximumBinaryTree(nums[index+1:])
	return root
}

// //单调栈
// func constructMaximumBinaryTree(nums []int) *TreeNode {
// 	var result *TreeNode
// 	leftMaxArr,rightMaxArr:=make([]int,len(nums)),make([]int,len(nums))
// 	for i:=0;i<len(leftMaxArr);i++{
// 		leftMaxArr[i]=-1
// 		rightMaxArr[i]=-1
// 	}
// 	stack := make([]int,0)
// 	nums = append(nums, 10000)
// 	for i,num:=range nums{
// 		//单减栈
// 		//出栈
// 		if  len(stack)>=1 && nums[stack[len(stack)-1]]<num {
// 			if len(stack)>1 {
// 				leftMaxArr[i]=stack[0]
// 			}
// 			stack=stack[0:len(stack)-1]
// 		}
// 		stack = append(stack, i)
// 	}

// 	return result
// }

// //单调栈
// func constructMaximumBinaryTree(nums []int) *TreeNode {
// 	var result *TreeNode

// 	//单减栈
// 	stack := make([]*TreeNode, 0)
// 	stack = append(stack, &TreeNode{})
// 	for index, num := range nums {
// 		node:=&TreeNode{Val: num}

// 		//出栈
// 		for len(stack)>0 &&  stack[len(stack)-1].Val > num{
// 			//尾元素出栈左连
// 			if len(stack) == 1 {
// 				node.Left=stack[0]
// 			}else{
// 				stack[len(stack)-2].Right=stack[len(stack)-1]
// 			}
// 			stack=stack[0:-1]
// 		}

// 		//入栈连接父节点
// 		if len(stack) == 0 ||{
// 			//入栈
// 			stack = append(stack, node)
// 		}else{

// 			if condition {

// 			}
// 		}
// 		//出栈连接子节点
// 	}

// 	return result
// }
