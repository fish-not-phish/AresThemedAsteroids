package com.aresThemeAsteroids;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Frames {
	private ArrayList<BufferedImage> frames;
	
	public Frames(String name) {
		frames =  new ArrayList<BufferedImage>();
		String pn = "./resources/sprites/" + name + ".pn";
		String png = "./resources/sprites/" + name + ".png";
		File filePn = new File(pn);
		File filePng = new File(png);
		try {
			BufferedImage master = ImageIO.read(filePng);
			Scanner s = new Scanner (filePn);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				int top = 0, bottom = 0, left = 0, right = 0;
				if (line.contains("{")) {
					String data = line.substring(line.indexOf('{') + 1, line.indexOf('}'));
					String[] properties = data.split(",");
					for (String property : properties) {
						String[] tokens =  property.split(":");
						String propertyName = tokens[0].strip();
						int propertyValue = Integer.parseInt(tokens[1].strip());
						if (propertyName.equals("top")) {
							top = propertyValue;
						}
						else if (propertyName.equals("bottom")) {
							bottom = propertyValue;
						}
						else if (propertyName.equals("left")) {
							left = propertyValue;
						}
						else if (propertyName.equals("right")) {
							right = propertyValue;
						}
					}
					int w = right - left;
					int h = bottom - top;
					BufferedImage subImage = master.getSubimage(left, top, w, h);
					frames.add(subImage);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BufferedImage> getFrames() {
		return frames;
	}
}
