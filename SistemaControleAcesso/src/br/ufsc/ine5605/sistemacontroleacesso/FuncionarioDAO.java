package br.ufsc.ine5605.sistemacontroleacesso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;

public class FuncionarioDAO{
	private HashMap<Integer, Funcionario> cacheFuncionario = new HashMap<>();
	
	private final String fileName= "funcionario.dat";
	
	public FuncionarioDAO(){
		load();
	}
	
	public void put(Funcionario funcionario){
		cacheFuncionario.put(funcionario.getNumeroDeMatricula(), funcionario);
		persist();
	}
	
	public Funcionario get(Integer matricula){
		return cacheFuncionario.get(matricula);
	}
	
	public Collection<Funcionario> getList(){
		return cacheFuncionario.values();
	}

	public void remove(Funcionario funcionarioRemover) {
		// TODO Auto-generated method stub
		cacheFuncionario.remove(funcionarioRemover.getNumeroDeMatricula());	
		persist();
	}
	
	private void persist(){
		try {
			FileOutputStream fOS= new FileOutputStream(fileName);
			ObjectOutputStream oOS= new ObjectOutputStream(fOS);
			
			oOS.writeObject(cacheFuncionario);
			oOS.flush();
			fOS.flush();
			
			oOS.close();
			fOS.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void load(){
		try {
			FileInputStream fIS = new FileInputStream(fileName);
			ObjectInputStream oIS= new ObjectInputStream(fIS);
			
			cacheFuncionario= (HashMap<Integer, Funcionario>) oIS.readObject();
			
			oIS.close();
			fIS.close();
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			persist();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
