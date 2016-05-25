
public class Classificador {
	
	private int[] frequencia;
	
	public Classificador() {
		this.frequencia = new int[]{0,0,0,0,0,0,0,0,0,0};
	}
	
	public void contador(int rotulo){
		if(rotulo == 0){
			this.frequencia[0] ++;
		}
		if(rotulo == 1){
			this.frequencia[1] ++;
		}
		if(rotulo == 2){
			this.frequencia[2] ++;
		}
		if(rotulo == 3){
			this.frequencia[3] ++;
		}
		if(rotulo == 4){
			this.frequencia[4] ++;
		}
		if(rotulo == 5){
			this.frequencia[5] ++;
		}
		if(rotulo == 6){
			this.frequencia[6] ++;
		}
		if(rotulo == 7){
			this.frequencia[7] ++;
		}
		if(rotulo == 8){
			this.frequencia[8] ++;
		}
		if(rotulo == 9){
			this.frequencia[9] ++;
		}
	}
	
	//		A MAIOR CHANCE DE CLASSIFICAÇÃO É A DO MAIS FREQUENTE
	//		CLASSIFICAÇÃO SERÁ O RÓTULO DA MAIORIA DOS VIZINHOS
	public int classificar(){
		int maior = 0; 
		for(int k = 0; k < this.frequencia.length; k++){
			if(this.frequencia[k] > this.frequencia[maior]){
				maior = k;
			}
		}
		return maior;
	}
}
