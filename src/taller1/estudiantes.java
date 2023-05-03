package taller1;

import javax.swing.JOptionPane;

public class estudiantes {

	private static String[] nombres = new String[100];
	private static int[] edades = new int[100];
	private static int numEstudiantes = 0;

	public static void main(String[] args) {
		int opc = 0;
		do {
			opc = mostrarMenu();
			switch (opc) {
			case 1:
				añadirEstudiante();
				break;
			case 2:
				imprimirListaEstudiantes();
				break;
			case 3:
				calcularPromedioEdades();
				break;
			case 4:
				encontrarEstudiantesMayorEdad();
				break;
			case 5:
				encontrarEstudiantesMenorEdad();
				break;
			case 6:
				EstudiantesMayoresEdad();
				break;
			case 7:
				buscarEstudiantePorNombre();
				break;
			case 8:
				buscarEstudiantesPorEdad();
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Good Bye");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opci�n incorrecta.");
			}
		} while (opc != 9);
	}

	private static int mostrarMenu() {
		String menu = "Seleccione una opci�n:\n\n" + "1. Agregar estudiante\n" + "2. Imprimir lista de estudiantes\n"
				+ "3. promedio de edades\n" + "4. estudiantes de mayor edad\n"
				+ "5. estudiantes de menor edad\n" + "6. Cantidad estudiantes mayores de edad\n"
				+ "7. Buscar estudiante por nombre\n" + "8. Buscar estudiantes por edad\n" + "9. Salir";
		String opc = JOptionPane.showInputDialog(null, menu);
		return Integer.parseInt(opc);
	}

	private static void añadirEstudiante() {
		String nombre = JOptionPane.showInputDialog(null, "Nombre del estudiante:");
		int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad del estudiante:"));
		nombres[numEstudiantes] = nombre;
		edades[numEstudiantes] = edad;
		numEstudiantes++;
	}

	private static void imprimirListaEstudiantes() {
		String lista = "Lista de estudiantes:\n\n";
		for (int i = 0; i < numEstudiantes; i++) {
			lista += nombres[i] + " - " + edades[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, lista);
	}

	private static void calcularPromedioEdades() {
		int sumaEdades = 0;
		for (int i = 0; i < numEstudiantes; i++) {
			sumaEdades += edades[i];
		}
		double promedio = (double) sumaEdades / numEstudiantes;
		JOptionPane.showMessageDialog(null, "El promedio de edades es: " + promedio);
	}

	

	private static void encontrarEstudiantesMenorEdad() {
		int minEdad = Integer.MAX_VALUE;
		for (int i = 0; i < numEstudiantes; i++) {
			if (edades[i] < minEdad) {
				minEdad = edades[i];
			}
		}
		String estudiantes = "menores edad:\n\n";
		for (int i = 0; i < numEstudiantes; i++) {
			if (edades[i] == minEdad) {
				estudiantes += nombres[i] + " - " + edades[i] + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, estudiantes);
	}

	private static void encontrarEstudiantesMayorEdad() {
		int maxEdad = Integer.MIN_VALUE;
		for (int i = 0; i < numEstudiantes; i++) {
			if (edades[i] > maxEdad) {
				maxEdad = edades[i];
			}
		}
		String estudiantes = "Estudiantes de mayor edad:\n\n";
		for (int i = 0; i < numEstudiantes; i++) {
			if (edades[i] == maxEdad) {
				estudiantes += nombres[i] + " - " + edades[i] + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, estudiantes);
	}
	
	private static void EstudiantesMayoresEdad() {
		int contador = 0;
		for (int i = 0; i < numEstudiantes; i++) {
			if (edades[i] >= 18) {
				contador++;
			}
		}
		JOptionPane.showMessageDialog(null, "Hay " + contador + " mayores de edad.");
	}

	private static void buscarEstudiantePorNombre() {
		String nombre = JOptionPane.showInputDialog(null, "nombre del estudiante a buscar:");
		int indice = -1;
		for (int i = 0; i < numEstudiantes; i++) {
			if (nombres[i].equalsIgnoreCase(nombre)) {
				indice = i;
				break;
			}
		}
		if (indice == -1) {
			JOptionPane.showMessageDialog(null, "No se encontr� ning�n estudiante con ese nombre.");
		} else {
			JOptionPane.showMessageDialog(null,
					"El estudiante encontrado es: " + nombres[indice] + " - " + edades[indice]);
		}
	}

	private static void buscarEstudiantesPorEdad() {
		int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad de los estudiantes a buscar:"));
		String estudiantes = "Estudiantes con edad " + edad + ":\n\n";

		for (int i = 0; i < numEstudiantes; i++) {
			if (edades[i] == edad) {
				estudiantes += nombres[i] + " - " + edades[i] + "\n";

			}
		}
		JOptionPane.showMessageDialog(null, estudiantes);
	}
}