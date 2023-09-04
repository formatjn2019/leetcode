package test

import (
	"src/problems"
	"testing"
)

/**
 * Your AllOne object will be instantiated and called as such:
 * obj := AuthenticationConstructor();
 * obj.Inc(key);
 * obj.Dec(key);
 * param_3 := obj.GetMaxKey();
 * param_4 := obj.GetMinKey();
 */
func TestAllOne(t *testing.T) {
	allOne := problems.AllOneConstructor()

	allOne.Inc("hello")
	allOne.Inc("goodbye")
	allOne.Inc("hello")
	allOne.Inc("hello")
	println(allOne.GetMaxKey()) // 返回 "hello"
	allOne.Inc("leet")
	allOne.Inc("code")
	allOne.Inc("leet")
	allOne.Dec("hello")
	allOne.Inc("leet")
	allOne.Inc("code")
	allOne.Inc("code")
	allOne.Dec("leet")
	println(allOne.GetMaxKey()) // 返回 "hello"

}
