// Palindrome Permutation

function isPalindromePermutation(originalString) {
  const string = originalString.toLowerCase();
  const map = {};
  const set = new Set();

  for (let i = 0; i < string.length; i++) {
    if (string[i] === ' ') continue;
    if (!map[string[i]]) {
      map[string[i]] = 1;
      set.add(string[i]);
    } else {
      map[string[i]]++;
      if (map[string[i]] % 2 === 0) {
        set.delete(string[i]);
      } else {
        set.add(string[i]);
      }
    }
  }
  if (set.size > 1) return false;
  return true;
}

console.log(isPalindromePermutation('Tact Coa'));
console.log(isPalindromePermutation('Ttactt Coa'));
console.log(isPalindromePermutation('Tact Coaz'));
