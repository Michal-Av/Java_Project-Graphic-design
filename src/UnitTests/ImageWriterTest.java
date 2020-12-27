package UnitTests;

import java.awt.Color;

import Renderer.ImageWriter;

import org.junit.Test;

public class ImageWriterTest {

	
	@Test
	public void test() {
		ImageWriter imageWriter=new ImageWriter("ImageTest", 500,500,10,10);
		
		for(int i=0;i<imageWriter.getHeight();i++)
		{
			for(int j=0;j<imageWriter.getWidth();j++)
			{
				if(i%50==0 || j%50==0)
					imageWriter.writePixel(i, j, new Color(255,255,255));
			}
		}
		
		imageWriter.writeToImage();		
	}

}