package utils;

public class LayerDense extends utils.NeuralNetworkTools{

    public double[][] weights;
    public double[] biases;
    public double[][] outputs;
    public double[] outputsVector;

    public LayerDense(int n_inputs, int n_neurons){

        this.weights = setWeights(n_inputs, n_neurons);
        this.biases = setBiases(n_neurons);
    }
    
    public void forward(double[][] inputs) {

        this.outputs = addBiases(dotProduct(this.weights, inputs), this.biases);
    } 

    public void forward(double[] inputs) {

        this.outputsVector = addBiases(dotProduct(this.weights, inputs), this.biases);
    }

    /*
     * Method creates a matrix of random doubles based on the given inputs and neurons
     * Example: If there are 4 inputs, and 3 neurons, there would
     * be a total of 3 elements in the first dimension and
     * 4 elements in the 2nd dimension, making up 12 total weights
     */
    private double[][] setWeights(int n_inputs, int n_neurons){

        double[][] weights = new double[n_neurons][n_inputs];

        for(int i = 0; i < weights.length; i++){
            for(int ii = 0; ii < weights[i].length; ii++){
                weights[i][ii] = (Math.random() * 2.0) - 1.0;
            }
        }

        return weights;
    }

    /*
     * Method creates a vector of biases with the number of elements equal to
     * the amount of neurons initialized to zeros
     */
    private double[] setBiases(int neurons){

        return new double[neurons];
    }
}

