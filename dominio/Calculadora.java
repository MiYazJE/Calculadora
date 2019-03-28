package dominio;

import excepciones.*;

public class Calculadora {

	// ATRIBUTOS
	private double num1;
	private double num2;
	
	private String operacion;
	private String numActual;
	private String numMemoria;
	
	boolean mostrar;
	
	// CONSTRUCTOR
	public Calculadora() {
		reset();
	}

	// GETTERS AND SETTERS
	public double getNum1() {
		return num1;
	}

	public void setNum1(double num) {
		this.num1 = num;
	}
	
	public boolean getMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}
	
	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getNumActual() {
		return numActual;
	}

	public void setNumActual(String numActual) {
		this.numActual = numActual;
	}

	public String getNumMemoria() {
		return numMemoria;
	}

	public void setNumMemoria(String numMemoria) {
		this.numMemoria = numMemoria;
	}
	
	// OPERACIONES ARITMETICAS
	public double sumar() {
		return this.num1 + this.num2;
	}
	
	public double restar() {
		return this.num1 - this.num2;
	}
	
	public double multiplicar() {
		return this.num1 * this.num2;
	}
	
	public double dividir() throws DivisionPorCeroExcepcion {
		if (this.num2 == 0) throw new DivisionPorCeroExcepcion();
		return this.num1 / this.num2;
	}
	
	public void porcentaje() {
		
	}
	
	public double raiz() {
		return 0;
	}
	
	public double inversa() throws DivisionPorCeroExcepcion {
		return 0;
	}
	
	// CAMBIAR SIGNO
	public void cambiarSigno() {
		
	}
	
	// RESETEAR TODAS LAS VARIABLES
	public void reset() {
		num1 = num2 = 0;
		operacion = numMemoria = "";
		numActual = "0";
		mostrar = false;
	}
	
	// CONCATENAR NUMERO AL NUMERO ACTUAL
	public void concatenar(String num) { 
		this.numActual += num; 
	}
	
	public void retroceder() {
		numActual = numActual.substring(0, numActual.length()-1);
	}
	
	public void sumarMemoria() {
		
	}
	
	public void restarMemoria() {
		
	}
	
	
	// CALCULAR OPERACIONES
	public double calcular() throws DivisionPorCeroExcepcion {
		
		switch (this.operacion) {
		case "+": return sumar();
		case "*": return multiplicar();
		case "/": return dividir();
		case "-": return restar();
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return "num1 = " + num1 + "\nnum2 = " + num2 + "\noperacion = " + operacion + "\nnumActual = " + numActual
				+ "\nnumMemoria = " + numMemoria;
	}
	
	
	
	
	
	
}