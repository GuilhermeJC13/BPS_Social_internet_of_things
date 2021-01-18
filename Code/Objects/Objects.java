package Objects;

import java.util.ArrayList;
import java.util.Random;

public class Objects {
	
	Random gerador = new Random();
	
	public Objects() {
		
		social_network = Random_social();
		requirement_list = Random_requirement_list('R');
		required_service_list = Random_service('R');
		service_list = Random_service('O');
		information = Random_requirement_list('O');
		
	}
	
	//----------------------------------------Dados gerais-----------------------------------------------//
	ArrayList<ArrayList<Integer>> social_network = new ArrayList<ArrayList<Integer>>(); // ArrayList bidimensional de relacionamento
	
	int quant_objetos = (gerador.nextInt(5) + 5);
	//----------------------------------------Obj requisitor-----------------------------------------------//
	ArrayList<String> required_service_list = new ArrayList<String>(); // tarefas requisitadas
	ArrayList<String> requirement_list = new ArrayList<String>(); 	  // pre-requisitos
	
	int requester = gerador.nextInt(quant_objetos); // objeto que requisitou
	
	//----------------------------------------Obj requisitado-----------------------------------------------//
	ArrayList<String> service_list = new ArrayList<String>(); // lista de possiveis servicos do objeto
	ArrayList<String> information = new ArrayList<String>(); // lista sobre informacoes usadas para comparar os pre-requisitos
	
	//----------------------------------------Func Getter-----------------------------------------------//
	public ArrayList<ArrayList<Integer>> getSocial(){ return social_network;}
	public ArrayList<String> getReqSer(){ return required_service_list;}
	public ArrayList<String> getReqList(){ return requirement_list;}
	public ArrayList<String> getservList(){ return service_list;}
	public ArrayList<String> getInfo(){ return information;}
	public int getQuant() { return quant_objetos;}
	public int getReq() { return requester;}
	
	
	//----------------------------------------Func Randomizers-----------------------------------------------//
	private ArrayList<String> Random_service(char c){
		ArrayList<String> random_list = new ArrayList<String>();
		int x;
		int y;
		while(true) {
			x = gerador.nextInt(100);
			y = gerador.nextInt(100);
			
			if(x <= 20) {
				if(random_list.contains("SEND MSG"));
				
				else
					random_list.add("SEND MSG");
			}
			if(x <= 40 && x > 20) {
				if(random_list.contains("CALL"));
				
				else
					random_list.add("CALL");
			}
			if(x <= 60 && x > 40) {
				if(random_list.contains("MOVE"));
				
				else
					random_list.add("MOVE");
			}
			if(x <= 80 && x > 60) {
				if(random_list.contains("PLAY"));
				
				else
					random_list.add("PLAY");
			}
			if(x > 80) {
				if(random_list.contains("SEARCH"));
				
				else
					random_list.add("SEARCH");
			}
			
			if(y >= 80 && c == 'R') { // caso seja requisitor
				break;
			}
			else if(y >= 50 && c == 'O') { // caso seja objeto
				break;
			}
			
		}
		return random_list;
	}
	
	
	private ArrayList<String> Random_requirement_list(char c){ // randomiza
		ArrayList<String> random_list = new ArrayList<String>();
		int x;
		int y;
		while(true) {
			x = gerador.nextInt(100);
			y = gerador.nextInt(100);
				
			if(x <= 30) {
				if(random_list.contains("WI-FI"));
				
				else
					random_list.add("WI-FI");
			}
			if(x > 30 && x <= 60) {
				if(random_list.contains("4G"));
				
				else
					random_list.add("4G");
			}
			if(x > 60 && x <= 80) {
				if(random_list.contains("BLUETOOTH"));
				
				else
					random_list.add("BLUETOOTH");
			}
			if(x > 80) {
				if(random_list.contains("GSM"));
				
				else
					random_list.add("GSM");
			}
			if(y > 80 && c == 'O') {
				break;
			}
			if(c == 'R') {
				break;
			}
		}
		return random_list;
	}
	
	
	private ArrayList<ArrayList<Integer>> Random_social(){ // randomiza matriz de relacionamento
		ArrayList<ArrayList<Integer>> random_list = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= quant_objetos; i++) {
			ArrayList<Integer> coluna = new ArrayList<Integer>();
			for(int j = 0; j <= quant_objetos; j++) {
					int x = gerador.nextInt(2);
					coluna.add(x);
			}
			random_list.add(coluna);
		}
		for(int i = 0; i <= quant_objetos; i++) {
			for(int j = 0; j <= quant_objetos; j++) {
				if(random_list.get(i).get(j) != random_list.get(j).get(i) && i != j){
					if(random_list.get(i).get(j) == 1) {
						random_list.get(i).set(j, 0);
					}
					else {
						random_list.get(i).set(j, 1);
					}
				}
				if(i == j) {
					random_list.get(i).set(j, 0);
				}
			}
		}
		return random_list;
	}
	
}