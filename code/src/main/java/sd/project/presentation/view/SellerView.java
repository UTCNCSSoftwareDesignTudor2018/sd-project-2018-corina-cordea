package sd.project.presentation.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class SellerView {

		private JFrame sellerFrame;
		private JPanel sellerPanel;
		public SellerView() {
			initialize();
		}
		private void initialize() {
			sellerFrame = new JFrame("Seller");
			sellerFrame.setBounds(100, 100, 600, 400);
			sellerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			sellerFrame.setLocationRelativeTo(null);
			sellerFrame.getContentPane().setLayout(null);
			
			sellerPanel = new JPanel();
			sellerPanel.setLayout(null);
			sellerPanel.setBounds(100, 100, 600, 400);
			sellerPanel.setVisible(true);
			sellerFrame.getContentPane().add(sellerPanel);
			
			sellerFrame.repaint();
		}
		public JFrame getSellerFrame() {
			return sellerFrame;
		}
		public void setSellerFrame(JFrame sellerFrame) {
			this.sellerFrame = sellerFrame;
		}
		public JPanel getSellerPanel() {
			return sellerPanel;
		}
		public void setSellerPanel(JPanel sellerPanel) {
			this.sellerPanel = sellerPanel;
		}
		
		
	}

