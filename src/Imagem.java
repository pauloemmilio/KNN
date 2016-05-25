
public class Imagem {

	private int rotulo;
	private int[] arrayPixels;
	
	public Imagem(int rotulo, int[] pixels) {
		this.rotulo = rotulo;
		this.arrayPixels = pixels;
	}
	
	public int getRotulo() {
		return rotulo;
	}
	public void setRotulo(int rotulo) {
		this.rotulo = rotulo;
	}
	public int[] getPixels() {
		return arrayPixels;
	}
	public void setPixelMatriz(int[] arrayPixels) {
		this.arrayPixels = arrayPixels;
	}

}
