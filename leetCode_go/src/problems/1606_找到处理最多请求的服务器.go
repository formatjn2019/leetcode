package problems

func BusiestServers(k int, arrival []int, load []int) []int {
	return busiestServers_timeout(k,arrival,load)
}

func busiestServers_timeout(k int, arrival []int, load []int) []int {
	servers,serversCount:=make([]int,k),make([]int,k)
	for index,arriv:=range arrival{
		for numCount :=0; numCount <k; numCount++ {
			start:=(numCount +index)%k
			if servers[start]<=arriv{
				serversCount[start]++
				servers[start]=arriv+load[index]
				break
			}
		}
	}
	//fmt.Println(servers)
	//fmt.Println(serversCount)
	result:=make([]int,0)
	max:=0
	for index:=range servers{
		if serversCount[index]>max {
			max=serversCount[index]
			result=[]int{index}
		}else if serversCount[index]==max {
			result = append(result, index)
		}
	}
	return result
}
