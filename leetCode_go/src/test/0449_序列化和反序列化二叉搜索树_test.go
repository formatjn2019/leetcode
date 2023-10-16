package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

// Serializes a tree to a single string.
func TestCodec(t *testing.T) {
	constructor := problems.ConstructorTree()
	s := constructor.Serialize(tools.ParseTree("[2,1,3]"))
	fmt.Println(s)
	deserialize := constructor.Deserialize(s)
	fmt.Println(deserialize)
	//ser := AuthenticationConstructor()
	//deser := AuthenticationConstructor()
	//tree := ser.serialize(root)
	//* ans := deser.deserialize(tree)
	//* return ans'
}
