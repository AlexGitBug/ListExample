package CollectionLesson.HomeTask.List.Chat_Task;

import java.util.*;

/**
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей”
 * будет список объектов типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор), имя и возраст.
 * Задача:
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 *
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */
public class UserRunner {

    public static void main(String[] args) {
        List<Chat> list = new ArrayList<>(Arrays.asList(
                new Chat("F_Chat_0", new ArrayList<User>(Arrays.asList(new User(1, "Boris", 16), new User(2, "Kate", 14)))),
                new Chat("D_Chat_1", new ArrayList<User>(Arrays.asList(new User(4,"Nick", 15), new User(4,"Vasili", 17)))),
                new Chat("M_Chat_2", new ArrayList<User>(Arrays.asList(new User(5,"Alesia", 18), new User(6,"Alex", 19)))),
                new Chat("A_Сhat_3", new ArrayList<User>(Arrays.asList(new User(7,"Ivan", 20), new User(8,"Sv", 20)))),
                new Chat("B_Сhat_4", new ArrayList<User>(Arrays.asList(new User(9,"Petr", 22), new User(10,"Dima", 21)))),
                new Chat("C_Chat_5", new ArrayList<User>(Arrays.asList(new User(11,"Klava", 22), new User(12,"Vitia", 21))))));
        List<User> preobrazovatel = preobrazovatel(list);
        System.out.println(preobrazovatel);
        List<User> users = preobrazovatel1(list);
        System.out.println(users);
        double averageAge = getAverageAge(users);
        System.out.println(averageAge);
        System.out.println("через итератор " + averageIterator(users));

    }
    public static double averageIterator(List<User> list) {
        double average = 0;
        ListIterator<User> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            User nextValue = listIterator.next();
            average = (average + nextValue.getAge()) / list.size();
        }
        return average;
        }


    public static double getAverageAge (List<User> list) {
        double average = 0;
        for (User user : list) {
            if (user.getAge() < 18) {
                average = (average + user.getAge()) / list.size();
            }
        }
        return average;
    }

    public static List<User> preobrazovatel (List<Chat> list) {

        List<User> result1 = new ArrayList<>();
        List<User> result = new ArrayList<>();

        for (Chat chat : list) {
            List<User> list1 = chat.getList();
            result1.addAll(list1);
        }
        for (User user : result1) {
           if (user.getAge() >= 18){
               result.add(user);
           }
        }
        return result;
    }
    public static List<User> preobrazovatel1 (List<Chat> list) {

        List<User> result1 = new ArrayList<>();
        List<User> result = new ArrayList<>();

        for (Chat chat : list) {
            List<User> list1 = chat.getList();
            result1.addAll(list1);
        }
        for (User user : result1) {
            if (user.getAge() < 18){
                result.add(user);
            }
        }
        return result;
    }
}
