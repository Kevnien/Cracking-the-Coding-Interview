/*
 * @param {number} num
 * @return {number} longestLength
 * You have an integer and you can flip exactly one bit from 0 to 1.
 * Write code to find the length of the longest sequence of 1s you can create.
*/

function FlipBitToWin(num) {
    const binary = num.toString(2);
    let total = 0;
    let biggest = 0;
    for(let i=0; i<binary.length; i++) {
        if (binary[i] === '0') {
            total++;
            for(let j=i+1; j<binary.length; j++) {
                if (binary[j] === '0') {
                    break;
                }
                total++;
            }
            if (total > biggest) {
                biggest = total;
            }
            total = 0;
        } else {
            total++;
        }
    }
    return biggest;
}

console.log(FlipBitToWin(1775));