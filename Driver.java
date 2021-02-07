/**
 * @author Mariana David 201055
 * @version 1.0.1
 */
public class Driver{
    /**
     * @param message mensaje a imprimir rapido (sin mucho codigo)
     
     */
    public static void print(String message){
        System.out.println(message);
    }
     /**
     * @param message mensaje a imprimir rapido (sin mucho codigo)
     */
    public static void print(char message){
        System.out.println(message);
    }
     /**
     * @param args  parametros antes de la ejecucion y son escritos por el usuario
     * Inicia ciclo
     */
    public static void main(String[] args){
        Operaciones vector = new Operaciones();
        String operaciones = vector.decode("operaciones.txt");
        String[] lineas = operaciones.split("\n");
        StackArrayList stack = new StackArrayList();
        int cont = 0;
        for(String linea : lineas){
            
            stack = new StackArrayList();
            for(int i = 0; i < linea.length();i++){
                if(linea.charAt(i)!= ' '){
                    stack.push(linea.charAt(i));
                    print(linea.charAt(i));
                }
            }
            StackArrayList stack2 = new StackArrayList();
            for(int i = stack.size(); i>0; i--){
                stack2.push(stack.pop());
            }
           print("La respuesta del numero de  linea "+(++cont)+" es: "+ vector.operar(stack2));
        }
    }
   
}