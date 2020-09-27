## Prefix Sum Array Problems

1. [Tape Equilbrium](ATapeEquilbrium.java) : 
It is the absolute difference between the sum of the first part and the sum of the second part. Return the minimum difference.
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
Return the minimum difference.
Example : [3, 1, 2, 4, 3] -> [(3, 10) -> 7], [(4, 9) -> 5], [(6, 7) -> 1], [(10, 3) -> 7] Min : 1

1. [Find the largest possible even sum of K elements at different positions in input array A.](BFindMaxEvenSum.java)


