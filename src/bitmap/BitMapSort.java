package bitmap;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/15
 */
public class BitMapSort {

    public static void main(String args[]){

        int[] array = {0,4,7,2,10,3,11,5,14};
        bitMapSort(array);

    }

    public static void bitMapSort(int[] array){

        byte[] maskArray = new byte[]{-128, 64, 32, 16, 8, 4, 2, 1};

        int length = array.length;
        int byteNum = length/8;
        if( length%8 != 0){
            byteNum ++;
        }
        byte[] bitmap = new byte[byteNum];
        for(int i=0; i<byteNum; i++){
            bitmap[0] = 0;
        }

        for(int i=0;i<length;i++){
            int currentNum = array[i];
            int internalIndex = currentNum/8;
            int externalIndex = currentNum%8;

            byte mask = maskArray[externalIndex];
            bitmap[internalIndex] = (byte) (bitmap[internalIndex] | mask);
        }

        for(int i=0;i<byteNum;i++){
            byte target = bitmap[i];
            for(int j=0;j<8;j++){
                byte mask = maskArray[j];
                int maskRes = target & mask;
                if( maskRes != 0){
                    System.out.print(i*8+j+" ");
                }
            }
        }

    }

}
