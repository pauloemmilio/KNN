import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KNN {
	private List<Imagem> dadosDeTreino;
	private List<Imagem> dadosDeTeste;
	private Classificador classificador;
	
	public KNN(List<Imagem> treinamento) {
		//		DIVIDIR DADOS EM 80% TREINO E 20% TESTE
		int quantTreino = (int) (treinamento.size()*0.80);
		this.dadosDeTreino = treinamento.subList(0, quantTreino);
		this.dadosDeTeste = treinamento.subList(quantTreino, treinamento.size());
	}
	
	public double classificarImagens(int K){
		int acertos = 0;
		int contImagens = 1; //		PARA COMEÇAR A CONTAGEM
		
		//		PEGA CADA IMAGEM DOS DADOS DE TESTE
		for(Imagem imagem: this.dadosDeTeste){
			System.out.println("Classificando imagem N°: "+contImagens);
			contImagens++;
			//		PRA CADA IMAGEM DOS DADOS DE TESTE, VAI SER CRIADO UMA LISTA DE DISTÂNCIAS DAS OUTRAS IMAGENS
			List<Distancia> distancias = new ArrayList<>();
			
			//		PEGA CADA IMAGEM DOS DADOS DE TREINO
			for(int i = 0; i < dadosDeTreino.size(); i++){
				
				//		COMPARA CADA IMAGEM DOS DADOS DE TREINO E A IMAGEM ATUAL DOS DADOS DE TESTE
				//		ENCONTRAR OS VIZINHOS MAIS PRÓXIMOS
				double distancia = Distancia.calcularDistancia(this.dadosDeTreino.get(i), imagem);
				distancias.add(new Distancia(distancia, this.dadosDeTreino.get(i)));
			}
			
			Collections.sort(distancias);
			classificador = new Classificador();
			
			for(int i = 0; i < K; i++){	
				//		PEGA O RÓTULO DE CADA IMAGEM DA LISTA DE TREINO
				int rotulo = distancias.get(i).getImagem().getRotulo();
				rotular(rotulo);
			}
			
			//		ATRIBUIR UMA CLASSIFICAÇÃO PARA A IMAGEM ATUAL DA LISTA DE TESTE
			int classificacaoDaImagem = classificador.classificar();
			
			//		ANALISAR SE A CLASSIFICAÇÃO QUE FOI DADA, ESTÁ IGUAL AO RÓTULO DA IMAGEM
			if(classificacaoDaImagem == imagem.getRotulo()){
				acertos++;
			}
			
		}
		
		//		PORCENTAGEM DE ACERTOS
		return (acertos*100)/this.dadosDeTeste.size();
	}
	
	//		DEFINIR FREQUENCIA DE CADA ROTULO DAS IMAGENS DA LISTA DE TREINO
	private void rotular(int rotulo){
		classificador.contador(rotulo);
	}
}