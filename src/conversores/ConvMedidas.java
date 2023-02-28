package conversores;

import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ConvMedidas {
	
		
	public static void medidas() {
		
		System.out.println("Acesso a class: Medidas" );
		/* 
			1 xícara	16 colheres (sopa)	240 ml
			1 colher (sopa)	3 colheres (chá)	15 ml
			1 colher (chá)	⅓ colher (sopa)	5 ml
		
		Double vlrXicara = 240.0;
		Double vlrColherSopa = 15.0;
		Double vlrColherCha = 5.0;
		 */
		
		int continuaConv = 0;
		while (continuaConv <1) {
			continuaConv ++;
			String qtde = JOptionPane.showInputDialog(null, "Informe a medida em ml", "Menu Temperaturas",JOptionPane.INFORMATION_MESSAGE );
			
			qtde = qtde.replace(".", "");
			qtde = qtde.replace(",", ".");

			converterMedida(qtde);	
			
			String[] options2 = { "SIM", "NÃO" };
			int option2 = JOptionPane.showOptionDialog(null, "Deseja converter mais medidas?", "Menu - Temperaturas", 
					0, 3, null, options2, options2[0]);
			if (option2 == 0) {
				continuaConv = 0;
			
			}
		}
	    
	    // Verificar se deseja fazer outra conversão
		System.out.println("Final da conversão das temperaturas - Volta para Menu Principal do programa!");
	   
		
	  
	// Final do programa
	    
	}

	private static void converterMedida(String qtde) {
		
		Double convQtde = Double.parseDouble(qtde);
		
		
		
		System.out.println("Conversão de medidas, considerando ML :\nQtde: "+ qtde+" ML");

		
		Double xicara = convQtde / 240;
		Double colherSopa = convQtde / 15;
		Double colherCha = convQtde / 5;
		
		JOptionPane.showMessageDialog(null, "Conversão de "+ qtde + " ML\n\n Xícara: "  + new DecimalFormat(".##").format(xicara) +
				"\n Colher de Sopa: " + new DecimalFormat(".##").format(colherSopa) +
				"\n Colher de Chá: " + new DecimalFormat(".##").format(colherCha));
		
	}
}
