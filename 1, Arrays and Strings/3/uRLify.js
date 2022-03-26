// URLify

function uRLify(originalString) {
  const string = stringToArray(originalString);
  let right = string.length - 1;
  let left = string.length - 1;
  while (string[left] === ' ') left--;
  while (left >= 0) {
    if (string[left] === ' ') {
      left--;
      string[right] = '0';
      right--;
      string[right] = '2';
      right--;
      string[right] = '%';
      right--;
    } else {
      string[right] = string[left];
      right--;
      left--;
    }
  }
  return arrayToString(string);
}

let string = 'Mr Kevin Nguyen    ';
string = uRLify(string);
console.log(string);
console.log(uRLify('no more lies    '));

function stringToArray(string) {
  let array = [];
  for (let i = 0; i < string.length; i++) {
    array[i] = string[i];
  }
  return array;
}

function arrayToString(array) {
  let string = '';
  array.forEach((char) => string += char);
  return string;
}
