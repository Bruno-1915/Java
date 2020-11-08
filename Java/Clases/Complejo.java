public class Complejo {
    private double real;
    private double imaginario;

    public Complejo(double real, double imaginario){

        this.real = real;
        this.imaginario = imaginario;
    }

    public double getImaginario() {
        return imaginario;
    }

    public double getReal() {
        return real;
    }

    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public static Complejo suma(Complejo c1, Complejo c2){
        double r = c1.real + c2.real;
        double i = c1.imaginario + c2.imaginario;
        Complejo c3 = new Complejo(r, i);

        return c3;
    }

    public static Complejo resta(Complejo c1, Complejo c2){

        double r = c1.real - c2.real;
        double i = c1.imaginario - c2.imaginario;
        Complejo c3 = new Complejo(r, i);

        return c3;
    }

    public static Complejo multiplicacion(Complejo c1, Complejo c2){

        double r = c1.real * c2.real - (c1.imaginario * c2.imaginario);
        double i = c1.imaginario * c2.real + c1.real * c2.imaginario;
        Complejo c3 = new Complejo(r, i);

        return c3;
    }

    public static Complejo division(Complejo c1, Complejo c2){

        double temp1 = (c2.real * c2.real) + (c2.imaginario * c2.imaginario);
        double temp2 = c1.real * c2.real + c1.imaginario * c2.imaginario;
        double temp3 = c1.imaginario * c2.real - c1.real * c2.imaginario;
        double i = (temp3) / (temp1);
        double r = temp2 / temp1;
        Complejo c3 = new Complejo(r, i);

        return c3;
    }

    public String toString() {

        String s = "";
        s += "( " + this.real + " , " + this.imaginario + "i )";

        return s;
    }

    public static void main(String[] args) {

        System.out.println("#############################################");
        System.out.println("# Comprobacion metodos de numeros complejos #");
        System.out.println("#############################################");
        System.out.println("");

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("% Suma de dos complejos %");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
        Complejo c1 = new Complejo(3, 2);
        Complejo c2 = new Complejo(-1, 2);
        System.out.print("Complejo 1: ");
        System.out.println(c1.toString());
        System.out.print("Complejo 2: ");
        System.out.println(c2.toString());
        Complejo c3 = suma(c1, c2);
        System.out.println("La suma es: " + c3.toString());
        System.out.println("");

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("% Resta de dos complejos %");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%");
        c3 = resta(c1, c2);
        System.out.print("Complejo 1: ");
        System.out.println(c1.toString());
        System.out.print("Complejo 2: ");
        System.out.println(c2.toString());
        System.out.println("La resta es: " + c3.toString());
        System.out.println("");

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("% Multiplicacion de dos complejos %");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.print("Complejo 1: ");
        System.out.println(c1.toString());
        System.out.print("Complejo 2: ");
        System.out.println(c2.toString());
        c3 = multiplicacion(c1, c2);
        System.out.println("La multiplicacion es: " + c3.toString());
        System.out.println("");

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("% Division de dos complejos %");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.print("Complejo 1: ");
        System.out.println(c1.toString());
        System.out.print("Complejo 2: ");
        System.out.println(c2.toString());
        c3 = division(c1, c2);
        System.out.println("La division es: " + c3.toString());
    }

}