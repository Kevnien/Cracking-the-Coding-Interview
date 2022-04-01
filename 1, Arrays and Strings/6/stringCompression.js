// String Compression

function stringCompression(string) {
  let compressedString = '';
  let count = 0;
  for (let i = 0 ; i < string.length; i++) {
    if (count === 0) compressedString = compressedString + string[i];
    count++;
    if (string[i] !== compressedString[compressedString.length - 1]) {
      compressedString = compressedString + (count - 1);
      count = 0;
      i--;
    }
  }
  if (string.length <= compressedString.length) return string;
  return compressedString;
}

console.log(stringCompression('aabcccccaaa'));
console.log(stringCompression('abcdef'));
