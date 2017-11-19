package bitmap;

/**
 * 对于一个待排序数组，每个数字出现的次数不超过127(2^8 -1)次
 *
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/19
 */
public class AdvancedBitMapSort {

    public static void main(String[] args){
        int[] array = {3,4,2,6,6,5,7,8,10,1,1,100,50,60,40,30,70,60};
        sort(array);
    }

    public static void sort(int[] array){
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

        //Initialize the byte arrays
        int num = max - min + 1;
        byte[] numberSort = new byte[num];
        for(int i=0; i<num;i++){
            numberSort[i] = 0;
        }

        //compute the map
        for(int target: array){
            numberSort[target-min]++;
        }

        //input the result
        for(int i=0;i<num;i++){
            byte time = numberSort[i];
            for(byte b=0;b<time;b++){
                System.out.print(i+min+" ");
            }
        }
    }

}
