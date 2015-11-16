package ru.ifmo.mandrain.database;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Интерфейс класса для осуществления запросов к базе данных
 * @author Nadja K.
 */
public interface DBQueriesInterface {
     /**
     * Получение списка последних обновленных тасков (или списков тасков, пока неясно)
     * @param timeBoundary дата и время обновления/создания таска должны превосходить значение этого параметра даты и времени
     */
    public List<Task> getNewTasks(LocalDateTime timeBoundary);
}
