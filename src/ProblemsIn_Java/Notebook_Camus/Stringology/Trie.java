package ProblemsIn_Java.Notebook_Camus.Stringology;

class Trie {
	Node root = new Node('\0', null);
	void insert(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node sub = current.getChild(c);
			if (sub != null) current = sub;
			else {
				current.addChild(new Node(c, current));
				current = current.getChild(c);
			}
			if (i == word.length() - 1) current.ends = true;
		}
	}
	boolean search(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node sub = current.getChild(c);
			if (sub == null) return false;
		}
		return current.ends;
	}
	class Node {
		char content; boolean ends; Node parent;
		Node[] child = new Node[26];
		Node(char c, Node pi) {
			parent = pi;
			content = c;
		}
		Node getChild(char c) {
			return child[c - 'a'];
		}
		Node addChild(Node node) {
			return child[node.content - 'a'] = node;
		}
	}
}
