package entities;

public class ContaBancaria {
	private String numConta;
	private String nomeTitular;
	private double saldo;
	
	public ContaBancaria (String numConta, String nomeTitular) {
		this.numConta = numConta;
		this.nomeTitular = nomeTitular;
	}
	
	public String getNumConta() {
		return numConta;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void deposito(double valor) {
		saldo += valor;
	}
	
	public void saque(double valor) {
		saldo -= (valor + 5.0);
	}

	public String toString() {
		return "Número da conta: " 
	            + numConta 
	            + ", nome do titular: " 
	            + nomeTitular 
	            + ", saldo: R$" 
	            + String.format("%.2f", saldo);
	}

}
