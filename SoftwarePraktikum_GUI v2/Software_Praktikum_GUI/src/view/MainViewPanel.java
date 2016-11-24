package view;

import model.MainModel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import java.awt.event.*;

public class MainViewPanel extends JFrame{
	
	private int nodeID = 0;
	// JFrame Components
	private JButton m_addComponentButton = new JButton("Add Component");
	private JButton m_editPropertyButton = new JButton("Edit Property");
	private JButton m_removePropertyButton = new JButton("Remove Property");
	
	private JButton m_addPropertyButton1 = new JButton("Add Property");
	private JButton m_addPropertyButton2 = new JButton("Add Property");
	
	private JButton m_addPortButton1 = new JButton("Add Port");
	private JButton m_addPortButton2 = new JButton("Add Port");
	private JButton m_addPortButton3 = new JButton("Add Port");
	private JButton m_addPortButton4 = new JButton("Add Port");
	private JButton m_removePortButton1 = new JButton("Remove Port");
	private JButton m_removePortButton2 = new JButton("Remove Port");
	
	private JButton m_chooseReceiverButton = new JButton("Choose Receiver");
	private JButton m_sendButton = new JButton("Send");
	
	private JMenuItem m_send = new JMenuItem("Send");
	private JMenuItem m_receive = new JMenuItem("Receive");
	
	// JMenu
	private JMenu m_fileMenu = new JMenu("File");
	private JMenu m_editMenu = new JMenu("Edit");
	private JMenu m_portMenu = new JMenu("Port");
	
	private JMenuItem m_newAction = new JMenuItem("New");
    private JMenuItem m_openAction = new JMenuItem("Open");
    private JMenuItem m_exitAction = new JMenuItem("Exit");
    
    private JMenuItem m_AddComponent = new JMenuItem("Add Component");
	private JMenuItem m_RemoveComponent = new JMenuItem("Remove Component");
	private JMenuItem m_EditComponent = new JMenuItem("Edit Component");
	
	private JMenuItem m_PortList = new JMenuItem("List of Ports");
	
	private JComboBox m_ComboBox1;
	private JComboBox m_ComboBox2;
	
	private JTextField m_CompName;
	private JTextField m_CompValue;
	private JTextField m_PortNumber;
	
	private JTextField m_PropName;
	private JTextField m_PropValue;
	
	private JTextField m_receiver;
	
	private JList m_List1;
	private JList m_List2;
	private JList m_List3;
	private JList m_List4;
	private JList m_List5;
	private JList m_List6;
    
	DefaultMutableTreeNodeID root;
	
    JPanel m_panel;
    JTree m_tree;
    JScrollPane m_scrollPanel;
    JMenuBar m_menuBar;
    
    JPopupMenu m_popupMenu1;
    JPopupMenu m_popupMenu2;
    
    JDialog m_dialog1;
    JDialog m_dialog2;
    JDialog m_dialog3;
    JDialog m_dialog4;
    JDialog m_dialog5;
    JDialog m_dialog6;
    JDialog m_dialog7;
    JDialog m_dialog8;
    
    JLabel m_nameLabel;
    JLabel m_valueLabel;
    
	private static final int INITIALVALUE = 0;
	
	public MainViewPanel()
	{
	    addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent e) 
	    	{
	    		System.exit(0);
	      	}
	    });
	    Toolkit tk = Toolkit.getDefaultToolkit();
	   	Dimension screenSize = tk.getScreenSize();
	   	int screenHeight = screenSize.height;
	   	int screenWidth = screenSize.width;
	   	this.setSize(screenWidth / 2, screenHeight / 2);
    	this.setLocation(screenWidth / 4, screenHeight / 4);
		
		
		m_panel = new JPanel();
		m_menuBar = new JMenuBar();
		m_scrollPanel = new JScrollPane();
		m_tree = new JTree();
		
		m_popupMenu1 = new JPopupMenu();
		m_popupMenu2 = new JPopupMenu();
		
		m_dialog1 = new JDialog();
		m_dialog2 = new JDialog();
		m_dialog3 = new JDialog(); 
		m_dialog4 = new JDialog(); 
		m_dialog5 = new JDialog();
		m_dialog6 = new JDialog();
		m_dialog7 = new JDialog();
		m_dialog8 = new JDialog();
		
		
		m_CompName = new JTextField(16);
		m_CompValue = new JTextField(16);
		
		m_PropName = new JTextField(16);
		m_PropValue = new JTextField(16);
		
		m_PortNumber = new JTextField(16);
		
		m_receiver = new JTextField(16);
		
		m_List1 = new JList();
		m_List2 = new JList();
		m_List3 = new JList();
		m_List4 = new JList();
		m_List5 = new JList();
		m_List6 = new JList();
		
		m_nameLabel = new JLabel("Name:", JLabel.LEFT);
		m_valueLabel = new JLabel("Value", JLabel.LEFT);
		
		MouseHandler mouseHandler = new MouseHandler();
		root = new DefaultMutableTreeNodeID(nodeID++, "Root");
		
		m_dialog1.setSize(300,300);
		m_dialog1.setLayout(new FlowLayout());
		m_dialog1.add(m_CompName);
		m_dialog1.add(m_CompValue);
		m_dialog1.add(m_addComponentButton);
		
		
		JPanel m_d2Panel = new JPanel();
		String[] portTypes = {"Mixed Port", "Input Port", "Output Port"};
		m_ComboBox1 = new JComboBox(portTypes);
		m_d2Panel.setLayout(new GridBagLayout());
		GridBagConstraints cs2 = new GridBagConstraints();
		cs2.gridx = 1;
		cs2.gridy = 0;
		cs2.gridwidth = 2;
		m_d2Panel.add(m_ComboBox1, cs2);
		JLabel m_dialog4label3 = new JLabel("Number: ");
		cs2.gridx = 0;
		cs2.gridy = 1;
		cs2.gridwidth = 1;
		m_d2Panel.add(m_dialog4label3, cs2);
		cs2.gridx = 1;
		cs2.gridy = 1;
		cs2.gridwidth = 2;
		m_d2Panel.add(m_PortNumber, cs2);
		cs2.gridx = 1;
		cs2.gridy = 2;
		cs2.gridwidth = 2;
		m_d2Panel.add(m_addPortButton2, cs2);
		m_dialog2.setContentPane(m_d2Panel);
		m_dialog2.pack();
		
		JPanel m_d3Panel = new JPanel();
		JScrollPane m_ScrollPane1 = new JScrollPane(m_List1);
		JScrollPane m_ScrollPane3 = new JScrollPane(m_List3);
		m_d3Panel.setLayout(new GridBagLayout());
		GridBagConstraints cs3 = new GridBagConstraints();
		cs3.gridx = 1;
		cs3.gridy = 0;
		cs3.gridwidth = 2;
		cs3.gridheight = 2;
		cs3.weightx = 1;
		cs3.weighty = 1;
		cs3.fill = GridBagConstraints.BOTH;
		m_d3Panel.add(m_ScrollPane1, cs3);
		cs3.gridx = 1;
		cs3.gridy = 2;
		cs3.gridwidth = 2;
		cs3.gridheight = 2;
		cs3.weightx = 1;
		cs3.weighty = 1;
		cs3.fill = GridBagConstraints.BOTH;
		m_d3Panel.add(m_ScrollPane3, cs3);
		cs3.gridx = 3;
		cs3.gridy = 0;
		cs3.gridheight = 1;
		cs3.gridwidth = 2;
		m_d3Panel.add(m_addPropertyButton1, cs3);
		cs3.gridx = 3;
		cs3.gridy = 1;
		m_d3Panel.add(m_removePropertyButton, cs3);
		/*cs3.gridx = 3;
		cs3.gridy = 2;
		cs3.gridwidth = 2;
		m_d3Panel.add(m_editPropertyButton, cs3);*/
		cs3.gridx = 3;
		cs3.gridy = 2;
		m_d3Panel.add(m_addPortButton3, cs3);
		cs3.gridx = 3;
		cs3.gridy = 3;
		m_d3Panel.add(m_removePortButton2, cs3);
		m_dialog3.setContentPane(m_d3Panel);
		m_dialog3.pack();
		
		JPanel m_d4Panel = new JPanel();
		m_d4Panel.setLayout(new GridBagLayout());
		GridBagConstraints cs4 = new GridBagConstraints();
		JLabel m_dialog4label1 = new JLabel("Name: ");
		cs4.gridx = 0;
		cs4.gridy = 0;
		cs4.gridwidth = 1;
		cs4.fill = GridBagConstraints.BOTH;
		m_d4Panel.add(m_dialog4label1, cs4);
		cs4.gridx = 1;
		cs4.gridy = 0;
		cs4.gridwidth = 2;
		m_d4Panel.add(m_PropName, cs4);
		JLabel m_dialog4label2 = new JLabel("Value: ");
		cs4.gridx = 0;
		cs4.gridy = 1;
		cs4.gridwidth = 1;
		m_d4Panel.add(m_dialog4label2, cs4);
		cs4.gridx = 1;
		cs4.gridy = 1;
		cs4.gridwidth = 2;
		m_d4Panel.add(m_PropValue, cs4);
		cs4.gridx = 1;
		cs4.gridy = 2;
		cs4.gridwidth = 2;
		m_d4Panel.add(m_addPropertyButton2, cs4);
		m_dialog4.setContentPane(m_d4Panel);
		m_dialog4.pack();
		
		JPanel m_d5Panel = new JPanel();
		JScrollPane m_ScrollPane2 = new JScrollPane(m_List2);
		m_d5Panel.setLayout(new GridBagLayout());
		GridBagConstraints cs5 = new GridBagConstraints();
		cs5.gridx = 1;
		cs5.gridy = 0;
		cs5.gridwidth = 2;
		cs5.gridheight = 3;
		cs5.weightx = 1;
		cs5.weighty = 1;
		cs5.fill = GridBagConstraints.BOTH;
		m_d5Panel.add(m_ScrollPane2, cs5);
		cs5.gridx = 3;
		cs5.gridy = 0;
		cs5.gridheight = 1;
		cs5.gridwidth = 2;
		m_d5Panel.add(m_addPortButton1, cs5);
		cs5.gridx = 3;
		cs5.gridy = 1;
		cs5.gridwidth = 2;
		m_d5Panel.add(m_removePortButton1, cs5);
		m_dialog5.setContentPane(m_d5Panel);
		m_dialog5.pack();
		
		JPanel m_d6Panel = new JPanel();
		JScrollPane m_ScrollPane4 = new JScrollPane(m_List4);
		m_d6Panel.setLayout(new GridBagLayout());
		GridBagConstraints cs6 = new GridBagConstraints();
		cs6.gridx = 0;
		cs6.gridy = 0;
		cs6.gridwidth = 2;
		cs6.gridheight = 3;
		cs6.weightx = 1;
		cs6.weighty = 1;
		cs6.fill = GridBagConstraints.BOTH;
		m_d6Panel.add(m_ScrollPane4, cs6);
		cs6.gridx = 3;
		cs6.gridy = 0;
		cs6.gridwidth = 2;
		m_d6Panel.add(m_addPortButton4, cs6);
		m_dialog6.setContentPane(m_d6Panel);
		m_dialog6.pack();
		
		JPanel m_d7Panel = new JPanel();
		m_d7Panel.setLayout(new GridBagLayout());
		GridBagConstraints cs7 = new GridBagConstraints();
		cs7.gridx = 0;
		cs7.gridy = 0;
		cs7.gridwidth = 2;
		m_d7Panel.add(m_receiver);
		cs7.gridx = 0;
		cs7.gridy = 1;
		cs7.gridwidth = 2;
		m_d7Panel.add(m_chooseReceiverButton, cs7);
		m_dialog7.setContentPane(m_d7Panel);
		m_dialog7.pack();
		
		JPanel m_d8Panel = new JPanel();
		m_d8Panel.setLayout(new GridBagLayout());
		JScrollPane m_ScrollPane5 = new JScrollPane(m_List5);
		JScrollPane m_ScrollPane6 = new JScrollPane(m_List6);
		GridBagConstraints cs8 = new GridBagConstraints();
		JLabel m_dialog8label1 = new JLabel("Input Port:");
		JLabel m_dialog8label2 = new JLabel("Output Port:");
		cs8.gridx = 0;
		cs8.gridy = 0;
		m_d8Panel.add(m_dialog8label1, cs8);
		cs8.gridx = 2;
		cs8.gridy = 0;
		m_d8Panel.add(m_dialog8label2, cs8);
		cs8.gridx = 0;
		cs8.gridy = 1;
		cs8.gridwidth = 2;
		cs8.gridheight = 3;
		cs8.weightx = 1;
		cs8.weighty = 1;
		cs8.fill = GridBagConstraints.BOTH;
		m_d8Panel.add(m_ScrollPane5, cs8);
		cs8.gridx = 2;
		m_d8Panel.add(m_ScrollPane6, cs8);
		cs8.gridx = 0;
		cs8.gridy = 4;
		cs8.gridwidth = 2;
		cs8.gridheight = 1;
		m_d8Panel.add(m_sendButton, cs8);
		m_dialog8.setContentPane(m_d8Panel);
		m_dialog8.pack();
		
		m_panel.setLayout(new BorderLayout());
		
		m_popupMenu1.add(m_AddComponent);
		m_popupMenu1.add(m_RemoveComponent);
		m_popupMenu1.addSeparator();
		m_popupMenu1.add(m_send);
		//m_popupMenu1.add(m_receive);
		
		m_menuBar.add(m_fileMenu);
		m_menuBar.add(m_editMenu);
		m_menuBar.add(m_portMenu);
		
		m_fileMenu.add(m_newAction);
	    m_fileMenu.add(m_openAction);
	    m_fileMenu.addSeparator();
	    m_fileMenu.add(m_exitAction);
	    
	    m_editMenu.add(m_EditComponent);
	    
	    m_portMenu.add(m_PortList);
		
		// ... finalize
		this.setContentPane(m_panel);
		this.setJMenuBar(m_menuBar);
		
		m_tree = new JTree(root);
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
	
	public void setList1(int size, String[][] matrix)
	{
		String[] label = new String[size];
		DefaultListModel m = new DefaultListModel();
		
		for(int i = 0; i < size; i++)
		{
			label[i] = matrix[i][0] + " (value: " + (String)matrix[i][1] + ")";
			m.addElement(label[i]);
		}
		
	    m_List1.setModel(m);
	}

	public void setList2(String[] portList)
	{
		DefaultListModel m = new DefaultListModel();
		
		for(int i = 0; i < portList.length; i++)
		{
			m.addElement(portList[i]);
		}
		
		m_List2.setModel(m);
	}
	
	public void setList3(String[] portList)
	{
		DefaultListModel m = new DefaultListModel();
		
		for(int i = 0; i < portList.length; i++)
		{
			m.addElement(portList[i]);
		}
		
		m_List3.setModel(m);
	}
	
	public void setList4(String[] portList)
	{
		DefaultListModel m = new DefaultListModel();
		
		for(int i = 0; i < portList.length; i++)
		{
			m.addElement(portList[i]);
		}
		
		m_List4.setModel(m);
	}
	
	public void setList5(String[] portList)
	{
		DefaultListModel m = new DefaultListModel();
		
		for(int i = 0; i < portList.length; i++)
		{
			m.addElement(portList[i]);
		}
		
		m_List5.setModel(m);
	}
	
	public void setList6(String[] portList)
	{
		DefaultListModel m = new DefaultListModel();
		
		for(int i = 0; i < portList.length; i++)
		{
			m.addElement(portList[i]);
		}
		
		m_List6.setModel(m);
	}
	
	public int getPortToComp()
	{
		return Integer.parseInt((String)m_List4.getSelectedValue());
	}
	
	public int getPortNumber()
	{
		return Integer.parseInt(m_PortNumber.getText());
	}
	
	public String getPortType()
	{
		return (String)m_ComboBox1.getSelectedItem();
	}
	
	public String getCompName()
	{
		return m_CompName.getText();
	}

	public String getCompValue()
	{
		return m_CompValue.getText();
	}
	
	public String getPropName()
	{
		return m_PropName.getText();
	}
	
	public String getPropValue()
	{
		return m_PropValue.getText();
	}
	
	public String getReceiverValue()
	{
		return m_receiver.getText();
	}
	
	public int getCurrentID()
	{
		return nodeID;
	}
	
	public int getCompID()
	{
		return ((DefaultMutableTreeNodeID) m_tree.getLastSelectedPathComponent()).getNodeID();
	}
	
	public int getSelectedIndexList1()
	{
		return m_List1.getSelectedIndex();
	}
	
	public void showAddDialogComponent()
	{
		m_dialog1.setVisible(true);
	}
	
	public void showDialogAddPortToComp()
	{
		m_dialog6.setVisible(true);
	}
	
	public void hideDialogAddPortToComp()
	{
		m_dialog6.setVisible(false);
	}
	
	public void showDialogAddPort()
	{
		m_dialog2.setVisible(true);
	}
	
	public void hideDialogAddPort()
	{
		m_dialog2.setVisible(false);
	}
	
	public void showAddDialogEdit()
	{
		m_dialog3.setVisible(true);
	}
	
	public void showAddDialogEditProperty()
	{
		m_dialog4.setVisible(true);
	}
	
	public void hideAddDialogEditProperty()
	{
		m_dialog4.setVisible(false);
	}
	
	public void showDialogPortList()
	{
		m_dialog5.setVisible(true);
	}
	
	public void showDialogSend1()
	{
		m_dialog7.setVisible(true);
	}
	
	public void hideDialogSend1()
	{
		m_dialog7.setVisible(false);
	}
	
	public void showDialogSend2()
	{
		m_dialog8.setVisible(true);
	}
	
	public void hideDialogSend2()
	{
		m_dialog8.setVisible(false);
	}
	
	// Listener Interfaces
	public void addSendListener1(ActionListener aListener) 
	{
		m_send.addActionListener(aListener);
    }
	
	public void addSendListener2(ActionListener aListener) 
	{
		m_chooseReceiverButton.addActionListener(aListener);
    }
	
	public void addSendListener3(ActionListener aListener) 
	{
		m_sendButton.addActionListener(aListener);
    }
	
	public void addReceiveListener(ActionListener aListener) 
	{
		m_receive.addActionListener(aListener);
    }
	
	public void addRemovePortFromCompListener1(ActionListener aListener) 
	{
		m_removePortButton2.addActionListener(aListener);
    }
	
	public void addAddPortToCompListener1(ActionListener aListener) 
	{
		m_addPortButton3.addActionListener(aListener);
    }
	
	public void addAddPortToCompListener2(ActionListener aListener) 
	{
        m_addPortButton4.addActionListener(aListener);
    }
	
	public void addAddListenerComponent(ActionListener aListener) 
	{
        m_AddComponent.addActionListener(aListener);
    }
	
	public void addListenerPortList(ActionListener aListener) 
	{
        m_PortList.addActionListener(aListener);
    }
	
	public void addAddPortListener1(ActionListener aListener) 
	{
        m_addPortButton1.addActionListener(aListener);
    }
	
	public void addAddPortListener2(ActionListener aListener)
	{
		m_addPortButton2.addActionListener(aListener);
	}
	
	public void addAddComponentButton(ActionListener aListener)
	{
		m_addComponentButton.addActionListener(aListener);
	}
	
	public void addEditPropertyButton1(ActionListener aListener)
	{
		m_editPropertyButton.addActionListener(aListener);
	}
	
	public void addAddPropertyButton1(ActionListener aListener)
	{
		m_addPropertyButton1.addActionListener(aListener);
	}
	
	public void addAddPropertyButton2(ActionListener aListener)
	{
		m_addPropertyButton2.addActionListener(aListener);
	}
	
	public void addRemovePropertyButton(ActionListener aListener)
	{
		m_removePropertyButton.addActionListener(aListener);
	}
	
	public void addRemoveComponent(ActionListener aListender)
	{
		m_RemoveComponent.addActionListener(aListender);
	}
	
	public void addEditComponent(ActionListener aListender)
	{
		m_EditComponent.addActionListener(aListender);
	}
	
	public String getComponentName()
	{
		return m_tree.getSelectionPath().getLastPathComponent().toString();
	}
	
	public void removeComponent()
	{
		DefaultTreeModel treeModel = (DefaultTreeModel) m_tree.getModel();
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) m_tree.getSelectionPath().getLastPathComponent();
		treeModel.removeNodeFromParent(parentNode);
		
		m_tree.setModel(treeModel);
	}
	
	public void addTreeNode(String name)
	{
		DefaultMutableTreeNodeID parentNode = (DefaultMutableTreeNodeID) m_tree.getLastSelectedPathComponent();
		DefaultMutableTreeNodeID childNode = new DefaultMutableTreeNodeID(nodeID++, name);
		parentNode.add(childNode);
		
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		m_tree.setModel(treeModel);
		
		m_dialog1.setVisible(false);
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = (int) e.getPoint().getX();
	        int y = (int) e.getPoint().getY();
	        TreePath path = m_tree.getPathForLocation(x, y);
			
	        try
	        {
	        	if(path != null &&
	        			e.isPopupTrigger()) m_popupMenu1.show(MainViewPanel.this, e.getX(), e.getY());
	        }
	        catch(Exception exception)
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
		public void mousePressed(MouseEvent e) {
			int x = (int) e.getPoint().getX();
	        int y = (int) e.getPoint().getY();
	        TreePath path = m_tree.getPathForLocation(x, y);
			
	        try
	        {
	        	if(path != null &&
	        			e.isPopupTrigger()) m_popupMenu1.show(MainViewPanel.this, e.getX(), e.getY());
	        }
	        catch(Exception exception)
	        {
	        	
	        }
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) 
		{
			int x = (int) e.getPoint().getX();
	        int y = (int) e.getPoint().getY();
	        TreePath path = m_tree.getPathForLocation(x, y);
	        
	        if (path == null) 
	        {
	            m_tree.setCursor(Cursor.getDefaultCursor());
	        }
	        else 
	        {
	            m_tree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        }
		}
	}
}

class DefaultMutableTreeNodeID extends DefaultMutableTreeNode {
    private int nodeID = -1;

    public DefaultMutableTreeNodeID(Object o) {
        super(o);
    }

    public DefaultMutableTreeNodeID(int nodeID, Object o) {
        super(o);
        this.nodeID = nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getNodeID() {
        return nodeID;
    }
}
