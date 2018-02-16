import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;

public class TST {

	private TreeNode root;
	
	public TST(){
		root = null;
	}
	
	public boolean isEmpty()
    {
        return (root == null);
    }
	
	public void insert(String word, WordLocation wl)
    {
        root = insert(root, word.toCharArray(), wl, 0);
    }
    
    public TreeNode insert(TreeNode node, char[] word, WordLocation wl, int ptr)
    {
    	Locale locale = new Locale("tr");
    	Collator coll = Collator.getInstance(locale);
    	coll.setStrength(Collator.PRIMARY);
    	
    	if (node == null)
        	node = new TreeNode(word[ptr]);
    	
        if (coll.compare(Character.toString(word[ptr]), Character.toString(node.data)) == -1)
        	node.leftChild = insert(node.leftChild, word, wl, ptr);
        else if (coll.compare(Character.toString(word[ptr]), Character.toString(node.data)) == 1)
        	node.rightChild = insert(node.rightChild, word, wl, ptr);
        else
        {
            if (ptr + 1 < word.length)
            	node.midChild = insert(node.midChild, word, wl, ptr + 1);
            else{
            	node.isEnd = true;
            	node.instances.add(wl);
            }
        }
        return node;
    }
    
    public ArrayList<WordLocation> search(String word)
    {
        return search(root, word.toCharArray(), 0);
    }
 
    private ArrayList<WordLocation> search(TreeNode r, char[] word, int ptr)
    {
    	
    	Locale locale = new Locale("tr");
    	Collator coll = Collator.getInstance(locale);
    	coll.setStrength(Collator.PRIMARY);
    	
    	if (r == null)
            return null;
 
        if (coll.compare(Character.toString(word[ptr]), Character.toString(r.data)) == -1)
            return search(r.leftChild, word, ptr);
        else if (coll.compare(Character.toString(word[ptr]), Character.toString(r.data)) == 1)
            return search(r.rightChild, word, ptr);
        else
        {
            if (r.isEnd && ptr == word.length - 1)
                return r.instances;
            else if (ptr == word.length - 1)
                return null;
            else
                return search(r.midChild, word, ptr + 1);
        }        
    }
}
