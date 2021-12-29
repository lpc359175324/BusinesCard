package ikeyven._stsg.util;

import java.util.ArrayList;

public class TreeParser {
	public ArrayList<Node> list = new ArrayList<>();
	public ArrayList<Replace> replace = new ArrayList<>();

	public TreeParser(Node node) {
		Visit(node);
	}

	public void Visit(Node node) {
		java.util.Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node front = queue.peek();
			list.add(front);
			for (int i = 0; i < front.list.size(); i++) {
				queue.offer(front.list.get(i));
			}
			queue.poll();
		}
	}

	public void Visit(Node r1, Node r2) {
		if (r2.att.text.indexOf("#") >= 0 && !r2.att.text.equals("#0")) {
			replace.add(new Replace(r1.att.text, r2.att.text));
		}
		for (int i = 0; i < r1.list.size(); i++) {
			Visit(r1.list.get(i), r2.list.get(i));
		}
	}

	public void Visit_Target(Node t) {
		if (replace.size() == 0) {
			return;
		}
		for (int i = 0; i < replace.size(); i++) {
			if (t.att.text.equals(replace.get(i).id)) {
				t.att.text = replace.get(i).word;
				replace.remove(i);
				break;
			}
		}
		for (int i = 0; i < t.list.size(); i++) {
			Visit_Target(t.list.get(i));
		}
	}
}

class Replace {
	public String word = null;
	public String id = null;

	public Replace(String word, String id) {
		this.word = word;
		this.id = id;
	}
}
