package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.ContaBancaria;

public class Program {
	
	public static void mostrarMenu() {
		System.out.println("\n\t\tMENU");
		System.out.println("[ 1 ] Criar nova conta bancária");
		System.out.println("[ 2 ] Realizar depósito");
		System.out.println("[ 3 ] Realizar saque");
		System.out.println("[ 4 ] Excluir conta bancária");
		System.out.println("[ 5 ] Mostrar dados da conta");
		System.out.println("[ 6 ] Sair");
		
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner console = new Scanner(System.in);
		ArrayList<ContaBancaria> contas = new ArrayList<>();
		
		int opcao = 0;
		do {
			mostrarMenu();
			System.out.print("\nEscolha uma opção: ");
			opcao = Integer.parseInt(console.nextLine());
			
			switch (opcao) {
			case 1:
				System.out.print("Digite o número da conta: ");
				String numConta = console.nextLine();
				System.out.print("Digite o nome do titular da conta: ");
				String nomeTitular = console.nextLine();
				ContaBancaria conta = new ContaBancaria(numConta, nomeTitular);
				contas.add(conta);
				System.out.println("Conta criada com sucesso!");
				break;
			case 2:
				System.out.print("Digite o número da conta: ");
				numConta = console.nextLine();
				System.out.print("Digite o valor a ser depositado: ");
				double valorDeposito = Double.parseDouble(console.nextLine());
				for (ContaBancaria c : contas) {
					if (c.getNumConta().equals(numConta)) {
						c.deposito(valorDeposito);
						System.out.println("Depósito realizado com sucesso!");
					} else {
						System.out.println("Conta não existe!");
					}
				}
				break;
			case 3:
				System.out.print("Digite o número da conta: ");
				numConta = console.nextLine();
				System.out.print("Digite o valor a ser sacado: ");
				double valorSaque = Double.parseDouble(console.nextLine());
				for (ContaBancaria c : contas) {
					if (c.getNumConta().equals(numConta)) {
						if (c.getSaldo() < valorSaque) {
							System.out.println("Saldo insuficiente!");
						}
						else {
							c.saque(valorSaque);
							System.out.println("Saque realizado com sucesso! (Taxa de R$ 5 por saque foi realizada)");
						}
					} else {
						System.out.println("Conta não existe!");
					}
				}
				break;
			case 4:
				// listar as contas bancárias
				for (int i = 0; i < contas.size(); i++) {
					System.out.println((i + 1) + ": " + contas.get(i).getNomeTitular());
				}
				// solicitar ao usuário que escolha qual conta deseja excluir
				System.out.print("Digite o número da conta que deseja excluir: ");
				int escolha = Integer.parseInt(console.nextLine());
				ContaBancaria contaExcluir = contas.get(escolha - 1);
				// remover a conta do ArrayList
				contas.remove(contaExcluir);
				System.out.println("Conta " + contaExcluir.getNomeTitular() + " excluída com sucesso!");
				break;
			case 5:
				System.out.print("Digite o número da conta: ");
				numConta = console.nextLine();
				for (ContaBancaria c : contas) {
					if (c.getNumConta().equals(numConta)) {
						System.out.println("\n" + c.toString()); 
					} else {
						System.out.println("Conta não existe!");
					}
				}
				break;
			case 6:
				System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				mostrarMenu();
			}
		} while (opcao != 6);
	
	console.close();
	}
}
