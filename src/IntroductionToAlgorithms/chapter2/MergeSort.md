# 归并排序算法
## 伪代码
MERGE(A,p,q,r)
    n1 = q - p +1;
    n2 = r-1;
    let L[1..n1 + 1] and R[1..n2 + 1] be new arrays
    for i = 1 to n1:
        L[i] = A[p + i - 1];
    for j = 1 to n2:
        R[j] = A[q + j];
    L[n1 + 1] = max;
    R[n2 + 1] = max;
    i = 1;
    j = 1;
    for k = p to r:
        if L[i] <= R[j]:
            A[k] = L[i];
            i = i + 1;
        else :
            A[k] = R[j];
            j = j + 1;