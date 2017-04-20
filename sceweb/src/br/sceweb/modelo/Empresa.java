package br.sceweb.modelo;

import java.util.InputMismatchException;
/**
 * mantem as informa��es das empresas cadastras para oferecer convenio
 * @author esadv6
 *
 */
public class Empresa {
	String cnpj;
	String nomeDaEmpresa;
	String nomeFantasia;
	String endereco;
	String telefone;
	
	/*
	 * Obtem cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/*
	 * atribui o cnpj vefica se o cnpj � valido
	 */
	public void setCnpj(String cnpj)  {
		if (isValido(cnpj)){
			this.cnpj = cnpj;
		}
		else
			throw new IllegalArgumentException("CNPJ inv�lido!");
	}
	
	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}
	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		if (nomeDaEmpresa.equals("")){
			this.nomeDaEmpresa = nomeDaEmpresa;
			throw new IllegalArgumentException("nome da empresa inv�lido!");
		}
		else
			this.nomeDaEmpresa = nomeDaEmpresa;
		
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		if (nomeFantasia.equals("")){
			this.nomeFantasia = nomeFantasia;
			throw new IllegalArgumentException("nome fantasia inv�lido!");
		}
		else
			this.nomeFantasia = nomeFantasia;
		
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if (endereco.equals("")){
			this.endereco = endereco;
			throw new IllegalArgumentException("endereco invalido");
		}
		else
			this.endereco = endereco;
		
	}

	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if (telefone.equals("")){
			this.telefone = telefone;
			throw new IllegalArgumentException("telefone invalido");
		}
		else
			this.telefone = telefone;
		
	}
	
	/*
	 * valida o cnpj
	 */
	public boolean isValido(String cnpj) {
		char dig13, dig14; 
		int sm, i, r, num, peso;
		if (cnpj.equals("00000000000000") || 
				cnpj.equals("11111111111111") || 
				cnpj.equals("22222222222222") || 
				cnpj.equals("33333333333333") || 
				cnpj.equals("44444444444444") || 
				cnpj.equals("55555555555555") ||
				cnpj.equals("66666666666666") || 
				cnpj.equals("77777777777777") || 
				cnpj.equals("88888888888888") || 
				cnpj.equals("99999999999999") || 
				(cnpj.length() != 14)) {
			return(false); 
		}
		// "try" - protege o c�digo para eventuais erros de conversao de tipo (int) 
		try { // Calculo do 1o. Digito Verificador 
			sm = 0; 
			peso = 2; 
			for (i=11; i>=0; i--) { 
				// converte o i-�simo caractere do CNPJ em um n�mero: 
				// por exemplo, transforma o caractere '0' no inteiro 0 
				// (48 eh a posi��o de '0' na tabela ASCII) 
				num = (int)(cnpj.charAt(i) - 48); 
				sm = sm + (num * peso); 
				peso = peso + 1; if (peso == 10) 
					peso = 2; 
			} 
			r = sm % 11; 
			if ((r == 0) || (r == 1)) 
				dig13 = '0'; 
			else 
				dig13 = (char)((11-r) + 48);
		
		// Calculo do 2o. Digito Verificador 
		sm = 0; peso = 2; 
		for (i=12; i>=0; i--) { 
			num = (int)(cnpj.charAt(i)- 48); 
			sm = sm + (num * peso); peso = peso + 1; 
			if (peso == 10) peso = 2; 
			} 
		r = sm % 11; 
		if ((r == 0) || (r == 1)) dig14 = '0';
		else dig14 = (char)((11-r) + 48); 
		// Verifica se os d�gitos calculados conferem com os d�gitos informados. 
		if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) 
			return(true); else return(false);
		}
		
		catch (InputMismatchException erro) {
			erro.printStackTrace();
	        return(false);
	    }
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null) {
				return false;
			}
		} else if (!cnpj.equals(other.cnpj)) {
			return false;
		}
		if (endereco == null) {
			if (other.endereco != null) {
				return false;
			}
		} else if (!endereco.equals(other.endereco)) {
			return false;
		}
		if (nomeDaEmpresa == null) {
			if (other.nomeDaEmpresa != null) {
				return false;
			}
		} else if (!nomeDaEmpresa.equals(other.nomeDaEmpresa)) {
			return false;
		}
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null) {
				return false;
			}
		} else if (!nomeFantasia.equals(other.nomeFantasia)) {
			return false;
		}
		if (telefone == null) {
			if (other.telefone != null) {
				return false;
			}
		} else if (!telefone.equals(other.telefone)) {
			return false;
		}
		return true;
	}

}
