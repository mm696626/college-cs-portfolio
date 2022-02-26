public class MergeArray {

       public static void main(String[] args) {

              int[] arrayA = {1,3,5,7,9};

              int[] arrayB = {11,13,15,17,19};
              int[] arrayC = new int[arrayA.length + arrayB.length];
              
              for(int i=0; i<arrayA.length; i++)
              {
            	  arrayC[i] = arrayA[i];
              }
              for(int i=0; i<arrayB.length; i++)
              {
            	  arrayC[i+arrayA.length] = arrayB[i]; 
              }
              for (int i=0; i<arrayA.length + arrayB.length; i++){
            	 
                     System.out.print(arrayC[i]+"  ");

              }

       }

}