package interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import dominio.Calculadora;
import excepciones.DivisionPorCeroExcepcion;

import javax.swing.GroupLayout.Alignment;

public class MenuPpal extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textResultado;
	private static Calculadora calculadora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/imagenCalculadora.png"));
					MenuPpal frame = new MenuPpal();
					frame.setVisible(true);
					frame.setIconImage(img.getImage());
					calculadora = new Calculadora();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MenuPpal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TAMANYO
		setBounds(100, 100, 354, 482);
		
		// VENTANA ESTATICA
		setResizable(false);
		
		// TITULO
		setTitle("Calculadora 2.0");
		
		// MENU 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivos = new JMenu("Archivo");
		menuBar.add(mnArchivos);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnArchivos.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnArchivos.add(mntmAbrir);
		
		JSeparator separator = new JSeparator();
		mnArchivos.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivos.add(mntmSalir);
		
		JMenu mnEdición = new JMenu("Edici\u00F3n");
		menuBar.add(mnEdición);
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mnEdición.add(mntmCopiar);
		
		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mnEdición.add(mntmPegar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmManualDeAyuda = new JMenuItem("Manual de ayuda");
		mnAyuda.add(mntmManualDeAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mnAyuda.add(mntmAcercaDe);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 5, 10, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// PANEL TOP
		JPanel panel_Top = new JPanel();
		panel_Top.setForeground(new Color(204, 204, 204));
		contentPane.add(panel_Top, BorderLayout.NORTH); 
		
		textResultado = new JTextField();
		textResultado.setForeground(new Color(0, 0, 0));
		textResultado.setEditable(false);
		textResultado.setDropMode(DropMode.INSERT);
		textResultado.setBackground(Color.WHITE);
		textResultado.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		textResultado.setFont(new Font("Arial", Font.PLAIN, 15));
		textResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		textResultado.setText("0");
		textResultado.setColumns(10);
		GroupLayout gl_panel_Top = new GroupLayout(panel_Top);
		gl_panel_Top.setHorizontalGroup(
			gl_panel_Top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Top.createSequentialGroup()
					.addGap(26)
					.addComponent(textResultado, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_panel_Top.setVerticalGroup(
			gl_panel_Top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Top.createSequentialGroup()
					.addContainerGap()
					.addComponent(textResultado, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
		);
		panel_Top.setLayout(gl_panel_Top);
		
		
		// PANEL BOT
		JPanel panel_Bot = new JPanel();
		contentPane.add(panel_Bot, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Fecha de entrega: 1 de abril");
		panel_Bot.add(lblNewLabel);
		
		
		// PANEL CENTRO
		JPanel panel_Centro = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_Centro.getLayout();
		flowLayout.setVgap(40);
		flowLayout.setHgap(40);
		panel_Centro.setBounds(0, 0, 50, 50);
		contentPane.add(panel_Centro, BorderLayout.CENTER);
		
		JPanel panel_Centro_Centro = new JPanel();
		panel_Centro_Centro.setForeground(Color.BLACK);
		panel_Centro.add(panel_Centro_Centro);
		GridBagLayout gbl_panel_Centro_Centro = new GridBagLayout();
		gbl_panel_Centro_Centro.rowHeights = new int[] {40, 40, 40, 40, 40, 40};
		gbl_panel_Centro_Centro.columnWidths = new int[] {55, 55, 55, 55, 55};
		gbl_panel_Centro_Centro.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_Centro_Centro.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_Centro_Centro.setLayout(gbl_panel_Centro_Centro);
		
		Boton button_MemoryClear = new Boton("MC");
		GridBagConstraints gbc_button_MemoryClear = new GridBagConstraints();	
		gbc_button_MemoryClear.anchor = GridBagConstraints.NORTH;
		gbc_button_MemoryClear.insets = new Insets(0, 0, 5, 5);
		gbc_button_MemoryClear.gridx = 0;
		gbc_button_MemoryClear.gridy = 0;
		gbc_button_MemoryClear.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_MemoryClear, gbc_button_MemoryClear);
		
		Boton button_MemoryRecall = new Boton("MR");
		GridBagConstraints gbc_button_MemoryRecall = new GridBagConstraints();
		gbc_button_MemoryRecall.insets = new Insets(0, 0, 5, 5);
		gbc_button_MemoryRecall.gridx = 1;
		gbc_button_MemoryRecall.gridy = 0;
		gbc_button_MemoryRecall.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_MemoryRecall, gbc_button_MemoryRecall);
		
		Boton button_ClearError = new Boton("CE");
		GridBagConstraints gbc_button_ClearError = new GridBagConstraints();
		gbc_button_ClearError.insets = new Insets(0, 0, 5, 5);
		gbc_button_ClearError.gridx = 1;
		gbc_button_ClearError.gridy = 1;
		gbc_button_ClearError.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_ClearError, gbc_button_ClearError);
		
		Boton button_MemoryRestar = new Boton("M-");
		GridBagConstraints gbc_button_MemoryRestar = new GridBagConstraints();
		gbc_button_MemoryRestar.insets = new Insets(0, 0, 5, 0);
		gbc_button_MemoryRestar.gridx = 4;
		gbc_button_MemoryRestar.gridy = 0;
		gbc_button_MemoryRestar.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_MemoryRestar, gbc_button_MemoryRestar);
		
		Boton button_MemoryStorage = new Boton("MS");
		GridBagConstraints gbc_button_MemoryStorage = new GridBagConstraints();
		gbc_button_MemoryStorage.insets = new Insets(0, 0, 5, 5);
		gbc_button_MemoryStorage.gridx = 2;
		gbc_button_MemoryStorage.gridy = 0;
		gbc_button_MemoryStorage.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_MemoryStorage, gbc_button_MemoryStorage);
		
		Boton button_MemorySumar = new Boton("M+");
		GridBagConstraints gbc_button_MemorySumar = new GridBagConstraints();
		gbc_button_MemorySumar.insets = new Insets(0, 0, 5, 5);
		gbc_button_MemorySumar.gridx = 3;
		gbc_button_MemorySumar.gridy = 0;
		gbc_button_MemorySumar.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_MemorySumar, gbc_button_MemorySumar);
		
		Boton button_MemoryRetroceder = new Boton("<-");
		GridBagConstraints gbc_button_MemoryRetroceder = new GridBagConstraints();
		gbc_button_MemoryRetroceder.insets = new Insets(0, 0, 5, 5);
		gbc_button_MemoryRetroceder.gridx = 0;
		gbc_button_MemoryRetroceder.gridy = 1;
		gbc_button_MemoryRetroceder.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_MemoryRetroceder, gbc_button_MemoryRetroceder);
		
		Boton button_Clear = new Boton("C");
		GridBagConstraints gbc_button_Clear = new GridBagConstraints();
		gbc_button_Clear.insets = new Insets(0, 0, 5, 5);
		gbc_button_Clear.gridx = 2;
		gbc_button_Clear.gridy = 1;
		gbc_button_Clear.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Clear, gbc_button_Clear);
		
		Boton button_CambiarSigno = new Boton("+/-");
		GridBagConstraints gbc_button_CambiarSigno = new GridBagConstraints();
		gbc_button_CambiarSigno.insets = new Insets(0, 0, 5, 5);
		gbc_button_CambiarSigno.gridx = 3;
		gbc_button_CambiarSigno.gridy = 1;
		gbc_button_CambiarSigno.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_CambiarSigno, gbc_button_CambiarSigno);
		
		Boton button_Raiz = new Boton("\u221A");
		GridBagConstraints gbc_button_Raiz = new GridBagConstraints();
		gbc_button_Raiz.insets = new Insets(0, 0, 5, 0);
		gbc_button_Raiz.gridx = 4;
		gbc_button_Raiz.gridy = 1;
		gbc_button_Raiz.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Raiz, gbc_button_Raiz);
		
		Boton button_Num8 = new Boton("8");
		GridBagConstraints gbc_button_Num8 = new GridBagConstraints();
		gbc_button_Num8.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num8.gridx = 1;
		gbc_button_Num8.gridy = 2;
		gbc_button_Num8.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num8, gbc_button_Num8);
		
		Boton button_Num7 = new Boton("7");
		GridBagConstraints gbc_button_Num7 = new GridBagConstraints();
		gbc_button_Num7.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num7.gridx = 0;
		gbc_button_Num7.gridy = 2;
		gbc_button_Num7.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num7, gbc_button_Num7);
		
		Boton button_Num9 = new Boton("9");
		GridBagConstraints gbc_button_Num9 = new GridBagConstraints();
		gbc_button_Num9.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num9.gridx = 2;
		gbc_button_Num9.gridy = 2;
		gbc_button_Num9.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num9, gbc_button_Num9);
		
		Boton button_Num6 = new Boton("6");
		GridBagConstraints gbc_button_Num6 = new GridBagConstraints();
		gbc_button_Num6.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num6.gridx = 2;
		gbc_button_Num6.gridy = 3;
		gbc_button_Num6.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num6, gbc_button_Num6);
		
		Boton button_Num5 = new Boton("5");
		GridBagConstraints gbc_button_Num5 = new GridBagConstraints();
		gbc_button_Num5.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num5.gridx = 1;
		gbc_button_Num5.gridy = 3;
		gbc_button_Num5.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num5, gbc_button_Num5);
		
		Boton button_Num4 = new Boton("4");
		GridBagConstraints gbc_button_Num4 = new GridBagConstraints();
		gbc_button_Num4.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num4.gridx = 0;
		gbc_button_Num4.gridy = 3;
		gbc_button_Num4.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num4, gbc_button_Num4);
		
		Boton button_Num3 = new Boton("3");
		GridBagConstraints gbc_button_Num3 = new GridBagConstraints();
		gbc_button_Num3.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num3.gridx = 2;
		gbc_button_Num3.gridy = 4;
		gbc_button_Num3.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num3, gbc_button_Num3);
		
		Boton button_Num2 = new Boton("2");
		GridBagConstraints gbc_button_Num2 = new GridBagConstraints();
		gbc_button_Num2.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num2.gridx = 1;
		gbc_button_Num2.gridy = 4;
		gbc_button_Num2.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num2, gbc_button_Num2);
		
		Boton button_Num1 = new Boton("1");
		GridBagConstraints gbc_button_Num1 = new GridBagConstraints();
		gbc_button_Num1.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num1.gridx = 0;
		gbc_button_Num1.gridy = 4;
		gbc_button_Num1.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num1, gbc_button_Num1);
		
		Boton button_Num0 = new Boton("0");
		GridBagConstraints gbc_button_Num0 = new GridBagConstraints();
		gbc_button_Num0.insets = new Insets(0, 0, 5, 5);
		gbc_button_Num0.gridx = 0;
		gbc_button_Num0.gridy = 5;
		gbc_button_Num0.gridwidth = 2;
		gbc_button_Num0.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Num0, gbc_button_Num0);
		
		Boton button_Dividir = new Boton("/");
		GridBagConstraints gbc_button_Dividir = new GridBagConstraints();
		gbc_button_Dividir.insets = new Insets(0, 0, 5, 5);
		gbc_button_Dividir.gridx = 3;
		gbc_button_Dividir.gridy = 2;
		gbc_button_Dividir.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Dividir, gbc_button_Dividir);
		
		Boton button_Multiplicar = new Boton("*");
		GridBagConstraints gbc_button_Multiplicar = new GridBagConstraints();
		gbc_button_Multiplicar.insets = new Insets(0, 0, 5, 5);
		gbc_button_Multiplicar.gridx = 3;
		gbc_button_Multiplicar.gridy = 3;
		gbc_button_Multiplicar.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Multiplicar, gbc_button_Multiplicar);
		
		Boton button_Sumar = new Boton("+");
		GridBagConstraints gbc_button_Sumar = new GridBagConstraints();
		gbc_button_Sumar.insets = new Insets(0, 0, 5, 5);
		gbc_button_Sumar.gridx = 3;
		gbc_button_Sumar.gridy = 5;
		gbc_button_Sumar.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Sumar, gbc_button_Sumar);
		
		Boton button_Restar = new Boton("-");
		GridBagConstraints gbc_button_Restar = new GridBagConstraints();
		gbc_button_Restar.insets = new Insets(0, 0, 5, 5);
		gbc_button_Restar.gridx = 3;
		gbc_button_Restar.gridy = 4;
		gbc_button_Restar.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Restar, gbc_button_Restar);
		
		Boton button_Resultado = new Boton("=");
		GridBagConstraints gbc_button_Resultado = new GridBagConstraints();
		gbc_button_Resultado.fill = GridBagConstraints.BOTH;
		gbc_button_Resultado.gridheight = 2;
		gbc_button_Resultado.insets = new Insets(0, 0, 5, 0);
		gbc_button_Resultado.gridx = 4;
		gbc_button_Resultado.gridy = 4;
		gbc_button_Resultado.gridheight = 2;
		panel_Centro_Centro.add(button_Resultado, gbc_button_Resultado);
		
		
		Boton button_Decimal = new Boton(",");
		GridBagConstraints gbc_button_Decimal = new GridBagConstraints();
		gbc_button_Decimal.insets = new Insets(0, 0, 5, 5);
		gbc_button_Decimal.gridx = 2;
		gbc_button_Decimal.gridy = 5;
		gbc_button_Decimal.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Decimal, gbc_button_Decimal);
		
		Boton button_Porcentaje = new Boton("%");
		GridBagConstraints gbc_button_Porcentaje = new GridBagConstraints();
		gbc_button_Porcentaje.insets = new Insets(0, 0, 5, 0);
		gbc_button_Porcentaje.gridx = 4;
		gbc_button_Porcentaje.gridy = 2;
		gbc_button_Porcentaje.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_Porcentaje, gbc_button_Porcentaje);
		
		Boton button_DividirNumeroPorX = new Boton("1/x");
		GridBagConstraints gbc_button_DividirNumeroPorX = new GridBagConstraints();
		gbc_button_DividirNumeroPorX.insets = new Insets(0, 0, 5, 0);
		gbc_button_DividirNumeroPorX.gridx = 4;
		gbc_button_DividirNumeroPorX.gridy = 3;
		gbc_button_DividirNumeroPorX.fill = GridBagConstraints.BOTH;
		panel_Centro_Centro.add(button_DividirNumeroPorX, gbc_button_DividirNumeroPorX);
		
		
		//		 ********************
		// 		 * ACTION LISTENERS *
      	//    	 ********************
		
		// num0
		button_Num0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("0");
				textResultado.setText(imprimir());
			}
		});
		
		// num1
		button_Num1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("1");
				textResultado.setText(imprimir());
			}
		});
		
		// num2
		button_Num2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("2");
				textResultado.setText(imprimir());
			}
		});
		
		// num3
		button_Num3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("3");
				textResultado.setText(imprimir());
			}
		});
		
		// num4
		button_Num4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("4");
				textResultado.setText(imprimir());
			}
		});
		
		// num5
		button_Num5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("5");
				textResultado.setText(imprimir());
			}
		});
		
		// num6
		button_Num6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("6");
				textResultado.setText(imprimir());
			}
		});
		
		// num7
		button_Num7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("7");
				textResultado.setText(imprimir());
			}
		});
		
		// num8
		button_Num8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("8");
				textResultado.setText(imprimir());
			}
		});
		
		// num9
		button_Num9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero("9");
				textResultado.setText(imprimir());
			}
		});
		
		// retroceder
		button_MemoryRetroceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retroceder();
			}
		});
		
		// reset
		button_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.reset();
				textResultado.setText(imprimir());
			}
		});
		
		// dividir
		button_Dividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					asignarOperacion("/");
				} catch (DivisionPorCeroExcepcion e1) {
					textResultado.setText("No se puede dividir por 0");
					clear();
				}
			}
		});
		
		// sumar
		button_Sumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					asignarOperacion("+");
				} catch (DivisionPorCeroExcepcion e1) {
				}
			}
		});
		
		// restar
		button_Restar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					asignarOperacion("-");
				} catch (DivisionPorCeroExcepcion e1) {
					
				}
			}
		});
		
		// multiplicar
		button_Multiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					asignarOperacion("*");
				} catch (DivisionPorCeroExcepcion e1) {
					
				}
			}
		});
		
		// resultado
		button_Resultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calcular();
					textResultado.setText(imprimir());
				} catch (DivisionPorCeroExcepcion e1) {
					textResultado.setText("No se puede dividir por 0");
					clear();
				}
			}
		});
		
		// decimal
		button_Decimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNumero(".");
			}
		});

		// cambiar signo
		button_CambiarSigno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSigno();
				textResultado.setText(imprimir());
			}
		});
		
		
	}
	
	
	
	private void insertarNumero(String numero) {
		
		// Si despues de un calculo seguidamente introducimos un numero 
		// no se concatena al resultado mostrado
		// ej -> 1 + 2 = 3 (introduzco) 5 debe respetar 3 + 5
		// Si no contemplo esto los numeros introducidos despues del resultado de una operacion
		// se concatenan al resultado
		if (calculadora.getMostrar() && calculadora.getNumActual().equals("0") && 
			calculadora.getNum1() != 0) {
			
			calculadora.setMostrar(false);
		}
		
		if (numero.equals(".") ) {
			
			// Comprobamos si ya contiene una coma para no volver a introducirla
			// Comprobar tambien si no tiene el signo negativo justo delante
			if (!calculadora.getNumActual().contains(".")) {
				if (calculadora.getNumActual().contains("-") && 
				    calculadora.getNumActual().length() == 1) {
					
				}
				else {
					// Si asignamos un decimal sin antes haber introducido un numero se presupone
					// que se inserta un 0 
					// ej -> 5 + ,54 
					// res-> 5 + 0,54
					if (calculadora.getNumActual().isEmpty()) {
						calculadora.setNumActual("0");
					}
					calculadora.concatenar(numero);
					textResultado.setText(imprimir());
				}
			}
			
		}
		else if (numero.equals("-")) {
			
			if (!calculadora.getNumActual().contains("-")) {
				calculadora.setNumActual("-");
			}
			
			calculadora.setMostrar(false);
		}
		else {
			
			// Si el numActual vale "0" seteamos su valor a "" para que no concatene los siguientes valores
			// ejMal:  numActual = 0 + 1 -> 01
			// ejBien: numActual = 0 + 1 -> 1
			if (calculadora.getNumActual().equals("0")) calculadora.setNumActual("");
			calculadora.concatenar(numero);
			
			calculadora.setMostrar(false);
		}
		
		textResultado.requestFocus();
	}
	
	private void asignarOperacion(String operacion) throws DivisionPorCeroExcepcion {

		if ((operacion.equals("-")) && calculadora.getNumActual().equals("0") && calculadora.getNum1() != 0) {
			if (operacion.equals("-")) {
				insertarNumero(operacion);
				textResultado.setText(imprimir());
			}
		}
		else {
			
			try {
				
				// Si no existe ningun signo todavia num1 = numActual else num2 = numActual
				if (calculadora.getOperacion().isEmpty()) {
					calculadora.setNum1(Double.parseDouble(calculadora.getNumActual()));
				}
				else calculadora.setNum2(Double.parseDouble(calculadora.getNumActual()));
				
				// Si los 2 numeros estan modificados hay que operar antes -> ej: 1 + 2 + 1 
				// de la segunda operacion									        3 + 1
				if (!calculadora.getOperacion().isEmpty()) {
					
					calcular();
					calculadora.setOperacion(operacion);
					
					String num = parsearNumero(String.valueOf(calculadora.getNum1()));
					calculadora.setNumActual(num);
					textResultado.setText(imprimir());
					
					calculadora.setNumActual("0");
					calculadora.setMostrar(true);
				}
				else {
					// Si no existe ningun signo todavia lo agregamos y refrescamos el numActual
					// para el siguiente numero a leer
					calculadora.setOperacion(operacion);
					calculadora.setNumActual("0");
					calculadora.setMostrar(false);
				}
				
			}
			catch (NumberFormatException e) {
				calculadora.setOperacion(operacion);
			}
			
		}
		
		textResultado.requestFocus();
	}
	
	private void calcular() throws DivisionPorCeroExcepcion {
		 
		// Si agregamos un numero y un operando hay que calcular
		// ej -> 5 + = = = =    5 * = = = =    5 - = = = =      5 / = = = =  
		// res ->  5 10 15 20     25 125 625     0 -5 -10 -15     1 0,2 0,04 0,008
		if (!calculadora.getOperacion().isEmpty() && calculadora.getNum1() != 0 && calculadora.getNumActual().isEmpty()) {
			
			switch (calculadora.getOperacion()) {
			case "+": 
				calculadora.setNum1(calculadora.getNum1() + calculadora.getNum2());
				break;
			case "-":
				calculadora.setNum1(calculadora.getNum1() - calculadora.getNum2());
				break;
			case "*":
				calculadora.setNum1(calculadora.getNum1() * calculadora.getNum2());
				break;
			case "/":
				if (calculadora.getNum1() == 0) throw new DivisionPorCeroExcepcion();
				calculadora.setNum1(calculadora.getNum1() / calculadora.getNum2());
				break;
			}
			
			String num = parsearNumero(String.valueOf(calculadora.getNum1()));
			calculadora.setNumActual(num);
			calculadora.setNum2(0);
			calculadora.setMostrar(true);
			
		}
		else if (calculadora.getNum1() != 0 && !calculadora.getNumActual().isEmpty()) {
			
			calculadora.setNum2(Double.valueOf(calculadora.getNumActual()));
			
			// Siempre agregamos el resultado a num1
			calculadora.setNum1(calculadora.calcular());
			
			// numActual pasa a valer el resultado (num1)
			String num = parsearNumero(String.valueOf(calculadora.getNum1()));
			calculadora.setNumActual(num);
			
			// Refrescamos el signo y la variable num2
			calculadora.setOperacion("");
			calculadora.setNum2(0);
			
			// Para que la funcion retroceder no pueda eliminar el texto del resultado y que se siga mostrando
			calculadora.setMostrar(true);
					
		}
		
		textResultado.requestFocus();
	}
	
	private void retroceder() {
		
		if (calculadora.getMostrar()) {
			
		}
		else {
			
			if (calculadora.getNumActual().length() == 1) calculadora.setNumActual("0");
			else if (calculadora.getNumActual().length() > 1) {
				calculadora.retroceder();
			}
			
			// Retroceder un -5 su resultado es 0 y no -
			if (calculadora.getNumActual().equals("-")) {
				calculadora.setNumActual("0");
			}
			
			textResultado.setText(imprimir());
			textResultado.requestFocus();
		}
		
	}
	
	private void clear() { calculadora.reset(); }
	
	private void clearError(){}
	
	private void raiz(){}
	
	private void inversa(){
		
	}
	
	private void cambiarSigno() {
		
		// Si contiene el signo "-" -> eliminarlo
		// else -> agregar signo "-"
		// Al numero 0 no hay que asignarle nada
		if (!calculadora.getNumActual().equals("0")) {
			
			if (!calculadora.getNumActual().contains("-")) {
				calculadora.setNumActual("-" + calculadora.getNumActual());
			}
			else {
				String numero = calculadora.getNumActual();
				calculadora.setNumActual(numero.substring(1, numero.length()));
			}
			
		}
		
	}
	
	private String imprimir() {
		// 1234.32 -> 1.234,32
		String aux = calculadora.getNumActual();
		aux = aux.replace(".", ",");
		String imprimir = "";
		if (aux.length() > 3) {
			
			int x = 0;
			boolean coma = false;
			boolean contiene = aux.contains(",");
			
			for (int i = aux.length()-1; i >= 0; i--) {
				imprimir = aux.charAt(i) + imprimir;
				if (contiene) {
					if (coma) x++;
				}
				else x++;
				if (aux.charAt(i) == ',') coma = true;
				if (x == 3 && (i-1) >= 0 && aux.charAt(i-1) != '-') {
					imprimir = '.' + imprimir;
				}
				if (x == 3) x = 0;
			}
			
			return imprimir;
		}
		
		return aux;
	}
	
	private String parsearNumero(String num) {
		String aux = "";
		num = num.replace(",", ".");
		boolean start = false, coma = false;
		for (int i = num.length()-1; i >= 0; i--) {
			if (num.charAt(i) != '0' && num.charAt(i) != '.') start = true;
			if (start) aux = num.charAt(i) + aux;
			else if (!start && coma) aux = num.charAt(i) + aux;
			if (num.charAt(i) == '.') coma = true;
		}
		return aux;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();

		switch (key) {

		case KeyEvent.VK_0:	insertarNumero("0"); break;
		case KeyEvent.VK_1:	insertarNumero("1"); break;
		case KeyEvent.VK_2:	insertarNumero("2"); break;
		case KeyEvent.VK_3:	insertarNumero("3"); break;
		case KeyEvent.VK_4:	insertarNumero("4"); break;
		case KeyEvent.VK_5:	insertarNumero("5"); break;
		case KeyEvent.VK_6:	insertarNumero("6"); break;
		case KeyEvent.VK_7:	insertarNumero("7"); break;
		case KeyEvent.VK_8:	insertarNumero("8"); break;
		case KeyEvent.VK_9:	insertarNumero("9"); break;

		case KeyEvent.VK_NUMPAD0: insertarNumero("0"); break;
		case KeyEvent.VK_NUMPAD1: insertarNumero("1"); break;
		case KeyEvent.VK_NUMPAD2: insertarNumero("2"); break;
		case KeyEvent.VK_NUMPAD3: insertarNumero("3"); break;
		case KeyEvent.VK_NUMPAD4: insertarNumero("4"); break;
		case KeyEvent.VK_NUMPAD5: insertarNumero("5"); break;
		case KeyEvent.VK_NUMPAD6: insertarNumero("6"); break;
		case KeyEvent.VK_NUMPAD7: insertarNumero("7"); break;
		case KeyEvent.VK_NUMPAD8: insertarNumero("8"); break;
		case KeyEvent.VK_NUMPAD9: insertarNumero("9"); break;
		
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
}