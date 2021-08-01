
class imagesActions{

	/**
	 * Turns the image into black and white
	 * @param image -> represents image
	 * @return imagegray -> a matrix that represents the image in black and white
	 */
	public static int[][] rgb2gray(int[][][] image){
		int[][] imagegray=new int[image[0].length][image[0][0].length];
		for (int i = 0; i < image[0].length; i++) 
			for (int j = 0; j < image[0][0].length; j++)
				imagegray[i][j]=((int)((0.3*image[0][i][j])+(0.59*image[1][i][j])+(0.11*image[2][i][j]))*(225));

		return imagegray;
	}

	/**
	 * rotate the image 90 degrees to the right
	 * @param image -> represents image
	 * @return image90 -> image after rotate
	 */
	public static int[][][] rotate90(int[][][] image){
		int[][][] image90=new int[3][image[0][0].length][image[0].length];
		for (int i = 0; i < image[0].length; i++) { 
			for (int j = 0; j < image[0][0].length; j++) {
				image90[0][image[0][0].length-1-j][image[0].length-1-i]=image[0][i][j];
				image90[1][image[0][0].length-1-j][image[0].length-1-i]=image[1][i][j];
				image90[2][image[0][0].length-1-j][image[0].length-1-i]=image[2][i][j];
			}
		}
		return image90;
	}

	
	/**
	 * Image smoothing
	 * @param image -> represents image
	 * @param n -> Smoothing level
	 * @return smooth -> image after smoothing
	 */
	public static int[][][] Smooth(int[][][] image,int n){
		if (n<=0) 
			return image;
		else {		
			int[][][]smooth=new int[3][image[0].length][image[0][0].length];
			S0(image,smooth,n);
			S1(image,smooth,n);
			S2(image,smooth,n);
			return smooth;
		}
	}	

	/**
	 * Goes on the red layer
	 * 
	 */
	private static void S0(int[][][] image,int[][][]smooth,int n){
		for (int i = 0; i < image[0].length; i++) {
			for (int j = 0; j < image[0][0].length; j++) {
				int cont=0;				
				if ((i<n)||(j<n)||(i>image[0].length-n-1)||(j>image[0][0].length-n-1))	
					smooth[0][i][j]=image[0][i][j];										
				else {
					for (int t = i; t < (2*n+1+i); t++) 	{	
						for (int r = j; r < (2*n+1+j); r++) { 					
							smooth[0][i][j]=smooth[0][i][j]+image[0][t-n][r-n];
							cont++;
						}
					}
					smooth[0][i][j]=smooth[0][i][j]/cont;
				}				
			}
		}

	}	

	/**
	 * Goes on the green layer
	 * 
	 */
	private static void S1(int[][][] image,int[][][]smooth,int n){
		for (int i = 0; i < image[0].length; i++) {
			for (int j = 0; j < image[0][0].length; j++) {
				int cont=0;
				if ((i<n)||(j<n)||(i>image[0].length-n-1)||(j>image[0][0].length-n-1))	
					smooth[1][i][j]=image[1][i][j];									
				else {
					for (int t = i; t < (2*n+1+i); t++) 	{	
						for (int r = j; r < (2*n+1+j); r++) { 					
							smooth[1][i][j]=smooth[1][i][j]+image[1][t-n][r-n];
							cont++;
						}
					}
					smooth[1][i][j]=smooth[1][i][j]/cont;

				}
			}
		}

	}	

	
	/**
	 * Goes on the blue layer
	 * 
	 */	
	private static void S2(int[][][] image,int[][][]smooth,int n){
		for (int i = 0; i < image[0].length; i++) {
			for (int j = 0; j < image[0][0].length; j++) {
				int cont=0;
				if ((i<n)||(j<n)||(i>image[0].length-n-1)||(j>image[0][0].length-n-1))	
					smooth[2][i][j]=image[2][i][j];									
				else {
					for (int t = i; t < (2*n+1+i); t++) 	{	
						for (int r = j; r < (2*n+1+j); r++) { 					
							smooth[2][i][j]=smooth[2][i][j]+image[2][t-n][r-n];
							cont++;
						}
					}
					smooth[2][i][j]=smooth[2][i][j]/cont;
				}
			}
		}
	}		


	/**
	 * Stretching the image (black and white)
	 * @param image -> image in black and whit
	 * @param factor_h -> factor height
	 * @param factor_w -> factor width
	 * @return Scaleup -> image after stretching
	 */
	public static int[][] scaleup(double factor_h, double factor_w, int[][] im){
		if (factor_h<=0||factor_h<=0) {
			return im;
		}
		else {
			int[][] Scaleup=new int[(int)(factor_h*im.length)][(int)(factor_w*im[0].length)];	
			for (int i = 0; i < Scaleup.length; i++) 
				for (int j = 0; j < Scaleup[0].length; j++)
					Scaleup[i][j]=im[(int)(i/factor_h)][(int)(j/factor_w)];	
			return Scaleup;
		}
	}
}