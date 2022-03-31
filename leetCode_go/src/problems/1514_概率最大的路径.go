package problems

import (
	"fmt"
	"math"
)

func MaxProbability(n int, edges [][]int, succProb []float64, start int, end int) float64 {
	return maxProbability(n,edges,succProb,start,end)
}

func maxProbability(n int, edges [][]int, succProb []float64, start int, end int) float64 {

	//坐标
	judgeArr:=make([]float64,n)
	judgeArr[start]=1
	//集合
	nodeMap:=make([][]int,n)
	for index:=range edges{
		p1,p2:=edges[index][0],edges[index][1]
		nodeMap[p1]=append(nodeMap[p1],(p2<<15)+index)
		nodeMap[p2]=append(nodeMap[p2],(p1<<15)+index)
	}



	//拓展的节点
	extendNode:=[]int{start}
	extended:=make([]bool,n)
	//extended[end]=true

	//迪杰斯特拉
	for len(extendNode)>0 {
		searchNode:=extendNode[len(extendNode)-1]
		//删除尾部元素
		extendNode=extendNode[0:len(extendNode)-1]
		if ! extended[searchNode]{
			extended[searchNode]=true
			for _,nNodeComp:=range nodeMap[searchNode]{
				nNode,prob:=nNodeComp>>15,succProb[(nNodeComp&0x7fff)]
				//fmt.Println(nNode,prob)
				judgeArr[nNode]=math.Max(judgeArr[nNode],judgeArr[searchNode]*prob)
				if !extended[nNode] {
					extendNode = append(extendNode, nNode)
				}

			}
		}
	}

	for index,used:=range extended{
		if !used  {
			fmt.Println(index,nodeMap[index])
		}
	}

	//fmt.Println(judgeArr)
	return judgeArr[end]
}

