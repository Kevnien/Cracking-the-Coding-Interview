// Write an algorithm such that if an element in an MxN matrix is 0,
// its entire row and column are set to 0

class ZeroMatrix{
    public static void zeroMatrix(int[][] matrix){
        Integer[][] copy = new Integer[matrix.length][matrix[0].length];
        for(int y=0; y<matrix.length; y++){
            for(int x=0; x<matrix[y].length; x++){
                if(copy[y][x] == null){
                    copy[y][x] = matrix[y][x];
                }
                if(matrix[y][x] == 0){
                    System.out.println("found 0");
                    for(int xi=0; xi<matrix[y].length; xi++){
                        copy[y][xi] = 0;
                    }
                    for(int yi=0; yi<matrix.length; yi++){
                        copy[yi][x] = 0;
                    }
                    print(copy);
                }
            }
        }
        for(int y=0; y<matrix.length; y++){
            for(int x=0; x<matrix[y].length; x++){
                matrix[y][x] = copy[y][x];
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,0,1,2}
        };
        print(matrix);
        zeroMatrix(matrix);
        print(matrix);
    }

    public static void print(int[][] matrix){
        for(int y=0; y<matrix.length; y++){
            for(int x=0; x<matrix[y].length; x++){
                System.out.print(matrix[y][x]+", ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void print(Integer[][] matrix){
        for(int y=0; y<matrix.length; y++){
            for(int x=0; x<matrix[y].length; x++){
                System.out.print(matrix[y][x]+", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}