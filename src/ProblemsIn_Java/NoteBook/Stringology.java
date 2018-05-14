package ProblemsIn_Java.NoteBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Stringology {

	class RabinKarpModular {
		// patron que se va a buscar
		private String pat;
		// hash del patron
		private long patHash;
		// tama�o del patron
		private int M;
		// primo muy grande
		private final long PRIME = 1000000007;
		// el tama�o del lenguaje sobre el que se trabaja en este caso ascii extendido
		private int R = 256;

		private long RM;

		public RabinKarpModular(String pat) {
			this.pat = pat;
			// tama�o del patron
			M = pat.length();
			RM = 1;
			for (int i = 1; i <= M - 1; i++) // calcula R^(M-1)%Q
				RM = (R * RM) % PRIME;
			patHash = hash(pat, M);
		}

		// saca el hash del patron que se le pasa
		private long hash(String key, int M) {
			long h = 0;
			for (int j = 0; j < M; j++)
				h = (R * h + key.charAt(j)) % PRIME;
			return h;
		}

		// busca el patron en el txt
		private int search(String txt) {
			int N = txt.length();
			long txtHash = hash(txt, M);
			if (patHash == txtHash && check(txt, 0)) // casamento
				return 0;
			for (int i = 1; i <= N - M; i++) {
				txtHash = (txtHash + PRIME - RM * txt.charAt(i - 1) % PRIME) % PRIME;
				txtHash = (txtHash * R + txt.charAt(i + M - 1)) % PRIME;
				if (patHash == txtHash)
					if (check(txt, i))
						return i;
			}
			return N;
		}

		public boolean check(String txt, int i) {
			return true; // Monte Carlo
		}
	}

	class Permutaciones {
		public void permutaciones(char[] perm, char[] sec, int[] used, int index) {
			if (index == perm.length) {
				String sal = "";
				for (int i = 0; i < perm.length; i++) {
					sal += perm[i];
				}
				System.out.println(sal);
				return;
			}
			for (int i = 0; i < used.length; i++) {
				if (used[i] != 0) {
					perm[index] = sec[i];
					used[i]--;
					permutaciones(perm, sec, used, index + 1);
					used[i]++;
				}
			}
		}
	}

	class FuerzaBruta {
		ArrayList<Integer> fuerzaBruta(String cadena, String patron) {
			int count = 0;
			ArrayList<Integer> index = new ArrayList<>();
			for (int i = 0, j = 0; i < cadena.length(); i++) {
				if (cadena.charAt(i) == patron.charAt(j)) {
					j++;
					count++;
				} else {
					count = 0;
					j = 0;
				}

				if (count == patron.length()) {
					count = 0;
					j = 0;
					index.add(i);
				}
			}
			return index;
		}
	}

	class KMP {
		int KMP(char[] palabraConsult, char[] cadena) { // �ndice donde ocurre S
														// en
														// W.
			// T=getBorderArray(W).
			int T[] = getBorderkMP(cadena); /////

			if (palabraConsult.length == 0)
				return 0;
			for (int m = 0, i = 0; m + i < cadena.length;) {
				if (palabraConsult[i] == cadena[m + i]) {
					if (++i == palabraConsult.length)
						return m;
				} else {
					m += i - T[i];
					if (i > 0)
						i = T[i];
				}
			}
			return -1;
		}

		int[] getBorderkMP(char[] cadena) {
			int[] T = new int[cadena.length + 1];
			T[0] = -1;
			T[1] = 0;
			for (int i = 2, j = 0; i <= cadena.length;) {
				if (cadena[i - 1] == cadena[j])
					T[i++] = ++j;
				else if (j > 0)
					j = T[j];
				else
					T[i++] = 0;
			}
			return T;
		}
	}

	class permutacionesDeUnaPalabra {
		int count = 0;

		HashSet<String> dictionary;

		public void combinaciones(String primero, String cadena) {
			if (cadena.length() == 2) {
				count = count + 2;
				dictionary.add(primero + cadena.charAt(1) + "" + cadena.charAt(0));
				dictionary.add(primero + cadena.charAt(0) + "" + cadena.charAt(1));
			} else {
				for (int i = 0; i < cadena.length(); i++) {
					combinaciones(primero + cadena.charAt(i), quitarLetra(cadena, i));
				}
			}
		}

		public String quitarLetra(String cadena, int i) {
			if (i == 0) {
				return cadena.substring(i + 1, cadena.length());
			} else {
				if (i == cadena.length()) {
					return cadena.substring(0, cadena.length() - 1);
				} else {
					return cadena.substring(0, i) + cadena.substring(i + 1, cadena.length());
				}
			}
		}
	}

	class AhoCorasick {
		/*
		char[] T = in.next().toCharArray();
		int Q = in.nextInt();
		AhoCorasick aho = new AhoCorasick((int) 1e6 + 1);
		char[][] subs = new char[Q][];
		for (int i = 0; i < Q; ++i)
			aho.addString(subs[i] = in.next().toCharArray());
		aho.dfs(T);
		for (int i = 0; i < Q; ++i)
			out.println(aho.good(subs[i]) ? "y" : "n");
		*/
		int getChar(char c) {
			if (c >= 'a' && c <= 'z')
				return c - 'a';
			return 26 + c - 'A';
		}

		class AhoCorasickObject {

			final int k = 52;

			class Node {
				int p, c, link = -1;
				boolean leaf, good;

				Node(int a, int b) {
					p = a;
					c = b;
				}

				int[] next = new int[k], go = new int[k];
				{
					Arrays.fill(next, -1);
					Arrays.fill(go, -1);
				}
			}

			Node[] nodes;
			int nodeCount;

			AhoCorasickObject(int maxNodes) {
				nodes = new Node[maxNodes];
				nodes[nodeCount++] = new Node(0, -1);
			}

			void addString(char[] s) {
				int cur = 0;
				for (char ch : s) {
					int c = getChar(ch);
					if (nodes[cur].next[c] == -1) {
						nodes[nodeCount] = new Node(cur, c);
						nodes[cur].next[c] = nodeCount++;
					}
					cur = nodes[cur].next[c];
				}
				nodes[cur].leaf = true;
			}

			int link(int vIdx) {
				Node v = nodes[vIdx];
				if (v.link == -1)
					v.link = v.p == 0 ? 0 : go(link(v.p), v.c);
				return v.link;
			}

			int go(int vIdx, int c) {
				Node v = nodes[vIdx];
				if (v.go[c] == -1)
					v.go[c] = v.next[c] != -1 ? v.next[c] : vIdx == 0 ? 0 : go(link(vIdx), c);
				return v.go[c];
			}

			void dfs(char[] s) {
				int cur = 0;
				for (char c : s) {
					cur = go(cur, getChar(c));
					nodes[cur].good = true;
				}
				for (int i = 1; i < nodeCount; ++i)
					if (nodes[i].good) {
						cur = link(i);
						while (!nodes[cur].good) {
							nodes[cur].good = true;
							cur = link(cur);
						}
					}
			}

			boolean good(char[] s) {
				int cur = 0;
				for (char c : s)
					cur = go(cur, getChar(c));
				return nodes[cur].good;
			}
		}

	}

	class trie {
		class Trie {
			Node root = new Node('\0', null);

			void insert(String word) {
				Node current = root;
				for (int i = 0; i < word.length(); i++) {
					char c = word.charAt(i);
					Node sub = current.getChild(c);
					if (sub != null)
						current = sub;
					else {
						current.addChild(new Node(c, current));
						current = current.getChild(c);
					}
					if (i == word.length() - 1)
						current.ends = true;
				}
			}

			boolean search(String word) {
				Node current = root;
				for (int i = 0; i < word.length(); i++) {
					char c = word.charAt(i);
					Node sub = current.getChild(c);
					if (sub == null)
						return false;
				}
				return current.ends;
			}

			class Node {
				char content;
				boolean ends;
				Node parent;
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

	}

	class BoyerMooreHorspool {
		int[] D1;

		int boyerMooreHorspool(String text, String pattern, int size) {

			char P[] = pattern.trim().toCharArray();
			char T[] = text.trim().toCharArray();
			int offSet = 0;
			int scan = 0;
			int last = P.length - 1;
			int maxOffSet = T.length - P.length;
			preBoyerMooreSuffixBad(P, size);

			while (offSet <= maxOffSet) {
				for (scan = last; P[scan] == T[scan + offSet]; scan--) {
					if (scan == 0)
						return offSet;
				}
				offSet += D1[T[offSet + last]];
			}

			return -1;

		}

		void preBoyerMooreSuffixBad(char P[], int size) {
			int m = P.length;
			int last = m - 1;
			D1 = new int[size];
			Arrays.fill(D1, m);
			for (int i = 0; i < last; i++) {
				D1[P[i]] = last - i;
			}
		}
	}
	class FuntionZ{
		public int[] z(int f, String cad) {

			int[] z = new int[cad.length()];
			int l = 0, r = 0, n = cad.length();
			for (int i = 1; i < n; i++) {
				if (i > r) {
					l = r = i;
					while (r < n && cad.charAt(r - l) == cad.charAt(r))
						r++;
					z[i] = r - l;
					r--;
				} else {
					int k = i - l;
					if (z[k] < r - i + 1)
						z[i] = z[k];
					else {
						l = i;
						while (r < n && cad.charAt(r - l) == cad.charAt(r))
							r++;
						z[i] = r - l;
						r--;
					}
				}
			}
			return Arrays.copyOfRange(z, f, z.length);
		}
	}

	class SuffixArray{
		
	}
}
