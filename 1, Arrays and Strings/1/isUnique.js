function isAllUniqueCharacters(string) {
  const set = new Set();
  for (let i = 0; i < string.length; i++) {
    if (set.has(string[i])) return false;
    set.add(string[i]);
  }
  return true;
}

const string1 = '1234567890-=qwertyuiop[]\asdfghjkl;';
console.log(isAllUniqueCharacters(string1));
const string2 = 'iyfutyrxtfygiuohigv bh';
console.log(isAllUniqueCharacters(string2));
