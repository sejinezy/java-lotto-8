package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.port.PickRandomNumbers;

public class LottoGenerator {

    private final PickRandomNumbers pickRandomNumbers;

    public LottoGenerator(PickRandomNumbers pickRandomNumbers) {
        this.pickRandomNumbers = pickRandomNumbers;
    }

    public LottoCart generateLottoList(PurchaseAmount purchaseAmount) {
        List<Lotto> lottoCart = new ArrayList<>();
        int amount = purchaseAmount.getAmount();
        int time = amount / 1000;
        for (int i = 0; i < time; i++) {
            lottoCart.add(generateLotto());
        }
        return new LottoCart(lottoCart);
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = pickRandomNumbers.pickRandomNumbers();
        return new Lotto(randomNumbers);
    }
}
