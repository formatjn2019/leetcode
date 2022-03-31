package problems

import "fmt"

func FindMinHeightTrees(n int, edges [][]int) []int {
	return findMinHeightTrees(n,edges)
}

func findMinHeightTrees(n int, edges [][]int) []int {
	used:=map[int]bool{}
	nodeEdge:=make([][]int,n)
	for i:=range nodeEdge{
		nodeEdge[i]=make([]int,0)
	}
	//边图
	for _,edge:=range edges{
		n1,n2:=edge[0],edge[1]
		nodeEdge[n1] = append(nodeEdge[n1], n2)
		nodeEdge[n2] = append(nodeEdge[n2], n1)
	}
	//lfs遍历
	nodes:=map[int]bool{}
	for index,arr:=range nodeEdge{
		if len(arr)<2 {
			nodes[index]=true
		}
	}
	for len(used)<n&&len(nodes)>0 {
		next:=map[int]bool{}
		for node:=range nodes{
			used[node]=true
			for _,nNode:=range nodeEdge[node]{

					next[nNode] = true

			}
		}
		if len(used)<n {
			nodes=next
		}
	}
	result:=make([]int,0,len(nodes))
	for node:=range nodes{
		result = append(result, node)
	}
	fmt.Println(result)
	return result
}