package CollectionLesson.HomeTask.List.Chat_Task;
/**
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */

import java.util.*;

public class ListChatRunner {
    public static void main(String[] args) {
        List<Chat> list = new ArrayList<>(List.of(
                new Chat("F_Chat_0", 450),
                new Chat("D_Chat_1", 500),
                new Chat("M_Chat_2", 1080),
                new Chat("A_Сhat_3", 1080),
                new Chat("B_Сhat_4", 1050),
                new Chat("C_Chat_5", 1121)));
        List<Chat> result = getAbove1000(list);
        System.out.println("Чаты, количество пользователей более 1000 пользователей(создание нового Листа. т.к. List.of - неизменяемый список) " + result);

        Collections.sort(result);
        System.out.println("Сортировка по убыванию количества пользователей: " + result);

        Collections.sort(result, new ExampleComparator());
        System.out.println("Сортировка по алфавиту: " + result);

        list.sort(Comparator.comparing(Chat::getName));
        System.out.println("Сортировка по умолчанию (по названию): " + list);

        getAbove(list);
        System.out.println("Удаление из списка через итератор: " + list);

        list.sort(Comparator.comparing(Chat::getQuantity).thenComparing(new ExampleComparator()));
        System.out.println("Сортировка по умолчанию по количеству пользователей и по алфафиту: " + list);
    }

    //Удаление чатов из списка через создание нового списка
    public static List<Chat> getAbove1000(List<Chat> chat) {
        List<Chat> result = new ArrayList<>();
        for (Chat value : chat) {
            if (value.getQuantity() > 1000) {
                result.add(value);
            }
        }
        return result;
    }
    // Удаление чатов через итератор(Денис говорил, что лучше через создание нового списка)

    public static void getAbove(List<Chat> list) {
        ListIterator<Chat> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Chat nextValue = listIterator.next();
            if (nextValue.getQuantity() < 1000) {
                listIterator.remove();
            }
        }
    }

    public static class ExampleComparator implements Comparator<Chat> {
        public int compare(Chat o1, Chat o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }


}


