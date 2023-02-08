package test

import (
	"src/problems"
	"testing"
)

func TestRemoveSubfolders(t *testing.T) {
	problems.RemoveSubfolders([]string{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"})
	problems.RemoveSubfolders([]string{"/a", "/a/b/c", "/a/b/d"})
	problems.RemoveSubfolders([]string{"/a/b/c", "/a/b/ca", "/a/b/d"})
	// problems.RemoveSubfolders([]string{"/a","/a/b","/c/d","/c/d/e","/c/f"})

}
