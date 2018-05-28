package sd.project.presentation.proxy;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ImageProxy implements Image{

private String imageFilePath;
	
	private Image proxifiedImage;
	
	
	public ImageProxy(String imageFilePath) {
		this.imageFilePath= imageFilePath;	
	}
	
	@Override
	public JButton showImage(JPanel panel) {
		
		proxifiedImage = new RealImage(imageFilePath);
		return proxifiedImage.showImage(panel);
		
	}

}
