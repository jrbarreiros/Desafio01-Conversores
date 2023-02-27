package conversores;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ConvMoedas {
		
	public static void moedas() throws IOException, InterruptedException {
		
		System.out.println("Acesso a class: Moedas" );
		
		getMoedas.ResponseWrapper varResponse = getMoedas.getValores();
		
		Double vlrDolarCp = varResponse.USDBRL.bid;
		Double vlrDolarVd = varResponse.USDBRL.ask;
		String vlrDolarDt = varResponse.USDBRL.create_date;
		Double vlrEuroCp = varResponse.EURBRL.bid;
		Double vlrEuroVd = varResponse.EURBRL.ask;
		String vlrEuroDt = varResponse.EURBRL.create_date;
		Double vlrBTCCp = varResponse.BTCBRL.bid;
		Double vlrBTCVd = varResponse.BTCBRL.ask;
		String vlrBTCDt = varResponse.BTCBRL.create_date;

		int continuaConv = 0;
		while (continuaConv <1) {
			continuaConv ++;
			//JOptionPane.showMessageDialog(null, "Moedas");
			String qtde = JOptionPane.showInputDialog(null, "Informe a quantidade de moedas", "Menu Moedas",JOptionPane.INFORMATION_MESSAGE );
			//System.out.println("Qtde :" + qtde);
			
			qtde = qtde.replace(".", "");
			qtde = qtde.replace(",", ".");
			
			String[] moedasConv = { "Real => Dolar", "Dolar => Real", "Real => Euro", "Euro => Real" , "Real => BTC", "BTC => Real"};
			final JComboBox<String> combo = new JComboBox<>(moedasConv);
			
			String[] options = { "OK", "Cancel" };
			
			String title = "Escolha as moedas para conversão";
			int selection = JOptionPane.showOptionDialog(null, combo, title,
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
					options[0]);
			
			if (selection > 0) {
				System.out.println("selection is: " + options[selection]);
			}
		
			Object option = combo.getSelectedItem();
			if (option != null) {
				System.out.println("Optselection is: " + options[selection]);
				System.out.println("selection is: " + selection);
				System.out.println("Option: " + option);
			}
			if(option == "Real => Dolar") {
				String simbolo = "US$";
				String moedaDe = "Real";
				String moedaPara = "Dolar";
				converteMoedas(qtde, vlrDolarCp, vlrDolarVd, vlrDolarDt, moedaDe, moedaPara, simbolo);	
			}
			if(option == "Dolar => Real") {
				String simbolo = "R$";
				String moedaDe = "Dolar";
				String moedaPara = "Real";
				converteMoedas(qtde, vlrDolarCp, vlrDolarVd, vlrDolarDt, moedaDe, moedaPara, simbolo);	
			}
			if(option == "Real => Euro") {
				String simbolo = "€";
				String moedaDe = "Real";
				String moedaPara = "Euro";
				converteMoedas(qtde, vlrEuroCp, vlrEuroVd, vlrEuroDt, moedaDe, moedaPara, simbolo);	
			}
			if(option == "Euro => Real") {
				String simbolo = "R$";
				String moedaDe = "Euro";
				String moedaPara = "Real";
				converteMoedas(qtde, vlrEuroCp, vlrEuroVd, vlrEuroDt, moedaDe, moedaPara, simbolo);	
			}			
			if(option == "Real => BTC") {
				String simbolo = "฿";
				String moedaDe = "Real";
				String moedaPara = "BTC";
				converteMoedas(qtde, vlrBTCCp, vlrBTCVd, vlrBTCDt, moedaDe, moedaPara, simbolo);	
			}
			if(option == "BTC => Real") {
				String simbolo = "R$";
				String moedaDe = "BTC";
				String moedaPara = "Real";
				converteMoedas(qtde, vlrBTCCp, vlrBTCVd, vlrBTCDt, moedaDe, moedaPara, simbolo);	
			}					
			String[] options2 = { "SIM", "NÃO" };
			int option2 = JOptionPane.showOptionDialog(null, "Deseja converter mais moedas?", "Menu - Moedas", 
					0, 3, null, options2, options2[0]);
			if (option2 == 0) {
				continuaConv = 0;
			}
		}
	    // Verificar se deseja fazer outra conversão
		System.out.println("Final da conversão de moedas - Volta para Menu Principalo programa!");
	// Final do programa
	}

	//Início  Conversão 
	private static void converteMoedas(String qtde, Double vlrCp, Double vlrVd, String vlrConDt, String moedaDe, String moedaPara, String simbolo) {

		Double convQtde = Double.parseDouble(qtde);
		Double vlrConCp = 0.0;
		Double vlrConVd = 0.0;
		
		if(moedaPara == "Real") {
			vlrConCp = convQtde * vlrCp;
			vlrConVd = convQtde * vlrVd;
		} else if(moedaDe == "Real") {
			vlrConCp = convQtde / vlrCp;
			vlrConVd = convQtde / vlrVd;
		}
		// Formatar valores com duas decimais e potuação
		String padraoVlr;
		DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "Brazil"));
		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		DecimalFormat df;
		if(moedaPara == "BTC") {
			padraoVlr = "###,###,###,##0.00000";
		} else padraoVlr = "###,###,###,##0.00";
		
		df = new DecimalFormat(padraoVlr, dfs);
		
		String fmtVlrCp = df.format(vlrConCp);
		String fmtVlrVd = df.format(vlrConVd); 
	
		JOptionPane.showMessageDialog(null, "Conversão de "+ moedaDe +" para "+ moedaPara + ": \n Compra: "+ simbolo +
				" " + fmtVlrCp + " \n Venda:  " +  simbolo + " "  + fmtVlrVd +
				"\n\nConsulta realizada em: \n  "+ vlrConDt + "\n Fonte:\n  economia.awesomeapi.com.br"  );
	}
	//Final  Conversão 
}
