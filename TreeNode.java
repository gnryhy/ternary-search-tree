import java.util.ArrayList;

public class TreeNode {

	char data;
	boolean isEnd;
	TreeNode leftChild, midChild, rightChild;
	ArrayList<WordLocation> instances = new ArrayList<>();
	
	public TreeNode(char data){
		
		this.data = data;
		this.isEnd = false;
		this.leftChild = null;
		this.rightChild = null;
		this.midChild = null;
		this.instances = new ArrayList<>();
	}
	
	public void addNewWord(WordLocation wl){
		this.instances.add(wl);
	}
	
	public ArrayList<WordLocation> getInstances(){
		return instances;
	}

	
}
