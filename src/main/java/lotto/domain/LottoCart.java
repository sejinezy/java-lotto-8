package lotto.domain;

import java.util.Collections;
import java.util.List;

public record LottoCart(List<Lotto> lottoCart) {

    @Override
    public List<Lotto> lottoCart() {
        return Collections.unmodifiableList(lottoCart);
    }

}
