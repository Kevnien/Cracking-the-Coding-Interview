/* Given a real number between 0 and 1 that is passed in as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR".
 * @param {number} num
 * @return {string} binary
*/

function binaryToString(num) {
    if (num >= 1 || num <= 0) {
        return 'Input not between 0 and 1;';
    }

    let string = '0.';
    while (num > 0) {
        if (string.length > 32) {
            return 'Exceeds 32 characters.';
        }

        const r = num * 2;
        if (r >= 1) {
            string += '1';
            num = r - 1;
        } else {
            string += '0';
            num = r;
        }
    }

    return string;
}

console.log(binaryToString(0.72));
console.log(binaryToString(0.625));