package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	fmt.Scanf("%d\n", &n)

	var arr []int

	for i := 0; i < n; i++ {
		var k int
		fmt.Scanf("%d", &k)
		arr = append(arr, k)
	}

	sort.Ints(arr)

	real := 0
	var ans []int
	for _, v := range arr {
		if len(ans) == 0 {
			ans = append(ans, v)
			real += v
			continue
		}
		n := ans[len(ans)-1] + v
		real += n
		ans = append(ans, n)
	}
	fmt.Printf("%d", real)
}
