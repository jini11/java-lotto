package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void start() {
        LottoMachine lottoMachine = new LottoMachine(InputView.inputPurchasePrice());
        List<Lotto> lottoTickets = makeLotto(lottoMachine.getRound());
        UserNumber userNumber = new UserNumber(InputView.inputWinNumbers(), InputView.inputBonusNumbers());
        calculateRank(lottoTickets, userNumber);
    }

    private List<Lotto> makeLotto(int round) {
        LottoGenerator lottoGenerator = new LottoGenerator(round);
        List<Lotto> lottoTickets = lottoGenerator.getLottoTickets();

        OutputView.printTicketNumber(round);
        for (Lotto lotto : lottoTickets) {
            OutputView.printTickets(lotto.getNumbers());
        }
        return lottoTickets;
    }

    private void calculateRank(List<Lotto> lottoTickets, UserNumber userNumber) {
        RankCalculator rankCalculator = new RankCalculator(lottoTickets, userNumber);
        Map<Rank, Integer> map = rankCalculator.getRanks();
    }
}
