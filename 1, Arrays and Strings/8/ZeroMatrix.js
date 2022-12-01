// Zero Matrix
class Matrix {
  constructor(m, n) {
    this.matrix = [];
    for (let i = 0; i < m; i++) {
      this.matrix[i] = [];
    }
  }

  zeroMatrix() {
    const zeroes = this.getZeroes();
    zeroes.forEach(zero => {
      for (let i = 0; i < this.matrix[0].length; i++) {
        this.matrix[zero.y][i] = 0;
      }
      for (let i = 0; i < this.matrix.length; i++) {
        this.matrix[i][zero.x] = 0;
      }
    });
  }

  getZeroes() {
    const zeroes = [];
    for (let i = 0; i < this.matrix.length; i++) {
      for (let j = 0; j < this.matrix[i].length; j++) {
        if (this.matrix[i][j] == 0) zeroes.push({ x: j, y: i });
      }
    }
    return zeroes;
  }

  printMatrix() {
    this.matrix.forEach(row => {
      console.log(row);
    });
  }
}

const matrix = new Matrix(3, 3);
matrix.matrix[0] = [1, 2, 3, 4];
matrix.matrix[1] = [1, 2, 3, 4];
matrix.matrix[2] = [0, 2, 3, 4];
console.log(matrix.getZeroes());
matrix.printMatrix();
matrix.zeroMatrix();
console.log('Matrix zeroed');
matrix.printMatrix();
