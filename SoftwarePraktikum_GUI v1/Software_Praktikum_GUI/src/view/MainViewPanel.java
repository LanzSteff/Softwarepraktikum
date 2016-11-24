package view;

import model.MainModel;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.event.*;

public class MainViewPanel extends JFrame{
	
	// JFrame Components
	private JButton m_addComponentButton = new JButton("Add Component");
	private JButton m_addPortButton = new JButton("Add Port");
	
	// JMenu
	private JMenu m_fileMenu = new JMenu("File");
	private JMenu m_editMenu = new JMenu("Edit");
	
	private JMenuItem m_newAction = new JMenuItem("New");
    private JMenuItem m_openAction = new JMenuItem("Open");
    private JMenuItem m_exitAction = new JMenuItem("Exit");
    
    private JMenuItem m_AddComponent = new JMenuItem("Add Component");
	private JMenuItem m_RemoveComponent = new JMenuItem("Remove Component");
	private JMenuItem m_EditComponent = new JMenuItem("Edit Component");
	
	private JMenuItem m_AddPort = new JMenuItem("Add Port");
	private JMenuItem m_RemovePort = new JMenuItem("Remove Port");
	
	private JTextField m_CompName;
	private JTextField m_CompValue;
    
	DefaultMutableTreeNode root;
	
    JPanel m_panel;
    JTree m_tree;
    JScrollPane m_scrollPanel;
    JMenuBar m_menuBar;
    
    JPopupMenu m_popupMenu1;
    JPopupMenu m_popupMenu2;
    
    JDialog m_dialog1;
    JDialog m_dialog2;
    
    JLabel m_nameLabel;
    JLabel m_valueLabel;
    
	private static final int INITIALVALUE = 0;
	
	public MainViewPanel()
	{
		m_panel = new JPanel();
		m_menuBar = new JMenuBar();
		m_scrollPanel = new JScrollPane();
		m_tree = new JTree();
		
		m_popupMenu1 = new JPopupMenu();
		m_popupMenu2 = new JPopupMenu();
		
		m_dialog1 = new JDialog();
		m_dialog2 = new JDialog();
		
		m_CompName = new JTextField(16);
		m_CompValue = new JTextField(16);
		
		m_nameLabel = new JLabel("Name:", JLabel.LEFT);
		m_valueLabel = new JLabel("Value", JLabel.LEFT);
		
		root = new DefaultMutableTreeNode("root");
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		root.add(new DefaultMutableTreeNode("CPU"));
		MouseHandler mouseHandler = new MouseHandler();
		
		m_dialog1.setSize(300,300);
		m_dialog1.setLayout(new FlowLayout());
		m_dialog1.add(m_CompName);
		m_dialog1.add(m_CompValue);
		m_dialog1.add(m_addComponentButton);
		
		m_dialog2.setSize(300,300);
		m_dialog2.setLayout(new FlowLayout());
		m_dialog2.add(m_addPortButton);
		
		m_panel.setLayout(new BorderLayout());
		
		m_popupMenu1.add(m_AddComponent);
		
		m_popupMenu2.add(m_AddPort);
		m_popupMenu2.add(m_RemovePort);
		m_popupMenu2.addSeparator();
		m_popupMenu2.add(m_EditComponent);
		m_popupMenu2.add(m_RemoveComponent);
		
		m_menuBar.add(m_fileMenu);
		m_menuBar.add(m_editMenu);
		
		m_fileMenu.add(m_newAction);
	    m_fileMenu.add(m_openAction);
	    m_fileMenu.addSeparator();
	    m_fileMenu.add(m_exitAction);
		
		// ... finalize
		this.setContentPane(m_panel);
		this.setJMenuBar(m_menuBar);
		
		m_tree = new JTree(treeModel);
		m_tree.addMouseListener(mouseHandler);
		m_tree.addMouseMotionListener(mouseHandler);
		
		m_scrollPanel.getViewport().add(m_tree);
		
		this.add(m_scrollPanel, BorderLayout.CENTER);
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		this.pack();
		this.setTitle("GUI Main");
		this.setSize(400, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getCompName()
	{
		return m_CompName.getText();
	}

	public String getCompValue()
	{
		return m_CompValue.getText();
	}
	
	public void showAddDialogComponent()
	{
		m_dialog1.setVisible(true);
	}
	
	public void showAddDialogPort()
	{
		m_dialog2.setVisible(true);
	}
	
	// Listener Interfaces
	public void addAddListenerComponent(ActionListener aListener) 
	{
        m_AddComponent.addActionListener(aListener);
    }
	
	public void addAddListenerPort(ActionListener aListener) 
	{
        m_AddPort.addActionListener(aListener);
    }
	
	public void addAddComponentButton(ActionListener aListener)
	{
		m_addComponentButton.addActionListener(aListener);
	}
	
	public void addRemoveComponent(ActionListener aListender)
	{
		m_RemoveComponent.addActionListener(aListender);
	}
	
	public String getComponentName()
	{
		return m_tree.getSelectionPath().getLastPathComponent().toString();
	}
	
	public void removeComponent()
	{
		root.remove((DefaultMutableTreeNode) m_tree.getSelectionPath().getLastPathComponent());
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		
		m_tree.setModel(treeModel);
	}
	
	public void addTreeNode(String name)
	{
		root.add(new DefaultMutableTreeNode(name));
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		m_tree.setModel(treeModel);
		
		m_dialog1.setVisible(false);
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent event) {
			try
			{
				DefaultMutableTreeNode node = null;
				
				if(m_tree.getSelectionPath() != null) node = (DefaultMutableTreeNode) m_tree.getSelectionPath().getLastPathComponent();
				
				if(node != null)
					if ((event.getButton() == MouseEvent.BUTTON3 && m_tree.getSelectionPath() != null && node.getDepth() == 1) || node == root) 
					{
						m_popupMenu1.show(MainViewPanel.this, event.getX(), event.getY());
					}
					else if(event.getButton() == MouseEvent.BUTTON3 && m_tree.getSelectionPath() != null && node.getDepth() == 0)
					{
						m_popupMenu2.show(MainViewPanel.this, event.getX(), event.getY());
					}
			}
			catch(NullPointerException e)
			{
				
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}
	
}
