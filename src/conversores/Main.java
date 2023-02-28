package conversores;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {

	//private static final String Object = null;
	public Double vlrDolarCp ;
	public Double vlrDolarVd ;
	public Double vlrEuroCp ;
	public Double vlrEuroVd ;
	public Double vlrBTCCp ;
	public Double vlrBTCVd ;

	public static void main(String[] args) throws IOException, InterruptedException {
		int option = 0;
		String txt1 = "Escolha uma conversão:";
		while (option <3) {
			/* JOptionPane Java user input example */    
			String[] options = { "Moedas", "Medidas", "Temperaturas", "Sair" };
			option = JOptionPane.showOptionDialog(null, txt1, "Menu - Conversores", 
					0, 3, null, options, options[0]);
			if (option == 0) {
				ConvMoedas.moedas();
			}
			if (option == 1) { 
				ConvMedidas.medidas();
			}
			if (option == 2) { 
				ConvTemp.temperaturas();
			}
			txt1 = "Deseja escolher uma nova conversão?";
		}
	}
}
