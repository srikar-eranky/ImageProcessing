package org.srikar;

import images.APImage;
import images.Pixel;
import java.util.Scanner;


public class Images {
	
	private String fileName;
	//constructors, getters, and setters coded by Vishrut
	/**
	 * default constructor
	 * sets instance variable fileName to default "smokey.jpg"
	 */
	public Images(){
		fileName = "smokey.jpg";
	}
	/**
	 * 
	 * @param fileName - fileName given by user
	 * constructor
	 */
	public Images(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * getter for fileName
	 * @return - fileName
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * setter for fileName
	 * @param fName - takes the fileName entered by the user
	 */
	public void setFileName(String fName) {
		fileName = fName;
	}
	
	/**
	 * makes the image black and white
	 * coded by Atul
	 */
	public void blackAndWhite() { 
		APImage i = new APImage(fileName);
		i.draw();
		for(Pixel p : i) {
			int red = p.getRed();
			int green = p.getGreen();
			int blue = p.getBlue();
			int average = (red + green + blue) / 3;
			if(average < 128) {
				p.setRed(0);
				p.setGreen(0);
				p.setBlue(0);
			} else {
				p.setRed(255);
				p.setGreen(255);
				p.setBlue(255);
			}
		}
		System.out.println();
		i.draw();
	}
	
	/**
	 * changes the image to gray scale
	 * coded by Sid
	 */
	public void grayScale() { 
		APImage img = new APImage(fileName);
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				Pixel p = img.getPixel(i,j);
				int red = p.getRed();
				int green = p.getGreen();
				int blue = p.getBlue();
				int average = (red + green + blue) / 3;
				p.setRed(average);
				p.setGreen(average);
				p.setBlue(average);
			}
		}
		img.draw();
	}
	
	/**
	 * changes the image to luminance gray scale
	 * coded by Sid
	 */
	public void luminanceGrayScale() { 
		APImage img = new APImage(fileName);
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				Pixel p = img.getPixel(i,j);
				double red = p.getRed() * 0.299;
				double green = p.getGreen() * 0.587;
				double blue = p.getBlue() * 0.114;
				double average = (red + green + blue) / 3;
				p.setRed((int)average);
				p.setGreen((int)average);
				p.setBlue((int)average);
			}
		}
		img.draw();
	}
	
	/**
	 * rotates the image 180 degrees
	 * coded by Srikar
	 */
	public void flip() { 
		APImage original = new APImage(fileName);
		int width = original.getWidth();
		int height = original.getHeight();
		
		//make 2d array with pixels from old image
		Pixel[][] ogPixels = new Pixel[height][width];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel p = original.getPixel(x, y);
				ogPixels[y][x] = p;
			}
		}
		
		//make new image
		APImage newImage = new APImage(width,height);
		
		//make 2d array with new image
		Pixel[][] newPixels = new Pixel[height][width];
		
		//swap the pixels appropriately in the 2d array of the new image
		for(int i = 0; i < ogPixels.length; i++) {
			for(int j = 0; j < ogPixels[0].length; j++) {
				newPixels[i][j] = ogPixels[height-1-i][width-1-j];
			}
		}
		
		//set the RGB values on the new image with the RGB values from the 2d array
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel p = newImage.getPixel(x, y);
				p.setRed(newPixels[y][x].getRed());
				p.setBlue(newPixels[y][x].getBlue());
				p.setGreen(newPixels[y][x].getGreen());
			}
		}
		newImage.draw();
	}
	
	/**
	 * turns the image 90 degrees counterclockwise
	 * coded by Srikar
	 */
	public void turnLeft() { 
		APImage original = new APImage(fileName);
		int width = original.getWidth();
		int height = original.getHeight();
		
		//make 2d array with pixels from old image
		Pixel[][] ogPixels = new Pixel[height][width];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel p = original.getPixel(x, y);
				ogPixels[y][x] = p;
			}
		}
		
		//make new image
		APImage newImage = new APImage(height,width);
		
		//make 2d array with new image
		Pixel[][] newPixels = new Pixel[width][height];
		
		//swap the pixels appropriately in the 2d array of the new image
		for(int i = 0; i < ogPixels.length; i++) {
			for(int j = 0; j < ogPixels[0].length; j++) {
				newPixels[width-1-j][i] = ogPixels[i][j];
			}
		}
		
		//set the RGB values on the new image with the RGB values from the 2d array
		for(int y = 0; y < width; y++) {
			for(int x = 0; x < height; x++) {
				Pixel p = newImage.getPixel(x, y);
				p.setRed(newPixels[y][x].getRed());
				p.setBlue(newPixels[y][x].getBlue());
				p.setGreen(newPixels[y][x].getGreen());
			}
		}
		newImage.draw();
	}
	
	/**
	 * turns the image clockwise 90 degrees
	 * coded by Srikar
	 */
	public void turnRight() { 
		APImage original = new APImage(fileName);
		int width = original.getWidth();
		int height = original.getHeight();
		
		//make 2d array with pixels from old image
		Pixel[][] ogPixels = new Pixel[height][width];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel p = original.getPixel(x, y);
				ogPixels[y][x] = p;
			}
		}
		
		//make new image
		APImage newImage = new APImage(height,width);
		
		//make 2d array with new image
		Pixel[][] newPixels = new Pixel[width][height];
		
		//swap the pixels appropriately in the 2d array of the new image
		for(int i = 0; i < ogPixels.length; i++) {
			for(int j = 0; j < ogPixels[0].length; j++) {
				newPixels[j][height-1-i] = ogPixels[i][j];
			}
		}
		
		//set the RGB values on the new image with the RGB values from the 2d array
		for(int y = 0; y < width; y++) {
			for(int x = 0; x < height; x++) {
				Pixel p = newImage.getPixel(x, y);
				p.setRed(newPixels[y][x].getRed());
				p.setBlue(newPixels[y][x].getBlue());
				p.setGreen(newPixels[y][x].getGreen());
			}
		}
		newImage.draw();
	}
	
	/**
	 * makes the image look old fashioned
	 * coded by Vish
	 */
	public void oldFashioned() { 
		APImage img = new APImage(fileName);
		
		// convert to grayscale
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				Pixel p = img.getPixel(i,j);
				int red = p.getRed();
				int green = p.getGreen();
				int blue = p.getBlue();
				int average = (red + green + blue) / 3;
				p.setRed(average);
				p.setGreen(average);
				p.setBlue(average);
				
				if(p.getRed() < 63) {
					red = (int)(red * 1.1);
					blue = (int)(blue * 0.9);
				} else if(p.getRed() < 192) {
					red = (int)(red * 1.15);
					blue = (int)(blue * 0.85);
				} else {
					red = Math.min((int)(red * 1.08), 255);
					blue = (int)(blue * 0.93);
				}
				
				p.setRed(red);
				p.setBlue(blue);
			}
		}
		img.draw();
	}
	
	/**
	 * method darkens the image by a factor entered by the user.
	 * @param factor - int factor for how much the image should be darkened by
	 * coded by Atul
	 */
	public void darken(int factor) { 
		APImage img = new APImage(fileName);
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				Pixel p = img.getPixel(i, j);
				int red = p.getRed();
				if(red >= factor) {
					red -= factor;
				}
				int green = p.getGreen();
				if(green >= factor) {
					green -= factor;
				}
				int blue = p.getBlue();
				if(blue >= factor) {
					blue -= factor;
				}
				p.setRed(red);
				p.setGreen(green);
				p.setBlue(blue);
			}
		}
		img.draw();
	}
	
	/**
	 * method brightens the image by a factor entered by the user
	 * @param factor - int factor to brighten the image by
	 * coded by Atul
	 */
	public void brighten(int factor) { 
		APImage img = new APImage(fileName);
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				Pixel p = img.getPixel(i, j);
				int red = p.getRed();
				if(red + factor <= 255) {
					red += factor;
				}
				int green = p.getGreen();
				if(green + factor <= 255) {
					green += factor;
				}
				int blue = p.getBlue();
				if(blue + factor <= 255) {
					blue += factor;
				}
				p.setRed(red);
				p.setGreen(green);
				p.setBlue(blue);
			}
		}
		img.draw();
	}
	
	/**
	 * filters the image by filter entered by user
	 * coded by Vish
	 */
	public void colorFilter() { 
		APImage img = new APImage(fileName);
		//ask user for filters
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a red value for the filter: ");
		int redFilter = scan.nextInt();
		System.out.println("Enter a green value for the filter: ");
		int greenFilter = scan.nextInt();
		System.out.println("Enter a blue value for the filter: ");
		int blueFilter = scan.nextInt();
		
		for(int y = 0; y < img.getHeight(); y++) {
			for(int x = 0; x < img.getWidth(); x++) {
				Pixel p = img.getPixel(x,y);
				int red = p.getRed();
				int green = p.getGreen();
				int blue = p.getBlue();
				
				int redApplied = red + redFilter;
				int greenApplied = green + greenFilter;
				int blueApplied = blue + blueFilter;

				if(redApplied >= 255) {
					p.setRed(255);
				} else {
					p.setRed(redApplied);
				}
				
				if(greenApplied >= 255) {
					p.setGreen(255);
				} else {
					p.setGreen(greenApplied);
				}
				
				if(blueApplied >= 255) {
					p.setBlue(255);
				} else {
					p.setBlue(blueApplied);
				}
			}
		}
		img.draw();
	}
	
	/**
	 * posterizes image with two random colors
	 * certain pixels are converted to one color, all other pixels are converted to the other color
	 * coded by Srikar
	 */
	public void posterize() { 
		APImage i = new APImage(fileName);
		int firstRed = (int) (Math.random() * 256);
		int firstGreen = (int) (Math.random() * 256);
		int firstBlue = (int) (Math.random() * 256);
		
		int secondRed = (int) (Math.random() * 256);
		int secondGreen = (int) (Math.random() * 256);
		int secondBlue = (int) (Math.random() * 256);
		
		for(Pixel p : i) {
			int red = p.getRed();
			int green = p.getGreen();
			int blue = p.getBlue();
			int average = (red + green + blue) / 3;
			if(average < 128) {
				p.setRed(firstRed);
				p.setGreen(firstGreen);
				p.setBlue(firstBlue);
			} else {
				p.setRed(secondRed);
				p.setGreen(secondGreen);
				p.setBlue(secondBlue);
			}
		}
		i.draw();
	}
	
	/**
	 * makes the image look like a photographic negative
	 * coded by Vish
	 */
	public void photographic() { 
		//grayscale
		APImage img = new APImage(fileName);
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				Pixel p = img.getPixel(i,j);
				int red = p.getRed();
				int green = p.getGreen();
				int blue = p.getBlue();
				int average = (red + green + blue) / 3;
				p.setRed(average);
				p.setGreen(average);
				p.setBlue(average);
				
				p.setRed(255 - p.getRed());
				p.setGreen(255 - p.getGreen());
				p.setBlue(255 - p.getBlue());
			}
		}
		img.draw();
	}
	
	/**
	 * method sharpens the image quality
	 * joint coded by Vish, Srikar, Atul
	 */
	public void sharpen() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the threshold for detecting edges: ");
		int threshold = s.nextInt();
		
		System.out.println("Enter the degree of sharpness: ");
		int degree = s.nextInt();
		
		APImage oldImage = new APImage(fileName);
		int width = oldImage.getWidth();
		int height = oldImage.getHeight();
		
		
		for(int y = 0; y < height-1; height++) {
			for(int x = 1; x < width; x++) {
				Pixel oldPixel = oldImage.getPixel(x, y);
				Pixel leftPixel = oldImage.getPixel(x-1, y);
				Pixel bottomPixel = oldImage.getPixel(x, y+1);
				
				int oldAvg = (oldPixel.getRed() + oldPixel.getGreen() + oldPixel.getBlue()) / 3;
				int leftAvg = (leftPixel.getRed() + leftPixel.getGreen() + leftPixel.getBlue()) / 3;
				int bottomAvg = (bottomPixel.getRed() + bottomPixel.getGreen() + bottomPixel.getBlue()) / 3;
				
				if((Math.abs(oldAvg - leftAvg) <= threshold) || (Math.abs(oldAvg - bottomAvg) <= threshold) || Math.abs(bottomAvg - leftAvg) >= threshold) {
					int redApplied = bottomPixel.getRed() - degree;
					int greenApplied = bottomPixel.getGreen() - degree;
					int blueApplied = bottomPixel.getBlue() - degree;
					
					if(redApplied < 0) {
						redApplied = 0;
					}
					if(greenApplied < 0) {
						greenApplied = 0;
					}
					if(blueApplied < 0) {
						blueApplied = 0;
					}
					
					oldPixel.setRed(redApplied);
					oldPixel.setGreen(greenApplied);
					oldPixel.setBlue(blueApplied);
				} else {
					oldPixel.setRed(oldPixel.getRed());
					oldPixel.setGreen(oldPixel.getGreen());
					oldPixel.setBlue(oldPixel.getBlue());
				}
			}
		}
		oldImage.draw();
		s.close();
	}
	
	/**
	 * method blurs the image
	 * coded by Sid
	 */
	public void blur() { 
		APImage img = new APImage(fileName);
		int width = img.getWidth();
		int height = img.getHeight();
		for(int y = 1; y < height-2; y++) {
			for(int x = 0; x < width-2; x++) {
				Pixel p = img.getPixel(x, y);
				Pixel right = img.getPixel(x+1, y);
				Pixel left = img.getPixel(x-1, y);
				Pixel bottom = img.getPixel(x, y+1);
				Pixel top = img.getPixel(x, y-1);
				
				int redAvg = (right.getRed() + left.getRed() + bottom.getRed() + top.getRed()) / 4;
				int greenAvg = (right.getGreen() + left.getGreen() + bottom.getGreen() + top.getGreen()) / 4;
				int blueAvg = (right.getBlue() + left.getBlue() + bottom.getBlue() + top.getBlue()) / 4;
				
				p.setRed(redAvg);
				p.setGreen(greenAvg);
				p.setBlue(blueAvg);
			}
		}
		img.draw();
	}
	
	/**
	 * shrinks the image
	 * joint coded by everyone
	 */
	public void shrink() { 
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the shrinkage factor: ");
		int factor = s.nextInt();
		
		APImage old = new APImage(fileName);
		int oldWidth = old.getWidth();
		int oldHeight = old.getHeight();
		System.out.println(oldHeight);
		System.out.println(oldWidth);
		Pixel[][] ogPixels = new Pixel[oldHeight][oldWidth];
		for(int y = 0; y < oldHeight; y++) {
			for(int x = 0; x < oldWidth; x++) {
				Pixel p = old.getPixel(x, y);
				ogPixels[y][x] = p;
			}
		}
		System.out.println("original array length: " + ogPixels.length);
		int newWidth = oldWidth/factor;
		int newHeight = oldHeight/factor;
		System.out.println("New height: " + newHeight);
		System.out.println("New width: " + newWidth);
		APImage newImage = new APImage(newWidth, newHeight);
		Pixel[][] newPixels = new Pixel[newHeight][newWidth];
		
		
		int newCountHeight = 0;
		for(int y = 0; y < ogPixels.length; y+=factor) {
			int newCountWidth = 0;
			if(y != ogPixels.length / factor) {
				for(int x = 0; x < ogPixels[0].length; x+=factor) {
					newPixels[newCountHeight][newCountWidth] = ogPixels[y][x];
					newCountWidth++;
				}
				newCountHeight++;
			}
		}
		
		for(int y = 0; y < newHeight; y++) {
			for(int x = 0; x < newWidth; x++) {
				Pixel newPixel = newImage.getPixel(x, y);
				newPixel.setRed(newPixels[y][x].getRed());
				newPixel.setGreen(newPixels[y][x].getGreen());
				newPixel.setBlue(newPixels[y][x].getBlue());
			}
		}
		newImage.draw();
		s.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String fName = s.nextLine();
		
		boolean isValid = false;
		//error checking for valid file name - coded by Srikar
		while(!isValid) {
			if((fName.equals("") || fName.equalsIgnoreCase("arch.jpg") || fName.equalsIgnoreCase("swan.jpg") || fName.equalsIgnoreCase("seagull.jpg") || fName.equals("redMotorcyle.jpg") || fName.equalsIgnoreCase("koala.jpg") || fName.equalsIgnoreCase("butterfly1.jpg"))) {
				isValid = true;
			} else {
				System.out.println("Please enter a valid input: ");
				fName = s.nextLine();
			}
		}
		
		Images i = new Images();
		if(!(fName.equals(""))) {
			i.setFileName(fName);
		}
		//error checking for valid method name - coded by Srikar
		System.out.println("Enter the name of the method you would like to use: ");
		String methodName = s.nextLine();
		
		boolean validInput = false;
		
		while(!validInput) {
			if(methodName.equalsIgnoreCase("black and white") || methodName.equalsIgnoreCase("grayscale") || methodName.equalsIgnoreCase("luminance grayscale") || methodName.equalsIgnoreCase("rotate left") || 
				methodName.equalsIgnoreCase("rotate right") || methodName.equalsIgnoreCase("flip") || methodName.equalsIgnoreCase("old fashioned") || methodName.equalsIgnoreCase("darken") || 
				methodName.equalsIgnoreCase("brighten") || methodName.equalsIgnoreCase("color filter") || methodName.equalsIgnoreCase("posterize") || methodName.equalsIgnoreCase("photographic") || 
				methodName.equalsIgnoreCase("sharpen") || methodName.equalsIgnoreCase("blur") || methodName.equalsIgnoreCase("shrink") || methodName.equalsIgnoreCase("enlarge")) {
				validInput = true;
			} else {
				System.out.println("Please enter a valid method name: ");
				methodName = s.nextLine();
			}
		}
		// coded by Srikar
		if(methodName.equalsIgnoreCase("black and white")) {
			i.blackAndWhite();
		} else if(methodName.equalsIgnoreCase("grayscale")) {
			i.grayScale();
		} else if(methodName.equalsIgnoreCase("luminance grayscale")) {
			i.luminanceGrayScale();
		} else if(methodName.equalsIgnoreCase("rotate left")) {
			i.turnLeft();
		} else if(methodName.equalsIgnoreCase("rotate right")) {
			i.turnRight();
		} else if(methodName.equalsIgnoreCase("flip")) {
			i.flip();
		} else if(methodName.equalsIgnoreCase("old fashioned")) {
			i.oldFashioned();
		} else if(methodName.equalsIgnoreCase("darken")) {
			System.out.println("Enter the darkening factor: ");
			int factor = s.nextInt();
			i.darken(factor);
		} else if(methodName.equalsIgnoreCase("brighten")) {
			System.out.println("Enter the brightness factor: ");
			int factor = s.nextInt();
			i.brighten(factor);
		} else if(methodName.equalsIgnoreCase("color filter")) {
			i.colorFilter();
		} else if(methodName.equalsIgnoreCase("posterize")) {
			i.posterize();
		} else if(methodName.equalsIgnoreCase("photographic")) {
			i.photographic();
		} else if(methodName.equalsIgnoreCase("sharpen")) {
			i.sharpen();
		} else if(methodName.equalsIgnoreCase("blur")) {
			i.blur();
		} else if(methodName.equalsIgnoreCase("shrink")) {
			i.shrink();
		}
		
		APImage img = new APImage(i.getFileName());
		img.draw();
		//i.sharpen();
		s.close();


	}

}
