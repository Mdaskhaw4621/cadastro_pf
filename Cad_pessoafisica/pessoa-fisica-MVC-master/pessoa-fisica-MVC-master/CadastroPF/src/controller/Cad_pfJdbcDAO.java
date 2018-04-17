package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PessoaFisica;

public class Cad_pfJdbcDAO {
		public static final String select = null;
		private Connection conn;
		
		public Cad_pfJdbcDAO(Connection conn) {
			this.conn = conn;
		}
		
		public void salvar(PessoaFisica c) throws SQLException{
			String sql = "insert into pessoa_f (nome, endereco, cidade, bairro, telefone, rg, sexo, estado, cep, celular, cpf) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getCidade()+"','"+c.getBairro()+"','"+c.getTelefone()+"','"+c.getRg()+"','"+c.getSexo()+"','"+c.getEstado()+"','"+c.getCep()+"','"+c.getCelular()+"','"+c.getCpf()+"');";	
			System.out.println(sql);			
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			preparedStatement.execute();
			preparedStatement.close();
		}
		
		public void imprimir() throws SQLException{
			
			String select = "select * from pessoa_f";
			PreparedStatement preparedStatement = this.conn.prepareStatement(select);
			
			ResultSet rs = preparedStatement.executeQuery(select);
			int cont = 0;
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String tel = rs.getString("telefone");
				String rg = rs.getString("rg");
				String sexo = rs.getString("sexo");
				String estado = rs.getString("estado");
				String cep = rs.getString("cep");
				String celular = rs.getString("celular");
				String cpf = rs.getString("cpf");
				
				
				if(cont >= 1 ) {
				System.out.printf("\n ************\nNome: " + nome + "\nEndereço: " + endereco + "\nCidade: " + cidade 
						+ "\nBairro: "+ bairro + "\nTelefone: " + tel + "\nRG: " + rg + "\nSexo: " + sexo + "\nCEP: " + cep + "\nCelular: " + celular + "\nCPF: " + cpf + "\n" );
				}
				else {System.out.printf("Nome: " + nome + "\nEndereço: " + endereco + "\nCidade: " + cidade 
						+ "\nBairro: "+ bairro + "\nTelefone: " + tel + "\nRG: " + rg + "\nSexo: " + sexo + "\nCEP: " + cep + "\nCelular: " + celular + "\nCPF: " + cpf + "\n");}
				
				cont++;
			}
			
			preparedStatement.execute();
			preparedStatement.close();
	
		}
	}


