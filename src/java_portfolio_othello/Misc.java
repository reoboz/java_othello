package java_portfolio_othello;

import java.util.List;

public class Misc {
	public static <E> E getLastElement(List<E> list) {
		if (list != null && list.isEmpty() == false) {
			int lastIndex = list.size() - 1;
			E lastElement = list.get(lastIndex);
			return lastElement;	
		} else {
			return null;
		}
	}
}
