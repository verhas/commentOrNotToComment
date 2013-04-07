package stock;

public class There {
	private final StockExchangeOrderGroup group;

	private There(StockExchangeOrderGroup group) {
		this.group = group;
	}

	static boolean isAny(StockExchangeOrderGroup group) {
		return group != null && !group.isEmpty();
	}

	static There isA(StockExchangeOrderGroup group) {
		return new There(group);
	}

	boolean whichWasStartedNotSoonerThan35SecondsBeforeThis(
			StockExchangeOrder order) {
		if (group != null && !group.isEmpty()) {
			return group.getTime() >= order.getTime()
					- StockExchangeOrderGroup.maxTimeDelay;
		} else {
			return false;
		}
	}
}
