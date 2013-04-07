package stock;

public class Add {
	private final StockExchangeOrder order;

	private Add(StockExchangeOrder order) {
		this.order = order;
	}

	public static Add the(StockExchangeOrder order) {
		return new Add(order);
	}

	public void toThe(StockExchangeOrderGroup group) {
		group.add(order);
	}
}
