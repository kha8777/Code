#include <stdio.h>

long sum(int n) {
    if (n == 0) return 0;
    return n % 10 + sum(n / 10);
}

int main(int argc, char const *argv[]) {
    printf("%ld", sum(123));
    return 0;
}
