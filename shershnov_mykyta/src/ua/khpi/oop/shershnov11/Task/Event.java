package ua.khpi.oop.shershnov11.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * Клас, що представляє подію в планувальнику.
 */
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

    private Date date;
    private String time;
    private int duration;
    private String location;
    private String description;
    private List<String> participants = new ArrayList<>();
    private Event[] events;
    private SimpleDateFormat dateFormat;

    /**
     * Конструктор події.
     *
     * @param description Опис події.
     * @param date        Дата події.
     * @param location    Місце проведення події.
     * @param duration    Тривалість події у годинах.
     * @param time        Час події у хвилинах після півночі.
     */
    public Event(String description, Date date, String location, int duration, String time) {
        this.description = description;
        this.date = date;
        this.location = location;
        this.duration = duration;
        this.time = time;
        setDateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm"));
    }

    /**
     * Додає учасника до списку учасників події.
     *
     * @param participant Ім'я учасника.
     */
    public void addParticipant(String participant) {
        participants.add(participant);
    }

    /**
     * Видаляє учасника із списку учасників події.
     *
     * @param participant Ім'я учасника.
     */
    public void removeParticipant(String participant) {
        participants.remove(participant);
    }

    /**
     * Повертає список учасників події.
     *
     * @return Список учасників події.
     */
    public List<String> getParticipants() {
        return participants;
    }

    /**
     * Повертає дату події.
     *
     * @return Дата події.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Встановлює дату події.
     *
     * @param date Нова дата події.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Повертає тривалість події у годинах.
     *
     * @return Тривалість події.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Встановлює тривалість події у годинах.
     *
     * @param duration Нова тривалість події.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Повертає опис події.
     *
     * @return Опис події.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Встановлює опис події.
     *
     * @param description Новий опис події.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Повертає масив подій.
     *
     * @return Масив подій.
     */
    public Event[] getEvents() {
        return events;
    }

    /**
     * Встановлює масив подій.
     *
     * @param events Новий масив подій.
     */
    public void setEvents(Event[] events) {
        this.events = events;
    }

    /**
     * Повертає час події у хвилинах після півночі.
     *
     * @return Час події.
     */
    public String getTime() {
        return time;
    }

    /**
     * Встановлює час події у хвилинах після півночі.
     *
     * @param time Новий час події.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Повертає місце проведення події.
     *
     * @return Місце проведення події.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Встановлює місце проведення події.
     *
     * @param location Нове місце проведення події.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Повертає формат дати.
     *
     * @return Формат дати.
     */
    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    /**
     * Встановлює формат дати.
     *
     * @param dateFormat Новий формат дати.
     */
    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * Повертає рядок для виводу в файл.
     *
     * @return Рядок для виводу в файл.
     */
    public String toFileString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formattedDate = dateFormat.format(date);
        return description + "," + formattedDate + "," + location + "," + duration + "," + time;
    }

    /**
     * Створює об'єкт події із рядка файлу.
     *
     * @param fileString Рядок файлу.
     * @return Об'єкт події або null, якщо рядок некоректний.
     */
    public static Event fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        if (parts.length == 5) {
            try {
                String description = parts[0];
                Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(parts[1]);
                String location = parts[2];
                int duration = Integer.parseInt(parts[3]);
                String time = parts[4];

                return new Event(description, date, location, duration, time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Повертає рядок для виводу в консоль.
     *
     * @return Рядок для виводу в консоль.
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formattedDate = dateFormat.format(date);
        return "Опис: " + description + "\nДата: " + formattedDate + "\nМісце проведення: " + location
                + "\nТривалість: " + duration + " годин";
    }
    
    /**
     * Повертає кількість учасників події.
     *
     * @return Кількість учасників події.
     */
    public int getParticipantsCount() {
        return participants.size(); // Повертаємо розмір списку учасників
    }
}
