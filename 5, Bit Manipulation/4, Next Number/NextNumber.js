/*
 * @param {number} num
 * Given a positive integer, print the next smallest and the next largest number that have the same number of 1 bits in their binary representation.
*/

function nextNumber(num) {
    let c = num;
    let c0 = 0;
    let c1 = 0;
    while (((c & 1) == 0) && (c != 0)) {
        c0++;
        c >>= 1;
    }

    while ((c & 1) == 1) {
        c1++;
         c >>= 1;
    }

    if (c0 + c1== 31 || c0 + c1 == 0) {
        return -1;
    }

    let p = c0 + c1;

    num |= (1 << p);
    num &= ~((1 << p) - 1);
    num |= (1 << (c1 - 1)) - 1;
    return num;
}

const number = 5;
console.log(number.toString(2));
console.log(nextNumber(number).toString(2));