import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			List<Imagem> imagens = carregarArquivo();
			KNN knn = new KNN(imagens);
			double classificacao = knn.classificarImagens(1);
			System.out.println("Taxa de sucesso: "+classificacao+"%");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Imagem> carregarArquivo() throws FileNotFoundException{
		Scanner leitor = new Scanner(new FileReader("mnisttrain.csv"));
		leitor.nextLine();
		
		//		CADA LINHA DO ARQUIVO, VIRA UM ARRAY DE PIXELS
		List<Imagem> imagens = new ArrayList<>();
		while (leitor.hasNextLine()) {
			String[] linha = leitor.nextLine().split(",");
			int rotulo = Integer.parseInt(linha[0]);
			int[] pixels = new int[784];
			int linhaInicial = 1;
			for(int i = 0; i < pixels.length; i++){
				pixels[i] = Integer.parseInt(linha[linhaInicial]);
				linhaInicial++;
			}
			imagens.add(new Imagem(rotulo, pixels));
		}
		return imagens;
	}
}
