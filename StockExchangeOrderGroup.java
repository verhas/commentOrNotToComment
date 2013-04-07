package stock;

public interface StockExchangeOrderGroup extends TimedStockExchangeEntity, Uploadable {
	
	int maxTimeDelay = 35;
	
	void upload();

	void add(StockExchangeOrder se);
	
	boolean isEmpty();
	
}
