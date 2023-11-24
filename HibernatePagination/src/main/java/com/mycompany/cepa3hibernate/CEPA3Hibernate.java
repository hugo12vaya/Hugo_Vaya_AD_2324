package com.mycompany.cepa3hibernate;

import java.util.List;
import java.util.Scanner;

public class CEPA3Hibernate {

    private static final int PAGE_SIZE = 12;
    private static final EmployeeDAO employeeDAO = new EmployeeDAO(); // Suponiendo que tienes una clase EmployeeDAO para manejar la capa de acceso a datos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentPage = 1;

        while (true) {
            List<Employee> employees = employeeDAO.getEmployees(currentPage, PAGE_SIZE);
            int totalEmployees = employeeDAO.getTotalEmployees(); // Obtener el número total de empleados desde tu base de datos

            System.out.println("Página " + currentPage + " de " + calculateTotalPages(totalEmployees, PAGE_SIZE));

            if (employees != null) {
                displayEmployees(employees);
            }

            System.out.println("Opciones: <S> siguiente, <A> anterior, <G n> Ir a n, <Q> salir");
            String input = scanner.nextLine();

            switch (input.toUpperCase()) {
                case "S":
                    currentPage++;
                    break;
                case "A":
                    if (currentPage > 1) {
                        currentPage--;
                    }
                    break;
                case "Q":
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                default:
                    if (input.toUpperCase().startsWith("G ")) {
                        try {
                            int targetPage = Integer.parseInt(input.substring(2).trim());
                            if (targetPage > 0 && targetPage <= calculateTotalPages(totalEmployees, PAGE_SIZE)) {
                                currentPage = targetPage;
                            } else {
                                System.out.println("Número de página inválido.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida para el número de página.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Inténtelo de nuevo.");
                    }
            }
        }
    }

    private static void displayEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int calculateTotalPages(int totalEmployees, int pageSize) {
        if (totalEmployees <= 0 || pageSize <= 0) {
            return 0; // No hay empleados o tamaño de página inválido
        }

        return (int) Math.ceil((double) totalEmployees / pageSize);
    }
}

