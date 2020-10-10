/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorearmapa;

/**
 *
 * @author diego
 */
import java.util.*; 
import java.util.LinkedList;
public class ColorearMapa {

    private int V;   // Numero de Vertices
    private LinkedList<Integer> adj[]; //Lista para vertices adyacentes
  
    void colorear() { 
        int[] resultado = new int[V]; 
        int max = 4;  //0 - 4 en el arreglo
  
        // Se inicializan los vertices sin ningun color
        Arrays.fill(resultado, -1); 
        // Se asigna color al estado inicial
        resultado[0]  = 0; 
        //Arreglo para guardar los colores disponibles para los estados adyacentes
        boolean[] disponible = new boolean[V];  
        // Se inicializa el arreglo con todos los colores disponibles para el siguiente estado
        Arrays.fill(disponible, true); 
        
        // Se asignan los colores a los estados adyacentes restantes
        for (int u = 1; u < V; u++){ 
            //Marca colores a todos los estados adyacentes y se marcan como no disponibles
            Iterator<Integer> it = adj[u].iterator(); 
            while (it.hasNext()) { 
                int i = it.next(); 
                if (resultado[i] != -1 && resultado[i] <= max) 
                    disponible[resultado[i]] = false; 
            } 
  
            // Se busca un color disponible
            int colr; 
            for (colr = 0; colr < V; colr++){ 
                if (disponible[colr]) 
                    break; 
            }
  
            //Asignar el color disponible
            resultado[u] = colr; 
            // Resetae los colores disponibles para el siguiente ciclo
            Arrays.fill(disponible, true); 
        }
  
        // Imprimir el resultado
        for (int u = 0; u < V; u++) 
            System.out.println(elegirEstado(u) + " ---> " + elegirColor(resultado[u])); 
    } 
    
    String elegirColor(int color){
        switch(color){
            case 0:
                return "Azul";
            case 1:
                return "Rojo";
            case 2:
                return "Amarillo";
            case 3:
                return "Rosa";
            case 4:
                return "Morado";
            default:
                return "";
        }
    }
    
    String elegirEstado(int estado){
        switch(estado){
            case 0:
                return "Nuevo Leon";
            case 1:
                return "Tamaulipas";
            case 2:
                return "Coahuila";
            case 3:
                return "Zacatecas";
            case 4:
                return "San Luis Potosi";
            case 5:
                return "Durango";
            case 6:
                return "Guanajuato";
            case 7:
                return "Baja California";
            case 8:
                return "Baja California Sur";
            case 9:
                return "Sonora";
            case 10:
                return "Chihuahua";
            case 11:
                return "Sinaloa";
            case 12:
                return "Nayarit";
            case 13:
                return "Jalisco";
            case 14:
                return "Aguascalientes";
            case 15:
                return "Michoacan";
            case 16:
                return "Colima";
            case 17:
                return "Queretaro";
            case 18:
                return "Estado de Mexico";
            case 19:
                return "Guerrero";
            case 20:
                return "Hidalgo";
            case 21:
                return "Tlaxcala";
            case 22:
                return "CDMX";
            case 23:
                return "Morelos";
            case 24:
                return "Puebla";
            case 25:
                return "Oaxaca";
            case 26:
                return "Veracruz";
            case 27:
                return "Chiapas";
            case 28:
                return "Tabasco";
            case 29:
                return "Campeche";
            case 30:
                return "Yucatan";
            case 31:
                return "Quintana Roo";
            default:
                return "";
        }
    }
    
        
    ColorearMapa(int v) { 
        V = v;      
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Agregar Conexiones al grafo
    void Conectar(int v,int w) { 
        adj[v].add(w);     //Se añade la conexion
    } 
    
    public static void main(String[] args) {
        //Creacion del grafo y sus conexiones
        ColorearMapa grafo = new ColorearMapa(32); 
        //0 Nuevo Leon
        grafo.Conectar(0, 1);   
        grafo.Conectar(0, 2);
        grafo.Conectar(0, 3);
        grafo.Conectar(0, 4);
        //1 Tamaulipas
        grafo.Conectar(1, 0);   
        grafo.Conectar(1, 4); 
        grafo.Conectar(1, 26);
        // 2 Coahuila
        grafo.Conectar(2, 0);   
        grafo.Conectar(2, 3);
        grafo.Conectar(2, 4);
        grafo.Conectar(2, 5);
        grafo.Conectar(2, 10);
        //3 Zacatecas
        grafo.Conectar(3, 0);   
        grafo.Conectar(3, 2);
        grafo.Conectar(3, 4);
        grafo.Conectar(3, 5);
        grafo.Conectar(3, 6);
        grafo.Conectar(3, 12);
        grafo.Conectar(3, 13);
        //4 SLP
        grafo.Conectar(4, 0);   
        grafo.Conectar(4, 1);
        grafo.Conectar(4, 2);
        grafo.Conectar(4, 3);
        grafo.Conectar(4, 6);
        grafo.Conectar(4, 14);
        grafo.Conectar(4, 26);
        grafo.Conectar(4, 17);
        grafo.Conectar(4, 20);
        //5 Durango
        grafo.Conectar(5, 2);   
        grafo.Conectar(5, 3);
        grafo.Conectar(5, 10);
        grafo.Conectar(5, 11);
        grafo.Conectar(5, 12);
        //6 Guanajuato
        grafo.Conectar(6, 3);   
        grafo.Conectar(6, 4);
        grafo.Conectar(6, 13);
        grafo.Conectar(6, 15);
        grafo.Conectar(6, 17);
        //7 Baja California
        grafo.Conectar(7, 8);
        grafo.Conectar(7, 9);
        //8 Baja California Sur
        grafo.Conectar(8, 7);
        //9 Sonora
        grafo.Conectar(9, 7);
        grafo.Conectar(9, 10);
        grafo.Conectar(9, 11);
        //10 Chihuahua
        grafo.Conectar(10, 9);
        grafo.Conectar(10, 11);
        grafo.Conectar(10, 5);
        grafo.Conectar(10, 2);
        //11 Sinaloa
        grafo.Conectar(11, 9);
        grafo.Conectar(11, 10);
        grafo.Conectar(11, 5);
        grafo.Conectar(11, 12);
        //12 Nayarit
        grafo.Conectar(12, 11);
        grafo.Conectar(12, 13);
        grafo.Conectar(12, 5);
        grafo.Conectar(12, 3);
        //13 Jalisco
        grafo.Conectar(13, 12);
        grafo.Conectar(13, 3);
        grafo.Conectar(13, 14);
        grafo.Conectar(13, 6);
        grafo.Conectar(13, 15);
        grafo.Conectar(13, 16);
        grafo.Conectar(13, 4);
        //14 Aguascalientes
        grafo.Conectar(14, 3);
        grafo.Conectar(14, 13);
        //15 Michoacan
        grafo.Conectar(15, 13);
        grafo.Conectar(15, 16);
        grafo.Conectar(15, 6);
        grafo.Conectar(15, 17);
        grafo.Conectar(15, 18);
        grafo.Conectar(15, 19);
        //16 Colima
        grafo.Conectar(16, 13);
        grafo.Conectar(16, 15);
        //17 Queretaro
        grafo.Conectar(17, 15);
        grafo.Conectar(17, 6);
        grafo.Conectar(17, 4);
        grafo.Conectar(17, 20);
        grafo.Conectar(17, 18);
        //18 Estado Mexico
        grafo.Conectar(18, 19);
        grafo.Conectar(18, 15);
        grafo.Conectar(18, 17);
        grafo.Conectar(18, 20);
        grafo.Conectar(18, 21);
        grafo.Conectar(18, 22);
        grafo.Conectar(18, 23);
        grafo.Conectar(18, 24);
        //19 Guerrero
        grafo.Conectar(19, 15);
        grafo.Conectar(19, 18);
        grafo.Conectar(19, 23);
        grafo.Conectar(19, 24);
        grafo.Conectar(19, 25);
        //20 Hidalgo
        grafo.Conectar(20, 18);
        grafo.Conectar(20, 17);
        grafo.Conectar(20, 4);
        grafo.Conectar(20, 26);
        grafo.Conectar(20, 21);
        grafo.Conectar(20, 24);
        //21 Tlaxcala
        grafo.Conectar(21, 18);
        grafo.Conectar(21, 20);
        grafo.Conectar(21, 24);
        //22 CDMX
        grafo.Conectar(22, 18);
        grafo.Conectar(22, 23);
        //23 Morelos
        grafo.Conectar(23, 18);
        grafo.Conectar(23, 22);
        grafo.Conectar(23, 24);
        grafo.Conectar(23, 19);
        //24 Puebla
        grafo.Conectar(24, 21);
        grafo.Conectar(24, 18);
        grafo.Conectar(24, 23);
        grafo.Conectar(24, 19);
        grafo.Conectar(24, 26);
        grafo.Conectar(24, 25);
        grafo.Conectar(24, 20);
        //25 Oaxaca
        grafo.Conectar(25, 19);
        grafo.Conectar(25, 24);
        grafo.Conectar(25, 26);
        grafo.Conectar(25, 27);
        //26 Veracruz
        grafo.Conectar(26, 1);
        grafo.Conectar(26, 4);
        grafo.Conectar(26, 20);
        grafo.Conectar(26, 24);
        grafo.Conectar(26, 25);
        grafo.Conectar(26, 27);
        grafo.Conectar(26, 28);
        //27 Chiapas
        grafo.Conectar(27, 25);
        grafo.Conectar(27, 26);
        grafo.Conectar(27, 28);
        //28 Tabasco
        grafo.Conectar(28, 27);
        grafo.Conectar(28, 26);
        grafo.Conectar(28, 29);
        //29 Campeche
        grafo.Conectar(29, 28);
        grafo.Conectar(29, 30);
        grafo.Conectar(29, 31);
        //30 Yucatan
        grafo.Conectar(30, 29);
        grafo.Conectar(30, 31);
        //31 Quintana Roo
        grafo.Conectar(31, 30);
        grafo.Conectar(31, 29);
        System.out.println("Solucion: "); 
        grafo.colorear(); 
    }
    
}
