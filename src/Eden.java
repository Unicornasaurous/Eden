
import utils.NeuralNetworkTools;
import utils.LayerDense;
import utils.ActivationRectLin;

public class Eden extends NeuralNetworkTools {
    public static void main(String[] args){
        double[][] inputs = {{1, 2, 3, 2.5},
                             {2.0, 5.0, -1.0, 2.0},
                             {-1.5, 2.7, 3.3, -0.8}};

        double[][] weights1 = {{0.2, 0.8, -0.5, 1.0},
                              {0.5, -0.91, 0.26, -0.5},
                              {-0.26, -0.27, 0.17, 0.87}};
                              
        double[]  biases1 = {2, 3, 0.5};

        double[][] weights2 = {{0.1, -0.14, 0.5},
                              {-0.5, 0.12, -0.33},
                              {-0.44, 0.73, -0.13}};
                              
        double[]  biases2 = {-1, 2, -0.5};

        //double[][] layer1Outputs = addBiases(dotProduct(weights1, inputs), biases1);
        //double[][] layer2Outputs = addBiases(dotProduct(weights2, layer1Outputs), biases2);
        //printMatrix(layer2Outputs);
        LayerDense layer1 = new LayerDense(4, 5);

        ActivationRectLin activation1 = new ActivationRectLin();

        LayerDense layer2 = new LayerDense(5, 6);

        ActivationRectLin activation2 = new ActivationRectLin();

        layer1.forward(inputs);

        double[][] layer1Outputs = layer1.outputs;

        activation1.forward(layer1Outputs);

        layer2.forward(activation1.outputs);

        double[][] layer2Ouputs = layer2.outputs;

        activation2.forward(layer2Ouputs);

        System.out.println("Layer 1 Output");
        printMatrix(activation1.outputs);

        System.out.println("Final Output:");
        printMatrix(activation2.outputs);

    }


}
