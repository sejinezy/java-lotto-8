package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.port.PickRandomNumbers;

public class LottoGenerator {

    private final PickRandomNumbers pickRandomNumbers;

    public LottoGenerator(PickRandomNumbers pickRandomNumbers) {
        this.pickRandomNumbers = pickRandomNumbers;
    }

    public LottoCart generateLottoCart(PurchaseAmount purchaseAmount) {
        List<Lotto> lottoCart = new ArrayList<>();
        int count = purchaseAmount.calculateLottoCount();
        for (int i = 0; i < count; i++) {
            lottoCart.add(generateLotto());
        }
        return new LottoCart(lottoCart);
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = pickRandomNumbers.pickRandomNumbers();
        return new Lotto(randomNumbers);
    }
}
