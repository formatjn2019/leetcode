package test

import (
	"src/problems"
	"testing"
)

func TestAuthenticationManager(t *testing.T) {
	// am := problems.Constructor(5)
	// am.Renew("aaa", 1)
	// am.Generate("aaa", 2)
	// cont := am.CountUnexpiredTokens(6)
	// println(cont)
	// am.Generate("bbb", 7)
	// am.Renew("aaa", 8)
	// am.Renew("bbb", 10)
	// cont = am.CountUnexpiredTokens(15)
	// println(cont)
	// AuthenticationManager authenticationManager = new AuthenticationManager(5); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
	// authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
	// authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
	// authenticationManager.countUnexpiredTokens(6); // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
	// authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
	// authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
	// authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
	// authenticationManager.countUnexpiredTokens(15); // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。

	// ["AuthenticationManager","countUnexpiredTokens","renew","generate","renew"
	// ,"countUnexpiredTokens","renew","generate","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens"]
	// [[28],[2],["xokiw",6],["ofn",7],["dses",15],[17],["ofzu",19],["dses",20],[23],[27],[30]]
	count := 0
	am2 := problems.Constructor(28)
	count = am2.CountUnexpiredTokens(2) //0
	print(count)
	am2.Renew("xokiw", 6)                //0
	am2.Generate("ofn", 7)               //1
	am2.Renew("dses", 15)                //1
	count = am2.CountUnexpiredTokens(17) //1
	print(count)
	am2.Renew("ofzu", 19)                //1
	am2.Generate("dses", 20)             //2
	count = am2.CountUnexpiredTokens(23) //2
	print(count)
	count = am2.CountUnexpiredTokens(27) //2
	print(count)
	count = am2.CountUnexpiredTokens(30) //2
	print(count)
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * obj := Constructor(timeToLive);
 * obj.Generate(tokenId,currentTime);
 * obj.Renew(tokenId,currentTime);
 * param_3 := obj.CountUnexpiredTokens(currentTime);
 */
