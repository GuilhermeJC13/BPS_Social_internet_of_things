package Main;

import java.util.ArrayList;
import Objects.Objects;

public class Main {
	
	static Objects obj = new Objects();
	
	public Main() {
	}
	
	public static void main(String [] args) {
		ArrayList<ArrayList<ArrayList<String>>> objeto = iniciar_objetos();
		
		System.out.println("Requerente: " + conversor(obj.getReq()));
		System.out.println("Pre-requisito: " + obj.getReqList());
		System.out.println("Servicos: " + obj.getReqSer());
		
		ArrayList<Character> service_list = BPS(obj.getReqSer(), obj.getReqList(), obj.getReq(), obj.getSocial(), objeto, obj.getQuant());
		
		System.out.println("Possibilidades: " + service_list);
		
		System.out.println("");
		
		for(int i = 0; i <= obj.getQuant(); i++) {
				System.out.println(obj.getSocial().get(i));
		}
		
		System.out.println("");
		
		System.out.println("-=-=-=-=-=-=-=-Objects-=-=-=-=-=-=-=-");
		for(int i = 0; i <= obj.getQuant(); i++) {
			if(i != obj.getReq()) {
				System.out.println("------------------" + conversor(i) + "------------------");
				System.out.println("Habilidades: " + objeto.get(i).get(0));
				System.out.println("Informacoes: " + objeto.get(i).get(1));
			}
		}
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
	}
	//busca por perfil social
	private static ArrayList<Character> BPS(ArrayList<String> required_service_list, ArrayList<String> requirement_list, int requester, ArrayList<ArrayList<Integer>> social_network, ArrayList<ArrayList<ArrayList<String>>> objeto, int tamanho){ // busca por perfil social
		ArrayList<Character> service_list = new ArrayList<Character>(); // Array com os possiveis objetos
		ArrayList<Integer> relacionados = new ArrayList<Integer>(); // Array de amigos
		ArrayList<Integer> utilizados = new ArrayList<Integer>(); // Array dos objetos analizados
		
		int search_cont = tamanho; //
		int atual = requester;
		
		while(search_cont >= 0) {
			if(required_service_list.size() == 0) {
				break;
			}
			for(int i = 0; i <= tamanho; i++) {
				if(social_network.get(atual).get(i) == 1 && i != requester) {
					utilizados.add(i);
					relacionados.add(i);
				}
			}
			for(int i = 0; i < relacionados.size(); i++) {
				for(int j = 0; j < objeto.get(relacionados.get(i)).get(1).size(); j++) {
					if(requirement_list.contains(objeto.get(relacionados.get(i)).get(1).get(j))) {
						for(int k = 0; k < required_service_list.size(); k++) {
							if(objeto.get(relacionados.get(i)).get(0).contains(required_service_list.get(k))) {
								if(!service_list.contains(conversor(relacionados.get(i)))) {
									service_list.add(conversor(relacionados.get(i)));
								}
								required_service_list.remove(k);
								k--;
							}
						}
					}
				}
			}
			search_cont--;//
			if(utilizados.size() > 0) {
				atual = utilizados.get(0);
				utilizados.remove(0);
			}
		}
		if(required_service_list.size() <= 0) {
			System.out.println("Status: Busca feita com sucesso!!");
		}
		else {
			System.out.println("Status: Busca sem sucesso!!");
		}
		
		return service_list;
	}
	
	private static char conversor(int x) { // converte numero para Alfabeto
		int y = 0;
		for(char c = 'A'; c <= 'Z'; c++) {
			if(y == x) {
				return c;
			}
			y++;
		}
		return 'Z';
	}
	
	private static  ArrayList<ArrayList<ArrayList<String>>> iniciar_objetos() { // inicia os objetos
		ArrayList<ArrayList<ArrayList<String>>> objeto = new ArrayList<ArrayList<ArrayList<String>>>();
		
		for(int i = 0; i <= obj.getQuant(); i++) {
			ArrayList<ArrayList<String>> AUX = new ArrayList<ArrayList<String>>();
			Objects o = new Objects();
			
			AUX.add(o.getservList());
			AUX.add(o.getInfo());
			
			objeto.add(AUX);
		}
		
		return objeto;
	}
}