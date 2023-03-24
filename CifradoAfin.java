package Cifrados;

public class CifradoAfin {

    public static void main(String[] args) {
        char[] abecedario = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String cadena = "";
        int desplazamiento = 15;
        int inverso = 11;
        boolean opcion = false; // false descifrar || true cifrar

        cadena = cadena.toUpperCase();
        cadena = cadena.replaceAll(" ", "");
        char[] arrayCadena = cadena.toCharArray();

        if (opcion) {

            System.out.println("M = " + cadena);
            System.out.println("D = " + desplazamiento);
            System.out.println("Decimacion = " + inverso);
            for (int i = 0; i < arrayCadena.length; i++) {

                arrayCadena[i] = abecedario[modulo(
                        inverso * encotrarPosicionLetraEnAbecedario(arrayCadena[i], abecedario) + desplazamiento)];

                System.out
                        .println("M" + i + " = " + inverso + " * " + (char) cadena.charAt(i) + " + " + desplazamiento
                                + " mod(27)" + " = " + inverso + " * " +
                                encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario) + " + "
                                + desplazamiento + " mod(27) = "
                                + ((inverso * encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario))
                                        + desplazamiento)
                                + " mod(27) = "
                                + modulo(((inverso
                                        * encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario))
                                        + desplazamiento))
                                + " = " + (char) arrayCadena[i]);
            }

        } else {

            System.out.println("C = " + cadena);
            System.out.println("B = " + desplazamiento);
            System.out.println("A^-1 = " + inverso);

            for (int i = 0; i < arrayCadena.length; i++) {

                arrayCadena[i] = abecedario[modulo(
                        inverso * (encotrarPosicionLetraEnAbecedario(arrayCadena[i], abecedario) - desplazamiento))];

                System.out.println("M" + i + " = " + inverso + "* ( " + (char) cadena.charAt(i) + "-" + desplazamiento
                        + " ) mod(27)" + " = " + inverso + "* ( " +
                        encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario) + "-"
                        + desplazamiento + " ) mod(27) = "
                        + (inverso * (encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario)
                                - desplazamiento))
                        + " mod(27) = "
                        + modulo((inverso * (encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario)
                                - desplazamiento)))
                        + " = " + (char) arrayCadena[i]);

            }
        }

        System.out.println("Resultado: " + new String(arrayCadena));
    }

    public static int encotrarPosicionLetraEnAbecedario(char letra, char[] abecedario) {
        int posicion = 0;

        for (int i = 0; i < abecedario.length; i++) {
            if (letra == abecedario[i]) {
                posicion = i;
                return posicion;
            }
        }

        return -1;
    }

    public static int modulo(int posicion) {
        while (posicion > 26) {
            posicion = posicion - 27;
        }
        while (posicion < 0) {
            posicion = posicion + 27;
        }

        return posicion;
    }
}
