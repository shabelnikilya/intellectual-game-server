package server.game.models;

import lombok.Getter;

@Getter
public enum Topic {
    SPORT("Спорт","Вопросы связанные с миром спорта!"),
    POLITICS("Политика","Общие вопросы о политике!"),
    HISTORY("История", "Вопросы связанные с историей различных исторических личностей!"),
    ART("Искусство", "Мировое искусство!"),
    GEOGRAPHY("География","Вопросы связанные с расположением различных стран!");

    private final String name;
    private final String description;

    Topic(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
