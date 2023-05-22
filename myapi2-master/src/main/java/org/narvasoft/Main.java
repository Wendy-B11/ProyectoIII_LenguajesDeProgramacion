package org.narvasoft;
//Importamos las librería necesarias
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller.Server;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String opcion;
        //Menú
        while (true) {
            System.out.println("1. Leer usuarios existentes.");
            System.out.println("2. Encontrar usuario.");
            System.out.println("3. Crear un usuario.");
            System.out.println("4. Editar la información de un usuario existente.");
            System.out.println("5. Eliminar un usuario");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción -> ");
            opcion = input.next();

            //Leer usuarios existentes
            if (opcion.equals("1")) {
                String url, header, body, metodo;
                boolean cumple;
                do{
                    System.out.print("Ingrese el metodo -> ");
                    metodo=input.next().toUpperCase();
                    if(!metodo.equals("GET")){
                        System.out.println("405 Method Not Allowed - Método no válido para leer usuarios existentes");
                    }
                }while(!metodo.equals("GET"));
                do {
                    System.out.print("Ingrese el url -> ");
                    url = input.next();
                    cumple = procesarUrl(url);
                } while (cumple != true);
                do {
                    System.out.print("Ingrese el header -> ");
                    header = input2.nextLine();
                    cumple = procesarHeader(header);
                } while (cumple != true);
                int state = 2;
                do {
                    System.out.print("Ingrese el body (Opcional, sino ingrese 'a') -> ");
                    body = input.next();
                    cumple = validarCorreo(body,state);
                } while (cumple != true);
                System.out.println("\nBuscando usuarios existentes...\n");
                esperar();
                System.out.println("---------------------------------------------------");
                Server request = new Server(metodo, url, header, body);
                System.out.println(request);//respuesta del servidor
                System.out.println("---------------------------------------------------\n");

            //Encontrar usuario
            } else if (opcion.equals("2")) {
                String url, header, body,metodo;
                boolean cumple;
                do{
                    System.out.print("Ingrese el metodo -> ");
                    metodo=input.next().toUpperCase();
                    if(!metodo.equals("GET")){
                        System.out.println("405 Method Not Allowed - Método no válido para leer usuarios existentes");
                    }
                }while(!metodo.equals("GET"));
                do {
                    System.out.print("Ingrese el url -> ");
                    url = input.next();
                    cumple = procesarUrl(url);
                } while (cumple != true);
                do {
                    System.out.print("Ingrese el header -> ");
                    header = input2.nextLine();
                    cumple = procesarHeader(header);
                } while (cumple != true);
                int state = 2;
                do {
                    System.out.print("Ingrese el body (Opcional, sino ingrese 'a') -> ");
                    body = input.next();
                    cumple = validarCorreo(body,state);
                } while (cumple != true);
                System.out.print("Ingrese el ID -> ");
                int id = input.nextInt();
                System.out.println("\nRealizando consulta de usuario...\n");
                esperar();
                System.out.println("---------------------------------------------------");
                Server request = new Server(metodo, url, header, body, id);
                System.out.println("---------------------------------------------------\n");

            //Crear usuario
            } else if (opcion.equals("3")) {
                String url, header, body, metodo;
                boolean cumple;
                do{
                    System.out.print("Ingrese el metodo -> ");
                    metodo=input.next().toUpperCase();
                    if(!metodo.equals("POST")){
                        System.out.println("405 Method Not Allowed - Método no válido para crear usuario");
                    }
                }while(!metodo.equals("POST"));
                do {
                    System.out.print("Ingrese el url -> ");
                    url = input.next();
                    cumple = procesarUrl(url);
                } while (cumple != true);
                do {
                    System.out.print("Ingrese el header -> ");
                    header = input2.nextLine();
                    cumple = procesarHeader(header);
                } while (cumple != true);
                int state = 0;
                do {
                    System.out.print("Ingrese el body (Obligatorio) -> ");
                    body = input.next();
                    cumple = validarCorreo(body,state);
                } while (cumple != true);
                System.out.println("\nCreando usuario...\n");
                esperar();
                System.out.println("---------------------------------------------------");
                Server request = new Server(metodo, url, header, body);
                System.out.println("---------------------------------------------------\n");

            //Editar usuario
            } else if (opcion.equals("4")) {
                String url, header, body,metodo;
                boolean cumple;
                do{
                    System.out.print("Ingrese el metodo -> ");
                    metodo=input.next().toUpperCase();
                    if(!metodo.equals("PUT")){
                        System.out.println("405 Method Not Allowed - Método no válido para actualizar usuario");
                    }
                }while(!metodo.equals("PUT"));
                do {
                    System.out.print("Ingrese el url -> ");
                    url = input.next();
                    cumple = procesarUrl(url);
                } while (cumple != true);
                do {
                    System.out.print("Ingrese el header -> ");
                    header = input2.nextLine();
                    cumple = procesarHeader(header);
                } while (cumple != true);
                int state = 0;
                do {
                    System.out.print("Ingrese el body (Obligatorio) -> ");
                    body = input.next();
                    cumple = validarCorreo(body,state);
                } while (cumple != true);
                System.out.print("Ingrese el id del usuario a actualizar: ");
                int id=input.nextInt();
                System.out.println("\nActualizando información del usuario...\n");
                esperar();
                System.out.println("---------------------------------------------------");
                Server request = new Server(metodo, url, header, body, id);
                System.out.println(request);//respuesta del servidor
                System.out.println("---------------------------------------------------\n");

            //Eliminar usuario
            } else if (opcion.equals("5")) {
                String url, header, body,metodo;
                boolean cumple;
                do{
                    System.out.print("Ingrese el metodo -> ");
                    metodo=input.next().toUpperCase();
                    if(!metodo.equals("DELETE")){
                        System.out.println("405 Method Not Allowed - Método no válido para crear usuario");
                    }
                }while(!metodo.equals("DELETE"));
                do {
                    System.out.print("Ingrese el url -> ");
                    url = input.next();
                    cumple = procesarUrl(url);
                } while (cumple != true);
                do {
                    System.out.print("Ingrese el header -> ");
                    header = input2.nextLine();
                    cumple = procesarHeader(header);
                } while (cumple != true);
                int state = 2;
                do {
                    System.out.print("Ingrese el body (Opcional, sino ingrese 'a') -> ");
                    body = input.next();
                    cumple = validarCorreo(body,state);
                } while (cumple != true);
                System.out.print("Ingrese el id del usuario a eliminar: ");
                int id=input.nextInt();
                System.out.println("\nEliminando usuario...\n");
                esperar();
                System.out.println("---------------------------------------------------");
                Server request = new Server(metodo, url, header, body, id);
                System.out.println("---------------------------------------------------\n");
            } else if (opcion.equals("6")) {
                System.out.println("\nSaliendo del programa...\n");
                esperar();
                System.out.println("---------------------------------------------------");
                System.out.println("\nGracias por usar!!\n");
                System.out.println("---------------------------------------------------\n");
                break;
            } else {
                System.out.println("---------------------------------------------------");
                System.out.println("\n404 Not Found - Opción inválida\n");
                System.out.println("---------------------------------------------------\n");
            }
        }
    }

    //Procesamos la url
    public static boolean procesarUrl(String url) {
        boolean cumple = false;
        //Podemos usar como expresión regular la url estándar porque debe ser exactamente igual
        String regex = "^http://localhost:8080/api/users$";
        if (url.matches(regex)) {
            System.out.println("La URL es válida.");
            cumple = true;
        } else {
            if (!url.startsWith("http://")) {
                System.out.println("404 Not Found - El protocolo debe ser http://.");
            } else if (!url.contains("localhost")) {
                System.out.println("404 Not Found - El servidor debe ser localhost.");
            } else if (!url.endsWith("/api/users")) {
                System.out.println("404 Not Found - El recurso debe ser /api/users.");
            } else if (!url.contains("8080")) {
                System.out.println("404 Not Found - El puerto debe ser 8080.");
            }else{
                System.out.println("404 Not Found");
            }
        }

        return cumple;
    }

    //Time out
    public static void esperar() {
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(1 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Validar body/correo

    public static boolean validarCorreo(String body, int state) {
        if (state==2 && body.equals("a")){
            return true;
        }else{
            boolean correocum = false;
            String[] partes = body.split(",");
            if (partes.length != 3) {
                System.out.println("400 Bad Request - Faltan datos en el body (nombre, correo, número).");
                return correocum;
            }
            String correo = partes[1];
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            if (!correo.matches(regex)) {
                System.out.println("400 Bad Request - El correo electrónico no es válido.");
                return correocum;
            }
            System.out.println("El correo electrónico es válido.");
            correocum = true;
            return correocum;
        }
    }

    //Procesar header
    public static boolean procesarHeader(String header) {
        String regex = "^(?<nombre>[^:]+):\\s+(?<valor>.+)$";
        boolean headercum = false;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(header);
        if (matcher.matches()) {
            headercum = true;
        } else {
            System.out.println("404 Not Found - Header inválido.");
        }
        return headercum;
    }
}
