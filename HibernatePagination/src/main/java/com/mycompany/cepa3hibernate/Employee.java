package com.mycompany.cepa3hibernate;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "salario")
    private double salario;

    @Column(name = "departamento")
    private String departamento;


    public Empleado() {

    }

    public Empleado(String primerNombre, String apellido, double salario, String departamento) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.salario = salario;
        this.departamento = departamento;
    }

    // Métodos getter y setter para todos los campos

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "empNo=" + empNo +
                ", primerNombre='" + primerNombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                // Incluir otros campos según sea necesario
                '}';
    }
}

