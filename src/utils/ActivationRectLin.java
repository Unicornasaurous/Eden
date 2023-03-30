package utils;
/*
 * This class provides the means of converting outputs of a neural layer
 * to their rectified linear form. Essentially, if the output is not greater than
 * zero, the output is 0. Otherwise, the output is equal to the original 
 * output
 */
public class ActivationRectLin {

    public double[][] outputs;

    public void forward(double[][] inputs){

        for(int i = 0; i < inputs.length; i++){

            for(int ii = 0; ii < inputs[i].length; ii++){

                if (inputs[i][ii] > 0){

                    inputs[i][ii] = inputs[i][ii];

                } else {

                    inputs[i][ii] = 0.0;
                }
            }
        }

        this.outputs = inputs;
    }
}
