package stock;

public class StockExchangeOrderUploader implements Runnable {

	private final StockExchangeOrderSource source;

	public StockExchangeOrderUploader(StockExchangeOrderSource source) {
		this.source = source;
	}

	private StockExchangeOrderGroup pendingGroup = null;

	public void setPendingGroup(StockExchangeOrderGroup group) {
		pendingGroup = group;
	}

	@Override
	public void run() {
		while (source.hasNext()) {
			final StockExchangeOrder order = source.next();
			if (order.isBelowRoundingLotLimit() && order.isOfClearingType27()) {
				if (There.isA(pendingGroup)
						.whichWasStartedNotSoonerThan35SecondsBeforeThis(order)) {
					Add.the(order).toThe(pendingGroup);
				} else {
					if (There.isAny(pendingGroup)) {
						Upload.the(pendingGroup);
					}
					Add.the(order).toThe(pendingGroup);
				}
			}else{
				Upload.the(order);
			}
		}
	}

}
