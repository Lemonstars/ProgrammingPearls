package bitmap;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/15
 */
public class BitMapSort {

    public static void main(String[] args){
        int[] array = {5,14,7,8,9,10,20,13,21,15,12, 35,31,37,40,2,-3,-10,-5,50,48};
        bitMapSort(array );
    }

    /**
     * bit map sort
     * @param array there is not repeated number in the array
     */
    public static void bitMapSort(int[] array){
        if(array.length == 0){
            return;
        }

        if(array.length == 1){
            System.out.println(array[0]);
            return;
        }

        //Find the max number and min number in the array
        int max = array[0];
        int min = array[0];
        for(int num: array){
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }

        //From left to right, every num has only one digit which equals to 1
        //in the octal number system
        byte[] maskArray = new byte[]{-128, 64, 32, 16, 8, 4, 2, 1};

        //Initialize the bit map using byte arrays
        int length = max-min+1;
        int numOfBitPerByte = 8;
        int byteNum = length/numOfBitPerByte;
        if( length % numOfBitPerByte != 0){
            byteNum ++;
        }
        byte[] bitmap = new byte[byteNum];
        for(int i=0; i<byteNum; i++){
            bitmap[0] = 0;
        }

        //Compute which bit is 1
        for(int num: array){
            int currentNum = num-min;
            int internalIndex = currentNum / numOfBitPerByte;
            int externalIndex = currentNum % numOfBitPerByte;

            byte mask = maskArray[externalIndex];
            bitmap[internalIndex] = (byte) (bitmap[internalIndex] | mask);
        }

        //Read the bit map and input the corresponding number
        for(int i=0;i<byteNum;i++){
            byte target = bitmap[i];
            for(int j=0;j<numOfBitPerByte;j++){
                byte mask = maskArray[j];
                int maskRes = target & mask;
                if( maskRes != 0){
                    System.out.print(i*numOfBitPerByte+j+min+" ");
                }
            }
        }

    }

}
