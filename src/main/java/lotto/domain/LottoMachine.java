package lotto.domain;

public class LottoMachine {
    private static final int UNIT_PRICE = 1000;

    private final int purchasePrice;

    public LottoMachine(String inputPrice) {
        validateType(inputPrice);
        validateRange(Integer.parseInt(inputPrice));
        validateUnit(Integer.parseInt(inputPrice));
        this.purchasePrice = Integer.parseInt(inputPrice);
    }

    private void validateType(String inputPrice) {
        if (!inputPrice.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE_TYPE.getMessage());
        }
    }

    private void validateRange(int inputPrice) {
        if (inputPrice < UNIT_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE_RANGE.getMessage());
        }
    }

    private void validateUnit(int inputPrice) {
        if (inputPrice % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE_UNIT.getMessage());
        }
    }

    public int getRound() {
        return purchasePrice / UNIT_PRICE;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
