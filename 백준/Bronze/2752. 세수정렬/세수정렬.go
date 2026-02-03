package main

import (
	"fmt"
	"sort"
)

func main() {
	lst := make([]int, 3)

	fmt.Scanf("%d %d %d\n", &lst[0], &lst[1], &lst[2])

	sort.Ints(lst)
	fmt.Printf("%d %d %d", lst[0], lst[1], lst[2])
}
