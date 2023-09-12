package red;
import java.util.Arrays;
import java.util.Scanner;

public class aprendizaje {
    private double[] variables;
    private double cantidad;

    public aprendizaje(int numInputs, double learningRate) {
        this.variables = new double[numInputs];
        this.cantidad = learningRate;

        // Inicializar con valores aleatorios pequeños cercanos a cero.
        for (int i = 0; i < numInputs; i++) {
            variables[i] = Math.random() * 0.01;
        }
    }
// en esta parte se trabaja con el entrenamiento del codigo en base a los ejemplos suministrados 
    public void entrenamiento(double[] inputs, double target) {
        if (inputs.length != variables.length) {
            throw new IllegalArgumentException("Número incorrecto de entradas");
        }

        double prediccion = predic(inputs);
        double error = target - prediccion;

        for (int i = 0; i < variables.length; i++) {
            variables[i] += cantidad * error * inputs[i];
        }
    }
    
    // aqui se realiza la prediccion en base a los datos del entrenamiento 
    public double predic(double[] inputs) {
        if (inputs.length != variables.length) {
            throw new IllegalArgumentException("Número incorrecto de entradas");
        }

        double output = 0;
        for (int i = 0; i < inputs.length; i++) {
            output = variables[i] * inputs[i];
        }
// se retorna la prediccion
        return output;
    }



}

