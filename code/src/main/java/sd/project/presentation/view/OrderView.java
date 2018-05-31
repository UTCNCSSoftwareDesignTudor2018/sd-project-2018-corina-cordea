package sd.project.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

@Component
public class OrderView {
	private JFrame viewClientOrdersFrame;
	private JPanel viewClientOrdersPanel;
	private JFrame viewOrdersFrame;
	private JPanel viewOrdersPanel;
	private JTable orders;
	private JTable clientOrders;
	private JTextArea clientOrderTextArea;
	private JTextArea orderTextArea;
	private ListSelectionModel orderRowSelectionModel;
	private ListSelectionModel clientOrderRowSelectionModel;
	private JLabel statusLabel;
	private JTextField statusTextField;
	private JButton updateStatus;

	public OrderView() {
		initialize();
	}

	private void initialize() {
		orders = new JTable();
		clientOrders = new JTable();
		orderRowSelectionModel = orders.getSelectionModel();
		clientOrderRowSelectionModel = clientOrders.getSelectionModel();
		updateStatus = new JButton("Update Status");
		clientOrderTextArea = new JTextArea();
	}

	public void viewOrders() {
		viewOrdersFrame = new JFrame("Orders");
		viewOrdersFrame.setBounds(0, 0, 600, 400);
		viewOrdersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewOrdersFrame.setLocationRelativeTo(null);
		viewOrdersFrame.getContentPane().setLayout(null);

		viewOrdersPanel = new JPanel();
		viewOrdersPanel.setLayout(null);
		viewOrdersPanel.setBounds(0, 0, 600, 400);
		viewOrdersPanel.setVisible(true);

		statusLabel = new JLabel("Order Status");
		statusLabel.setBounds(50, 15, 150, 20);
		viewOrdersPanel.add(statusLabel);
		
		statusTextField = new JTextField();
		statusTextField.setBounds(225, 15, 150, 20);
		viewOrdersPanel.add(statusTextField);
		
		updateStatus.setBounds(400, 15, 150, 20);
		viewOrdersPanel.add(updateStatus);

		orders.setBounds(50, 50, 500, 130);
		orders.setVisible(true);
		orders.setRowSelectionAllowed(true);
		orderRowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		viewOrdersPanel.add(orders);
		JScrollPane scrollPane = new JScrollPane(orders);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 50, 500, 130);
		viewOrdersFrame.add(scrollPane);

		orderTextArea = new JTextArea();
		orderTextArea.setBounds(50, 200, 500, 150);
		orderTextArea.setEditable(false);

		viewOrdersPanel.add(orderTextArea);
		JScrollPane scrollPaneArea = new JScrollPane(orderTextArea);
		scrollPaneArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneArea.setBounds(50, 200, 500, 150);
		viewOrdersFrame.add(scrollPaneArea);

		viewOrdersFrame.add(viewOrdersPanel);
	}

	public void viewClientOrders() {
		viewClientOrdersFrame = new JFrame("Client Orders");
		viewClientOrdersFrame.setBounds(0, 0, 600, 400);
		viewClientOrdersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewClientOrdersFrame.setLocationRelativeTo(null);
		viewClientOrdersFrame.getContentPane().setLayout(null);

		viewClientOrdersPanel = new JPanel();
		viewClientOrdersPanel.setLayout(null);
		viewClientOrdersPanel.setBounds(0, 0, 600, 400);
		viewClientOrdersPanel.setVisible(true);

		clientOrders.setBounds(50, 30, 500, 150);
		clientOrders.setVisible(true);
		clientOrders.setRowSelectionAllowed(true);
		clientOrderRowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		viewClientOrdersPanel.add(clientOrders);
		JScrollPane scrollPane = new JScrollPane(clientOrders);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 30, 500, 150);
		viewClientOrdersFrame.add(scrollPane);

		clientOrderTextArea.setBounds(50, 200, 500, 150);
		clientOrderTextArea.setEditable(false);

		viewClientOrdersPanel.add(clientOrderTextArea);
		JScrollPane scrollPaneArea = new JScrollPane(clientOrderTextArea);
		scrollPaneArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneArea.setBounds(50, 200, 500, 150);
		viewClientOrdersFrame.add(scrollPaneArea);

		viewClientOrdersFrame.add(viewClientOrdersPanel);
	}

	public JFrame getViewOrdersFrame() {
		return viewOrdersFrame;
	}

	public void setViewOrdersFrame(JFrame viewOrdersFrame) {
		this.viewOrdersFrame = viewOrdersFrame;
	}

	public JPanel getViewOrdersPanel() {
		return viewOrdersPanel;
	}

	public void setViewOrdersPanel(JPanel viewOrdersPanel) {
		this.viewOrdersPanel = viewOrdersPanel;
	}

	public JTable getOrders() {
		return orders;
	}

	public void setOrders(JTable orders) {
		this.orders = orders;
	}

	public JTextArea getOrderTextArea() {
		return orderTextArea;
	}

	public void setOrderTextArea(JTextArea orderTextArea) {
		this.orderTextArea = orderTextArea;
	}

	public ListSelectionModel getOrderRowSelectionModel() {
		return orderRowSelectionModel;
	}

	public JTable getClientOrders() {
		return clientOrders;
	}

	public void setClientOrders(JTable clientOrders) {
		this.clientOrders = clientOrders;
	}

	public JFrame getViewClientOrdersFrame() {
		return viewClientOrdersFrame;
	}

	public void setViewClientOrdersFrame(JFrame viewClientOrdersFrame) {
		this.viewClientOrdersFrame = viewClientOrdersFrame;
	}

	public JPanel getViewClientOrdersPanel() {
		return viewClientOrdersPanel;
	}

	public void setViewClientOrdersPanel(JPanel viewClientOrdersPanel) {
		this.viewClientOrdersPanel = viewClientOrdersPanel;
	}

	public JTextArea getClientOrderTextArea() {
		return clientOrderTextArea;
	}

	public void setClientOrderTextArea(JTextArea clientOrderTextArea) {
		this.clientOrderTextArea = clientOrderTextArea;
	}

	public ListSelectionModel getClientOrderRowSelectionModel() {
		return clientOrderRowSelectionModel;
	}
	public JLabel getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(JLabel statusLabel) {
		this.statusLabel = statusLabel;
	}

	public JTextField getStatusTextField() {
		return statusTextField;
	}

	public void setStatusTextField(JTextField statusTextField) {
		this.statusTextField = statusTextField;
	}

	public JButton getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(JButton updateStatus) {
		this.updateStatus = updateStatus;
	}

	public void setClientOrderRowSelectionModel(ListSelectionModel clientOrderRowSelectionModel) {
		this.clientOrderRowSelectionModel = clientOrderRowSelectionModel;
	}

	public void setOrderRowSelectionModel(ListSelectionModel orderRowSelectionModel) {
		this.orderRowSelectionModel = orderRowSelectionModel;
	}

	public void setOrdersTableListener(ListSelectionListener listListener) {
		orderRowSelectionModel.addListSelectionListener(listListener);
	}

	public void setClientOrdersTableListener(ListSelectionListener listListener) {
		clientOrderRowSelectionModel.addListSelectionListener(listListener);
	}

	public DefaultTableModel getOrderTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[] { "Order id", "Date", "Status", "Total Price" }, 0);
		return tableModel;
	}
	public void setUpdateStatusActionListener(ActionListener actionListener) {
		updateStatus.addActionListener(actionListener);
	}
}
