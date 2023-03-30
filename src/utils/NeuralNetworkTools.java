package utils;

public abstract class NeuralNetworkTools {
        /*
     * Method converts a number to a number within the range of a sigmoid function
     * 
     */
    public static double sig (double x){
        return 1 / (1 + Math.exp(-x));
    }

    /*
     * Method produces the dot product of the given vectors
     * A dot product is an algorithm in which each indexed element at the nth index 
     * from both vectors is muultiplied and then added to the subsequent multiplied
     * indexed values
     * Example: 
     * vector1 = {1, 2, 3, 4, 5}
     * vector2 = {6, 7, 8, 9, 10}
     * dot_product = (vector1[0] * vector2[0]) + (vector1[1] * vector[1]) + ...
     */
    public static double dotProduct(double[] vector1, double[] vector2){

        double output = 0;

        for (int i = 0; i < vector1.length; i++){
            output += vector1[i] * vector2[i];
        }

        return output;
    }

    /*
     * Method produces the dot product for the given matrix and vector
     */
    public static double[] dotProduct(double[][] matrix, double[] vector){

        double[] outPutList = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++){
            for (int ii = 0; ii < vector.length; ii++){
                outPutList[i] += matrix[i][ii] * vector[ii];
            }
        }

        return outPutList;
    }

    public static double[][] dotProduct(double[][] matrix1, double[][] matrix2){

        // Note length of matrix of dimensions: The length of the first dimension should
        // correspond to the length of the second matrix
        double[][] outPutMatrix = new double[matrix2.length][matrix1.length];

        for(int i = 0; i < outPutMatrix.length; i++){
            outPutMatrix[i] = dotProduct(matrix1, matrix2[i]);
        }

        return outPutMatrix;
    }

    /*
     * Method adds the indexed values of two equal lengthed vectors(or arrays)
     */

    public static double[] addBiases (double[] array1, double[] biases){
        double[] newArray = new double[array1.length];

        for(int i = 0; i < array1.length; i++){
            newArray[i] = array1[i] + biases[i];
        }

        return newArray;
    } 

    public static double[][] addBiases(double[][] matrix, double[] biases){
        for(int i = 0; i < matrix.length; i++){
            matrix[i] = addBiases(matrix[i], biases);
        }
        return matrix;
    }

    /*
     * Method prints out a built in array
     */
    public static void printArray(double[] array){

        int index = 0;

        System.out.print('{');

        for(double component : array){
            if (index < array.length-1){
                System.out.print(component + ", ");
            } else{
                System.out.print(component + ('}' + "\n"));
            }
        
            index += 1;
        }
    }

    public static void printMatrix(double[][] matrix){

        System.out.print('{');

        for(int i = 0; i < matrix.length; i++){
            System.out.print('{');
            for(int ii = 0; ii < matrix[i].length; ii++){
                if(ii < matrix[i].length - 1){
                    System.out.print(matrix[i][ii] + ", ");
                } else{
                    System.out.print(matrix[i][ii]);
                }
            }
            if (i != matrix.length - 1){
                System.out.print("},\n"); 
            } else{
                System.out.print('}');
            }
            
        }

        System.out.print('}' + "\n");
    }

    /*
     * Method outputs the sum of a vector(1d array)
     */

    public static double sumOfArray(double[] array){

        double sum = 0;

        for(double num : array){
            sum += num;
        }

        return sum;
    }

    /*
     * Method firstly puts inputs in a matrix through an expnonential 
     * function. It then normalizes the inputs by turning each data point
     * into a probability by first summing all of the inputs in a given set
     * and dividing each input by the summation.
     */
    public static double[][] normalize(double[][] inputs){
        
        double sumOfSet;

        for(int i = 0; i < inputs.length; i++){
            for(int ii = 0; ii < inputs[i].length; ii++){
                inputs[i][ii] = Math.exp(inputs[i][ii]);
            } 
        }

        for(int i = 0; i < inputs.length; i++){
            sumOfSet = sumOfArray(inputs[i]);
            for(int ii = 0; ii < inputs[i].length; ii++){
                inputs[i][ii] = inputs[i][ii] / sumOfSet;
            } 
        }

        return inputs;
    }
}
