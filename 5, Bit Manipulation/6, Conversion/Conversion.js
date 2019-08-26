/*
 * @param {number, number} num1, num2
 * @return {number} numOfBitFlips
 * Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
 * EXAMPLE
 * Input:   29 (or:11101), 15 (or: 01111)
 * Output:  2
*/

function conversion(num1, num2) {
    let count = 0;
    while (num1 > 0 || num2 > 0) {
        if ((num1 & 1) ^ (num2 & 1) == 1) {
            count++;
        }
        num1 >>= 1;
        num2 >>= 1;
    }
    return count;
}

console.log(conversion(29, 15));