package nadja.sheduler;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Интерфейс класса для осуществления запросов к базе данных
 * @author Nadja K.
 */
public interface DBQueriesInterface {
     /**
     * Получение списка последних обновленных списков тасков (по getDateChange())
     * @param timeBoundary дата и время обновления/создания списка тасков должны превосходить значение этого параметра даты и времени
     */
    public List<TaskList> getNewTasks(LocalDateTime timeBoundary);
}
