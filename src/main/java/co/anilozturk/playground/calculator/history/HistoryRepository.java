package co.anilozturk.playground.calculator.history;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

    History save(History history);
}
