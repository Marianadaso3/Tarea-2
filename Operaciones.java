/**
 * @author Mariana David 201055
 * @version 1.0.0
 */

// Importaciones
import java.io.*;


public class Operaciones implements calculadora{
    /**
     * @param x  numero 1 por sumar
     * @param y  numero 2 por sumar
     * Función para sumar ambos numeros
     */
    public int suma(int x, int y){
        return x+y;
    }
    /**
     * @param x numero  1 como minu
     * @param y  numero 2 como sustraendo
     * Función para restar ambos numeros
     */
    public int resta(int x, int y){
        return x-y;
    }
    /**
     * @param x  numero 1 como producto
     * @param y  numero 2 como producto 
     * Función para multiplicar ambos numeros
     */
    public int multiplicacion(int x, int y){
        return x*y;
    }
    /**
     * @param x numero 1 como dividendo 
     * @param y numero 2 como divisor
     * Función para dividir ambos numeros
     */
    public int division(int x, int y){
        return (int)x/y;
    }

    /**
     * @param x  Stack almacena la operacion en forma de postfix
     * Función para sumar ambos numeros
     */
    public int operar(Stack x){ 
        //Variables declaradas
        int numero = 0;
        String[] numeros = new String[2];
        numeros[0] = "P";
        numeros[1] = "P";
        while(!x.empty()){
                if(x.size()!=1){

                //Obtención de los valores operados
                while(numeros[0]=="P" || numeros[1]=="P"){
                    boolean bandera = true;
                    try{
                        Integer.parseInt(x.peek().toString());
                        bandera = true;

                    }catch(Exception e){
                        bandera = false;
                    }

                    if(x.peek().toString().charAt(0)!='+' && x.peek().toString().charAt(0)!='-' && x.peek().toString().charAt(0)!='*' &&  x.peek().toString().charAt(0)!='/' && bandera){
                        if(numeros[0]=="P")
                            numeros[0]=x.pop().toString();
                        else if(numeros[1]=="P")
                            numeros[1]=  x.pop().toString();
                    }
                }
                
                
                // Operar los numeros 
                if(!Character.isDigit((char) x.peek())){ 
                int num1=Integer.parseInt(numeros[0]);           
                int num2=Integer.parseInt(numeros[1]);   
                // colocar las repuestas en el array      
                    switch ((char) x.pop()) {
                        case '+':
                            System.out.println("Se sumaran "+num1+" + "+num2);
                            x.push(suma(num1,num2));
                            System.out.println("Ingresado al array: "+(Object) x.peek());
                            break;
                        case '-':
                            System.out.println("Se restaran "+num1+" - "+num2);
                            x.push((char) resta(num1,num2));
                            System.out.println("Ingresando al array: "+(Object)x.peek());

                            break;
                        case '*':
                            System.out.println("Se multiplicaran "+num1+" * "+num2);
                            x.push( multiplicacion(num1,num2));
                            System.out.println("Ingresando al array"+(Object) x.peek());

                            break;
                        case '/':
                            System.out.println("Se diviran "+num1+" / "+num2);
                            x.push((char) division(num1,num2));
                            System.out.println("Ingresando al array"+(Object) x.peek());

                            break;
                    
                        default:
                            break;
                    }
                numeros[0] = "P";
                numeros[1] = "P";

                }
            }else{
                numero =Integer.parseInt(x.pop().toString());   
            }
        }
        return numero;
    }
    /**
     * @param a archivo de operaciones 
     */
    public String decode(String a){
        String operaciones="";
        File archivo=new File(a);
        String cadena="";
        FileReader fr;
        BufferedReader bf;
        try{
            fr=new FileReader(archivo);
            bf=new BufferedReader(fr);
            while(cadena!=null)
            {
                cadena=bf.readLine();
                if(cadena!=null)
                {
                    operaciones += cadena+"\n";
                }
            }
            bf.close();
            fr.close();
            return operaciones;
        }catch(Exception e){
            return e.toString();
        } 
    }
}