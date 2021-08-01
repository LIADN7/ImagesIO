
public class examples {

	public static void main(String[] args) {
		int[][][] a=MyImageIO.readImageFromFile("./img/cat.jpg");
		int[][] b=imagesActions.rgb2gray(a);	
		MyImageIO.writeImageToFile("./img/gray_cat", b);
		MyImageIO.writeImageToFile("./img/rotate90_cat", imagesActions.rotate90(a));
		MyImageIO.writeImageToFile("./img/scaleup_cat", imagesActions.scaleup(2, 3, b));
		MyImageIO.writeImageToFile("./img/Smooth_cat", imagesActions.Smooth(a, 7));
		
	}

}
