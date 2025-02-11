//Participaciones
  //Carlos Molina
  //Isabel Angulo
  //Sergio Ramos
  //Johan Sebastian Caicedo

import javax.swing.*;
import java.util.ArrayList;

//Clase Main
public class Main {

  //Metodo Principal
  public static void main(String[] args) {

    String nombre = "Carlos";
    int edad = 19;
    boolean isVivo = true;

//    System.out.printf("Hello Soy "+ nombre
//        + "\nTengo" + edad +" años "
//        +"\nVivo = "+ isVivo);

//    numMayor();
    nombreInversos();
  }

  //CamelCase = sumarNumeros();
  //PascalCase = SumarNumeros;

  //SnakeCase = sumar_numeros();
  //KebabCase = sumar-numeros();

  //Ejercicio numero 1
  public static void nombreInversos(){
    int cont = 5;
    ArrayList<String> nombres = new ArrayList<String>();

    for (int i = 0; i < nombres.size(); i++) {
      nombres.add(JOptionPane.showInputDialog("Nombre: " + i));
    }
  }

  //Ejercicio numero 2
  public static void numMayor(){

    int num1 = 1;
    int num2 = 2;
    int num3 = 3;

    if(num1 == num2 && num2 == num3){
      System.out.println("Todos los numeros son iguales");

    }else if (num1 > num2 && num1 > num3){
      System.out.println("El numero mayor es el " + num1);

    }else if(num2 > num1 && num2 > num3){
      System.out.println("El numero mayor es el " + num2);

    }else{
      System.out.println("El numero mayor es el " + num3);
    }

  }
}
