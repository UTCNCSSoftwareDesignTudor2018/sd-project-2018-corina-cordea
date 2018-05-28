package sd.project.presentation.proxy;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RealImage implements Image{
	JButton product;
	public RealImage(String imageFilePath) {
		
		loadImage(imageFilePath);
	}

	private void loadImage(String imageFilePath) {
		product = new JButton(new ImageIcon(imageFilePath));
		product.setOpaque(false);
		product.setContentAreaFilled(false);
		product.setBorderPainted(false);
	}

	@Override
	public JButton showImage(JPanel panel) {
		panel.add(product);
		return product;
	}
	
}
