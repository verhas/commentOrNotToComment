package stock;

public interface StockExchangeOrder extends TimedStockExchangeEntity,
		Uploadable {

	boolean isOfClearingType27();

	boolean isBelowRoundingLotLimit();

}
