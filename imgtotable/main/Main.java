package main;

import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {
		
		File imageFile = new File("./image.png");
		FileWriter htmlFile = null;
		try {
			htmlFile = new FileWriter("./html.html");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		BufferedImage imageBuff = null;
		try {
			imageBuff = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		// start the html
		try {
			htmlFile.write("<html><body><table style=\"border-collapse:collapse;\">");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	
		for (int y = 0; y < imageBuff.getHeight(); y++) {
			String row = "<tr>";
			for (int x = 0; x < imageBuff.getWidth(); x++) {
				int Pixel = imageBuff.getRGB(x, y);
				Color col = new Color(Pixel);
				
				String item = "<td style=\"background-color: rgb(" + col.getRed() + "," + col.getGreen() + "," + col.getBlue() + "); width: 2px; height: 2px; padding: 0;\">";
				row += item;
			}
			row += "</tr>";
			try {
				htmlFile.write(row);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		// close the html
		try {
			htmlFile.write("</table></body></html>");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
