package red;

import java.util.Scanner;

public class runnig{
    public static void main(String[] args) {
        // en esta clase publica recolectamos los datos para n cantidad de variables de entrada y n cantidad de ejemplos de entrenamiento
        Scanner scanner = new Scanner(System.in);
       //se toman el N numero de variables, sin contar el resultado 
        System.out.println("Ingrese el número de variables de entrada: ");
        int numInputs = scanner.nextInt();
        
      
        // la tasa de aprendizaje 
        System.out.println("Ingrese la tasa de aprendizaje (por ejemplo, 0,1. USAR comas NO PUNTOS): ");
        double learningRate = scanner.nextDouble();

        aprendizaje adaline = new aprendizaje(numInputs, learningRate);
        //cantidad de datos con los que se desea entrenar a ADALINE
        System.out.println("Ingrese los datos de entrenamiento:");
        int num_entrenamiento = scanner.nextInt();

        
        // se crea un bucle para ir almacenado en el array correspondiente los datos de los ejemplos de entrenamiento
        for (int epoch = 0; epoch < num_entrenamiento; epoch++) {
            double[] inputs = new double[numInputs];

            System.out.println("Ejemplo # " + (epoch + 1) + ":");
            for (int i = 0; i < numInputs; i++) {
                System.out.println("Ingrese el valor para la variable " + (i + 1) + ": ");
                inputs[i] = scanner.nextDouble();
            }

            System.out.println("Ingrese el valor objetivo: ");
            double target = scanner.nextDouble();

            adaline.entrenamiento(inputs, target);
        }
        // se ingresan los datos sobre los cuales se quiere hacer la prediccion y esta misma se imprime en pantalla
        System.out.println("Ingrese los datos para hacer una predicción:");
        double[] newInputs = new double[numInputs];
        for (int i = 0; i < numInputs; i++) {
            System.out.println("Ingrese el valor para la variable " + (i + 1) + ": ");
            newInputs[i] = scanner.nextDouble();
        }

        double prediction = adaline.predic(newInputs);
        System.out.println("Predicción: " + prediction);
        

        scanner.close();
    }
}

/* 

a continuacion se anexa un ejemplo del uso de adalinepara ser puesto a prueba el valor del valor debe ser similar o cercano al del ejemplo
dependiendo de la taza de aprendizaje 

Ingrese el número de variables de entrada: 2
Ingrese la tasa de aprendizaje (por ejemplo, 0.01): 0.01
Ingrese el número de ejemplos de entrenamiento: 3
Ingrese los datos de entrenamiento:

Ejemplo 1:
Ingrese el valor para la variable 1 (Tamaño de la casa): 1500
Ingrese el valor para la variable 2 (Número de habitaciones): 3
Ingrese el valor objetivo (Precio): 200000

Ejemplo 2:
Ingrese el valor para la variable 1 (Tamaño de la casa): 2000
Ingrese el valor para la variable 2 (Número de habitaciones): 4
Ingrese el valor objetivo (Precio): 250000

Ejemplo 3:
Ingrese el valor para la variable 1 (Tamaño de la casa): 1200
Ingrese el valor para la variable 2 (Número de habitaciones): 2
Ingrese el valor objetivo (Precio): 150000

Ingrese los datos para hacer una predicción:
Ingrese el valor para la variable 1 (Tamaño de la casa): 1800
Ingrese el valor para la variable 2 (Número de habitaciones): 3
Predicción: 204000.0
*/
