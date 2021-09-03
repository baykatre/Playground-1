package co.anilozturk.playground.calculator.history;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;

    public History saveHistory(History history){
        return historyRepository.save(history);
    }
}
