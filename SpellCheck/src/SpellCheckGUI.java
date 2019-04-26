import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class SpellCheckGUI {

	//Start Embedded Class
	private class BSTGUI<T extends Comparable<T>> {

		private class BSTNode<T> {
			private T data;
			private BSTNode<T> leftChild;
			private BSTNode<T> rightChild;

			public BSTNode(T dataValue) {
				this.data = dataValue;
				this.leftChild = null;
				this.rightChild = null;
			}
		}

		BSTNode<T> root;

		public BSTGUI() {

			root = null;
		}

		public boolean isEmpty() {

			return (root == null);
		}

		public void resetTree() {

			root = null;
			return;
		}

		public void insert(T item) {

			BSTNode<T> newNode = new BSTNode<T>(item);

			if (isEmpty()) {
				root = newNode;
				return;
			}

			BSTNode<T> currentNode = root;
			BSTNode<T> trailCurrentNode = root;

			while (currentNode != null) {
				if (currentNode.data.compareTo(item) <= 0) {
					trailCurrentNode = currentNode;
					currentNode = currentNode.rightChild;
				} else {
					trailCurrentNode = currentNode;
					currentNode = currentNode.leftChild;
				}
			}

			if (trailCurrentNode.data.compareTo(item) <= 0)// flag I think this should be < not <=
				trailCurrentNode.rightChild = newNode;
			else
				trailCurrentNode.leftChild = newNode;
			return;
		}

		private String traversePreOrderStartingAt(BSTNode<T> subTreeRoot) {

			if (subTreeRoot == null)
				return "";

			String str = (subTreeRoot.data + " ");
			str = str + traversePreOrderStartingAt(subTreeRoot.leftChild);
			str = str + traversePreOrderStartingAt(subTreeRoot.rightChild);
			return str;
		}

		public String preOrderTraversal() {

			String str = traversePreOrderStartingAt(root);

			return str;
		}

		private String traverseInOrderStartingAt(BSTNode<T> subTreeRoot) {

			String str = "";
			if (subTreeRoot == null)
				return str;

			str = traverseInOrderStartingAt(subTreeRoot.leftChild);
			str = str + subTreeRoot.data + " ";
			str = str + traverseInOrderStartingAt(subTreeRoot.rightChild);

			return str;
		}

		public String inOrderTraversal() {

			String str = traverseInOrderStartingAt(root);

			return str;
		}

		private String traversePostOrderStartingAt(BSTNode<T> subTreeRoot) {

			String str = "";
			if (subTreeRoot == null)
				return str;

			str = str + traversePostOrderStartingAt(subTreeRoot.leftChild);
			str = str + traversePostOrderStartingAt(subTreeRoot.rightChild);
			str = str + subTreeRoot.data + " ";

			return str;
		}

		public String postOrderTraversal() {

			String str = traversePostOrderStartingAt(root);

			return str;
		}

		private int countNodesStartingAt(BSTNode<T> subTreeRoot) {

			if (subTreeRoot == null)
				return 0;

			return (1 + countNodesStartingAt(subTreeRoot.leftChild) + countNodesStartingAt(subTreeRoot.rightChild));

		}

		public int getNodeCount() {

			int treeNodeCount = 0;

			if (!isEmpty())
				treeNodeCount = countNodesStartingAt(root);

			return treeNodeCount;
		}

		private int countLeafNodesStartingAt(BSTNode<T> subTreeRoot) {

			if (subTreeRoot == null)
				return 0;

			if (subTreeRoot.leftChild == null && subTreeRoot.rightChild == null)
				return 1;

			return (countLeafNodesStartingAt(subTreeRoot.leftChild) + countLeafNodesStartingAt(subTreeRoot.rightChild));

		}

		public int getLeafNodeCount() {

			int leafNodeCount = 0;

			if (!isEmpty())
				leafNodeCount = countLeafNodesStartingAt(root);

			return leafNodeCount;
		}

		private int maximumOfTwoHeights(int heightOfLeftSubtree, int heightOfRightSubTree) {

			if (heightOfLeftSubtree >= heightOfRightSubTree)
				return heightOfLeftSubtree;
			else
				return heightOfRightSubTree;
		}

		private int computeHeightOfSubTreeRootedAt(BSTNode<T> subTreeRoot) {

			if (subTreeRoot == null)
				return 0;
			if (subTreeRoot.leftChild == null && subTreeRoot.rightChild == null)
				return 0;
			return (1 + maximumOfTwoHeights(computeHeightOfSubTreeRootedAt(subTreeRoot.leftChild),
					computeHeightOfSubTreeRootedAt(subTreeRoot.rightChild)));
		}

		public int getTreeHeight() {

			int treeHeight = 0;

			if (!isEmpty())
				treeHeight = computeHeightOfSubTreeRootedAt(root);
			return treeHeight;
		}

		public boolean searchFor(T item) {

			boolean found = false;

			if (isEmpty()) {
				System.out.println("Tree is empty.");
				return found;
			}

			BSTNode<T> currentNode = root;

			while (!found && currentNode != null) {
				if (currentNode.data.compareTo(item) == 0)
					found = true;
				else if (currentNode.data.compareTo(item) < 0)
					currentNode = currentNode.rightChild;
				else
					currentNode = currentNode.leftChild;
			}

			return found;
		}

		public void delete(T item) {

			if (isEmpty()) {
				System.out.println("Tree is empty.");
				return;
			}

			boolean found = false;
			BSTNode<T> currentNode = root;
			BSTNode<T> trailCurrentNode = root;

			while (!found && currentNode != null) {
				if (currentNode.data.compareTo(item) == 0)
					found = true;
				else {
					trailCurrentNode = currentNode;
					if (currentNode.data.compareTo(item) < 0)
						currentNode = currentNode.rightChild;
					else
						currentNode = currentNode.leftChild;
				}
			}

			return;
		}
	}
	//End Embedded Class

	//Variables for the GUI
	private JFrame frame;
	static DefaultListModel model = new DefaultListModel();
	static JList list = new JList(model);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SpellCheckGUI window = new SpellCheckGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SpellCheckGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Spell Checker Program");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(41, 31, 297, 42);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Run Spell Checker");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					SpellCheck();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(50, 100, 163, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnButton = new JButton("Reset");
		btnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.clear();
			}
		});
		btnButton.setBounds(50, 150, 163, 23);
		frame.getContentPane().add(btnButton);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		exitButton.setBounds(50, 200, 163, 23);
		frame.getContentPane().add(exitButton);

		list.setBounds(216, 108, 158, 142);
		frame.getContentPane().add(list);
		JScrollPane pane = new JScrollPane(list);

		JLabel lblMisspelledWords = new JLabel("Misspelled Words");
		lblMisspelledWords.setBounds(254, 83, 120, 14);
		frame.getContentPane().add(lblMisspelledWords);

		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(250, 108, 175, 142);
		scroll.createVerticalScrollBar();
		frame.getContentPane().add(scroll);
	}

	private void SpellCheck() throws FileNotFoundException {
		BSTGUI<String> dictionary = new BSTGUI<>();
		Scanner file = new Scanner(new File ("dictionary.txt"));
		while (file.hasNext()) {
			dictionary.insert(file.nextLine());
		}
		file.close();

		BSTGUI<String> misspelled = new BSTGUI<>();
		Scanner scan = new Scanner(new File ("sampleText.txt"));
		while (scan.hasNext()) {
			String temp = scan.nextLine().replaceAll("[.,]", "");
			String[] array = temp.split(" ");
			for(int i = 0; i < array.length; i++)
				if( !dictionary.searchFor(array[i]))
					misspelled.insert(array[i]);
		}
		scan.close();

		if (misspelled.isEmpty())
			System.out.println("There are no misspelled words");
		else {
			String str = misspelled.inOrderTraversal();
			String[] options = str.split(" ");
			model.clear();
			for(int i = 0; i < options.length; i++)
				model.addElement(options[i]);
		}
	}
}
