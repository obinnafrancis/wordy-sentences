package com.vlad.wordysentences.repositories;
import com.vlad.wordysentences.models.TimeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TimeLogRepository extends JpaRepository<TimeLog, Integer> {
    Optional<TimeLog> findTimeLogsByStaffIdAndAndCurrentDateEquals(int staffId, String currentDate);
}
