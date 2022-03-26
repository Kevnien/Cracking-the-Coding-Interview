// One Away

function isOneAway(string1, string2) {
  let pointer1 = 0, pointer2 = 0;
  let foundOneDifference = false;
  while (pointer1 < string1.length || pointer2 < string2.length) {
    if (string1[pointer1] !== string2[pointer2]) {
      if (foundOneDifference) return false;
      foundOneDifference = true;
      if (string1[pointer1 + 1] === string2[pointer2]) {
        pointer1++;
      } else if (string1[pointer1] === string2[pointer2 + 1]) {
        pointer2++;
      }
    }
    pointer1++;
    pointer2++;
  }
  return true;
}

console.log(isOneAway('pale', 'ple'));
console.log(isOneAway('pales', 'pale'));
console.log(isOneAway('pale', 'bale'));
console.log(isOneAway('pale', 'bake'));
