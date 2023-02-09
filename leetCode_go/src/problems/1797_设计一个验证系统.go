package problems

import "fmt"

type AuthenticationManager struct {
	timeToLive   int
	tokenTimeMap map[string]int
}

func Constructor(timeToLive int) AuthenticationManager {
	return AuthenticationManager{timeToLive: timeToLive, tokenTimeMap: map[string]int{}}
}

func (this *AuthenticationManager) Generate(tokenId string, currentTime int) {
	this.tokenTimeMap[tokenId] = currentTime + this.timeToLive
}

func (this *AuthenticationManager) Renew(tokenId string, currentTime int) {
	if this.tokenTimeMap[tokenId] > currentTime {
		this.tokenTimeMap[tokenId] = currentTime + this.timeToLive
	}
}

func (this *AuthenticationManager) CountUnexpiredTokens(currentTime int) int {
	result := 0
	fmt.Println(this.tokenTimeMap)
	for _, time := range this.tokenTimeMap {
		if time > currentTime {
			result++
		}
	}
	return result
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * obj := Constructor(timeToLive);
 * obj.Generate(tokenId,currentTime);
 * obj.Renew(tokenId,currentTime);
 * param_3 := obj.CountUnexpiredTokens(currentTime);
 */
