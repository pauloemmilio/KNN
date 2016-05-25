
public class Distancia implements Comparable<Distancia>{
	private double distancia;
	private Imagem imagem;
	
	public Distancia(double distancia, Imagem imagem) {
		this.distancia = distancia;
		this.imagem = imagem;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public Imagem getImagem() {
		return imagem;
	}
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	@Override
	public int compareTo(Distancia distancia) {
		if(this.distancia > distancia.getDistancia())
			return 1;
		else if(this.distancia < distancia.getDistancia())
			return -1;
		return 0;
	}
	
	//		MÉTODO PARA CALCULAR A DISTÂNCIA EUCLIDIANA (ADAPTADO DA INTERNET) 
	public static double calcularDistancia(Imagem imagem1, Imagem imagem2){
		double distancia = 0;
		for(int k=0; k < imagem1.getPixels().length; k++){
			
			//		RECEBE O ARRAY DE PIXELS DA IMAGEM A SER TESTADA, COM O ARRAY DE PIXELS DAS IMAGENS DOS
			//		DADOS DE TREINO E COMPARA AS DIFERENÇAS ENTRE ELAS
			int diferenca = imagem1.getPixels()[k] - imagem2.getPixels()[k];
			distancia += diferenca * diferenca;
		}
		return Math.sqrt(distancia);
	}

}
