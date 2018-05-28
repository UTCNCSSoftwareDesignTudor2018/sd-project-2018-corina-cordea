package sd.project.presentation.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.stereotype.Component;

@Component
public class ProductView {
	private JFrame productFrame;
	private JPanel productPanel;
	private GridLayout productsLayout;
	private JPanel northOnlyPanel;
	private JScrollPane scroll;
	private JLabel category;
	private JComboBox<String> categories;

	public ProductView() {
		initialize();
	}

	private void initialize() {
		productFrame = new JFrame();
		productFrame.setBounds(0, 0, 600, 400);
		productFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		productFrame.setLocationRelativeTo(null);
		productFrame.getContentPane().setLayout(null);
		
		productPanel = new JPanel();
		productsLayout = new GridLayout(0, 3);
		productPanel.setLayout(productsLayout);
		productPanel.setBounds(30, 50, 500, 300);
		productPanel.setVisible(true);

		northOnlyPanel = new JPanel();
		northOnlyPanel.setLayout(new BorderLayout());
		northOnlyPanel.setBounds(30, 50, 500, 300);
		northOnlyPanel.add(productPanel, BorderLayout.NORTH);
		productFrame.getContentPane().add(northOnlyPanel);
		
		scroll = new JScrollPane(productPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(30, 50, 500, 300);
		
		category = new JLabel("Category: ");
		category.setBounds(30, 20, 100, 20);
		productFrame.getContentPane().add(category);
		
		categories = new JComboBox<String>();
		categories.setBounds(130, 20, 150, 20);
		categories.addItem("All");
		productFrame.getContentPane().add(categories);
		
		productFrame.add(scroll);
		productFrame.add(northOnlyPanel);
	}

	public JPanel getNorthOnlyPanel() {
		return northOnlyPanel;
	}

	public void setNorthOnlyPanel(JPanel northOnlyPanel) {
		this.northOnlyPanel = northOnlyPanel;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JPanel getProductPanel() {
		return productPanel;
	}

	public void setProductPanel(JPanel productPanel) {
		this.productPanel = productPanel;
	}

	public GridLayout getProductsLayout() {
		return productsLayout;
	}

	public void setProductsLayout(GridLayout productsLayout) {
		this.productsLayout = productsLayout;
	}

	public JFrame getProductFrame() {
		return productFrame;
	}

	public void setProductFrame(JFrame productFrame) {
		this.productFrame = productFrame;
	}

	public JLabel getCategory() {
		return category;
	}

	public void setCategory(JLabel category) {
		this.category = category;
	}

	public JComboBox<String> getCategories() {
		return categories;
	}

	public void setCategories(JComboBox<String> categories) {
		this.categories = categories;
	}
	public void setComboBoxActionListener(ActionListener actionListener) {
		categories.addActionListener(actionListener);
	}
	
}
