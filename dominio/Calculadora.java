package dominio; 

import java.security.DigestException;

import excepciones.*;
import interfaces.Errores;

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
		numMemoria = "";
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
	
	public double dividir() throws DivisionPorCeroException {
		if (this.num2 == 0) throw new DivisionPorCeroException();
		return this.num1 / this.num2;
	}
	
	public void porcentaje() {
		this.setNum2((Double.valueOf(numActual) / 100) * num1);
	}
	
	public double raiz (String num) throws RaizNegativaException {
		return raiz(Double.valueOf(num));
	}
	
	public double raiz(double num) throws RaizNegativaException {
		if (num < 0) throw new RaizNegativaException();
		return Math.sqrt(num);
	}
	
	public double inversa() throws DivisionPorCeroException {
		
		if (num1 == 0 && numActual.equals("-")) return -1;
		
		if (num1 != 0) {
			
			if (numActual.equals("0")) 
				return 1 / num1;
			else 
				return 1 / Double.valueOf(numActual);
			
		}
		else {
			
			if (!numActual.equals("0")) 
				return 1 / Double.valueOf(numActual);
			else 
				throw new DivisionPorCeroException();
		}
		
	}
	
	// CAMBIAR SIGNO
	public void cambiarSigno() {
		// Si contiene el signo "-" -> eliminarlo
		// sino -> agregar signo "-"
		if (numActual.contains("-")) 
			numActual = numActual.replace("-", "");
		else 
			numActual = "-".concat(numActual);
	}
	
	// RESETEAR TODAS LAS VARIABLES
	public void reset() {
		num1 = num2 = 0;
		operacion = "";
		numActual = "0";
		mostrar   = false;
	}
	
	// CONCATENAR NUMERO AL NUMERO ACTUAL
	public void concatenar(String num) { 
		this.numActual += num; 
	}
	
	public void retroceder() {
		numActual = numActual.substring(0, numActual.length()-1);
	}
	
	public double sumarMemoria() {
		
		if (num1 != 0) {
			return Double.valueOf(numMemoria) + num1;
		}
		else if (!numActual.equals("-")) 
			return Double.valueOf(numMemoria) + Double.valueOf(numActual);
		
		return 0;
	}
	
	public double restarMemoria() {
		
		if (num1 != 0) {
			return Double.valueOf(numMemoria) - num1;
		}
		else if (!numActual.equals("-")) 
			return Double.valueOf(numMemoria) - Double.valueOf(numActual);
		
		return 0;
	}
	
	
	// CALCULAR OPERACIONES
	public double calcular() throws DivisionPorCeroException {
		
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
