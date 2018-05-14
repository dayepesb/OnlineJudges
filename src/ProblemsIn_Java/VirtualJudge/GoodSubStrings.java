package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GoodSubStrings {
	static String word;
	static String goods;
	static int badsAllowed;
	static Trie trie;
	static boolean good[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line; (line = in.readLine()) != null;) {
			word = line.trim().toLowerCase();
			goods = in.readLine().trim();
			badsAllowed = Integer.parseInt(in.readLine());

			good = new boolean[256];
			for (int i = 0; i < 26; i++)
				if (goods.charAt(i) == '1')
					good[i + 'a'] = true;

			trie = new Trie();
			for (int l = 0; l < word.length(); l++) {
				int bad = 0;
				Node current = trie.root;
				for (int r = l + 1; r <= word.length(); r++) {
					char c = word.charAt(r - 1);
					if (!good[c])
						bad++;
					if (bad <= badsAllowed)
						current = trie.insert(c, current);
					else
						break;
				}
			}
			out.println(trie.words);

		}

		out.close();
		in.close();
	}

	static class Trie {
		Node root = new Node('\0', null);
		int words = 0;

		public Node insert(char c, Node pi) {
			Node current = pi;
			Node sub = current.subNode(c);
			if (sub != null)
				current = sub;
			else {
				current.child[c - 'a'] = new Node(c, current);
				current = current.subNode(c);
			}

			if (!current.end)
				words++;
			current.end = true;
			return current;
		}

		boolean search(String word) {
			Node current = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				Node sub = current.getChild(c);
				if (sub == null)
					return false;
			}
			return current.end;
		}
	}

	static class Node {
		char content;
		boolean end;
		Node parent;
		Node[] child = new Node[26];

		Node(char c, Node pi) {
			parent = pi;
			content = c;
		}

		public Node subNode(char c) {
			return child[c - 'a'];
		}

		Node getChild(char c) {
			return child[c - 'a'];
		}

		Node addChild(Node node) {
			return child[node.content - 'a'] = node;
		}

		@Override
		public String toString() {
			return content + " " + end;
		}
	}

}
