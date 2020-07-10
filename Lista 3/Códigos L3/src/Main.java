import java.util.Scanner;

import com.view.Menu;

public class Main {

	public static void main(String[] args) {
		int op = 10;
		Menu menu = new Menu();
		Scanner scanner = new Scanner(System.in);
		while (op != 0) {
			menu.telaInicial();
			op = scanner.nextInt();
			if (op == 1) {
				menu.cadastrarUsuario();
			};
			if (op == 2) {
				menu.fazerLogin();
			}
			if (op == 3) {
				menu.cadastrarEntradaSaida();
			}
			if (op == 4) {
				menu.relatoriosFluxoDeCaixa();
			}
		}

	}

}
