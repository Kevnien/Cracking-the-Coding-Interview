// Rotate Matrix

function rotateMatrix(matrix) {
  const layers = matrix[0].length / 2;
  for (let i = 0; i < layers; i++) {
    const first = i;
    const last = matrix[0].length - 1 - i;
    for (let j = first; j < last; j++) {
      const offset = j - first;
      const top = matrix[first][j];
      matrix[first][j] = matrix[last - offset][first];
      matrix[last - offset][first] = matrix[last][last - offset];
      matrix[last][last - offset] = matrix[j][last];
      matrix[j][last] = top;
    }
  }
}

const matrix = [[1,2],[3,4]];
rotateMatrix(matrix);
console.log(matrix);
const matrix2 = [[1,2,3],[4,5,6],[7,8,9]];
rotateMatrix(matrix2);
console.log(matrix2);
