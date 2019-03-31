// Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to ratate the image by 90 degrees.
// Can you do this in place?

class RotateMatrix{
    public static void rotateMatrix(byte[][][] image){
        // work from outermost layer to innermost layer
        for(int layer=0; layer<image.length/2; layer++){
            int n = image.length-1-layer;
            for(int i=layer; i<n; i++){
                byte[] temp = new byte[3];
                System.arraycopy(image[layer][layer+i], 0, temp, 0, 3);
                System.arraycopy(image[n-i][layer], 0, image[layer][layer+i], 0, 3);
                System.arraycopy(image[n][n-i], 0, image[n-i][layer], 0, 3);
                System.arraycopy(image[layer+i][n], 0, image[n][n-i], 0, 3);
                System.arraycopy(temp, 0, image[layer+i][n], 0, 3);
            }
        }
    }

    public static void print(byte[][][] image){
        for(int y=0; y<image.length; y++){
            for(int x=0; x<image[y].length; x++){
                if(x == image[y].length-1){
                    System.out.print(image[y][x][0]);
                    continue;
                }
                System.out.print(image[y][x][0] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        byte[][][] image = {
            {{(byte)0x0A,(byte)0x0A,(byte)0x0A}, {(byte)0x0B,(byte)0x0B,(byte)0x0B}, {(byte)0x0C,(byte)0x0C,(byte)0x0C}, {(byte)0x0D,(byte)0x0D,(byte)0x0D}},
            {{(byte)0x0E,(byte)0x0E,(byte)0x0E}, {(byte)0x0F,(byte)0x0F,(byte)0x0F}, {(byte)0x10,(byte)0x10,(byte)0x10}, {(byte)0x11,(byte)0x11,(byte)0x11}},
            {{(byte)0x12,(byte)0x12,(byte)0x12}, {(byte)0x13,(byte)0x13,(byte)0x13}, {(byte)0x14,(byte)0x14,(byte)0x14}, {(byte)0x15,(byte)0x15,(byte)0x15}},
            {{(byte)0x16,(byte)0x16,(byte)0x16}, {(byte)0x17,(byte)0x17,(byte)0x17}, {(byte)0x18,(byte)0x18,(byte)0x18}, {(byte)0x19,(byte)0x19,(byte)0x19}}
        };
        print(image);
        rotateMatrix(image);
        print(image);
    }
}