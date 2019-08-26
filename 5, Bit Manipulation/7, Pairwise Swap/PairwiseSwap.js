/*
 * @param {number} num
 * @return {number} pairwiseSwappedNum
 * Write a program to swap odd and even bits in an integer with as few instructions as possible.
*/

function pairwiseSwap(num) {
    let i = 0;
    let answer = 0;
    while (num > 0) {
        answer = (((num & 2) >> 1) << i++) | answer;
        answer= ((num & 1) << i++) | answer;
        num >>= 2;
    }
    return answer;
}

let input = 42;
console.log(input.toString(2));
console.log(pairwiseSwap(input).toString(2));