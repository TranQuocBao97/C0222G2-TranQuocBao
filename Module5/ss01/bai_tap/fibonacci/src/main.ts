function isFibonacci(number: number): number {
    if (number === 0) {
        return 0;
    }
    if (number === 1) {
        return 1;
    }
    return isFibonacci(number-1)+isFibonacci(number-2)
}

let amountOfFibonacciNumbers: number = 10;
let sum: number = 0;
for (let i = 0; i <= amountOfFibonacciNumbers; i++) {
    console.log(isFibonacci(i));
    sum += isFibonacci(i);
}

console.log('sum = ' +sum);