package assignmeht1;

class Mergesort {
    //Aufgabe 1
    static String arrayToString(int[] arr) {

        int laenge = arr.length;
        StringBuilder result = new StringBuilder();
        result.append("[");

        for(int i = 0; i < laenge; i++){
            int zahl = arr[i];
            result.append(Integer.toString(zahl));
            if(i < laenge -1){
                result.append(", ");
            }
        }

        result.append("]");

        String singleString = result.toString();

        return singleString;
    }
    //Aufgabe 2
    public static int[] merge(int[] leftArray, int[] rightArray) {

        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int[] arr = new int[leftLength + rightLength];

        int i = 0; 
        int j = 0; 
        int k = 0;

        while(i < leftLength && j < rightLength){
            if (leftArray[i] < rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength){
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength){
            arr[k] = rightArray[j];
            k++;
            j++;
        }
        return arr;
    }

    //Aufgabe 3
    public static int[] mergeSort(int[] array){
        if(array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;                 //intiger divison -> abrunden 
        int[] left = new int[mid];                  //das niederigere
        int rest_mid = array.length - mid;
        int[] right = new int[rest_mid];            //der hoehere


        int i = 0;
        int k = 0;
        int j = 0;

        while(j < array.length){
            if(i < mid){
                left[i] = array[j];
                i++;
                j++;
            } else {
                right[k] = array[j];
                k++;
                j++;
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge(left, right);
    }
    

    public static void main(String[] args) {
        int[] bsp = {1,2,3,4,5};
        System.out.println(arrayToString(bsp));

        System.out.println("***********************");

        int[] leftList_1 = {1,3,5,7};
        int[] rightList_1 = {2,4,6,7};
        int[] result_1 = merge(leftList_1 , rightList_1);
        System.out.println(arrayToString(result_1));

        int[] leftList_3 = {1};
        int[] rightList_3 = {2,4,6,7,8,9};
        int[] result_3 = merge(leftList_3 , rightList_3);
        System.out.println(arrayToString(result_3));

        int[] leftList_4 = {};
        int[] rightList_4 = {2};
        int[] result_4 = merge(leftList_4 , rightList_4);
        System.out.println(arrayToString(result_4));

        System.out.println("***********************");

        int[] list = {7,4,9,2,8,3,1,5};
        int[] result = mergeSort(list);
        System.out.println(arrayToString(result));


        int[] list_1 = {2,8,2,2,6,4,1,3};
        int[] result_5 = mergeSort(list_1);
        System.out.println(arrayToString(result_5));

        int[] list_2 = {5,8,7,2,-7,3,9,6,9};
        int[] result_6 = mergeSort(list_2);
        System.out.println(arrayToString(result_6));
    }
}