// Check Permutation

function isPermutation(string1, string2) {
  if (string1.length !== string2.length) return false;
  const map = {};
  const iterator1 = string1[Symbol.iterator]();
  let current = iterator1.next();
  while (!current.done) {
    if (!map[current.value]) {
      map[current.value] = 1;
    } else {
      map[current.value]++;
    }
    current = iterator1.next();
  }
  const iterator2 = string2[Symbol.iterator]();
  current = iterator2.next();
  while (!current.done) {
    if (!map[current.value]) return false;
    map[current.value]--;
    current = iterator2.next();
  }
  return true;
}

console.log(isPermutation('Kevin', 'niveK'));
console.log(isPermutation('Chucky', 'Chucko'));
