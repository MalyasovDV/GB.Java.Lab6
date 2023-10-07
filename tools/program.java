package tools;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tools.Person.genderTypes;;

public class program {


    public static void main(String[] args) {
         List<Person> personList = new ArrayList<>();
        personList.add(new Person("Александр", "Абрамов", 45, genderTypes.MALE, "al@evraz-group.ru", "89121023232"));
        personList.add(new Person("Роман", "Абромович", 44, genderTypes.MALE, "roma@chelsi.ru", "89121023234"));
        personList.add(new Person("Олег", "Дерипаска", 31, genderTypes.MALE, "oleg@rusal.ru", "89121024232"));
        personList.add(new Person("Борис", "Ротенберг", 21, genderTypes.MALE, "boris@kommersant.ru", "89121123232"));
        personList.add(new Person("Сергей", "Прохоров", 46, genderTypes.MALE, "serg@e-mobile.ru", "89121823232"));
        personList.add(new Person("Мария", "Портнова", 30, genderTypes.FEMALE, "masha@mail.ru", "89121023233"));
        personList.add(new Person("Дмитрий", "Медведев", 18, genderTypes.MALE, "dima@kremlin.ru", "89121222232"));
        personList.add(new Person("Екатерина", "Терентьева", 78, genderTypes.FEMALE, "ek@mail.ru", "89221023232"));
        personList.add(new Person("валентина", "Матвиенко", 65, genderTypes.FEMALE, "valya@sovfed.ru", "89134023232"));
        personList.add(new Person("Владимир", "Потанин", 14, genderTypes.MALE, "volodya@interros.ru", "89135023232"));
        personList.add(new Person("Вячеслав", "Макаров", 21, genderTypes.MALE, "slava@mail.ru", "89145023232"));
        personList.add(new Person("Владимир", "Иванов", 21, genderTypes.MALE, "vliv@mail.ru", "89156023232"));
        personList.add(new Person("Наталья", "ленская", 21, genderTypes.FEMALE, "nata@mail.ru", "89167023232"));
        personList.add(new Person("Елена", "Батурина", 21, genderTypes.FEMALE, "elena_bat@mail.ru", "89178023232"));
        personList.add(new Person("Евгений", "Пригожин", 21, genderTypes.MALE, "evgeniy@wagner-military.ru", "89189023232"));
        personList.add(new Person("Аркадий", "Ротенберг", 21, genderTypes.MALE, "arckasha@mail.ru", "89190023232"));
        personList.add(new Person("Сулейман", "Киримов", 21, genderTypes.MALE, "Sulya@mail.ru", "89109023232"));
        personList.add(new Person("Ева", "Березовская", 21, genderTypes.FEMALE, "eva@mail.ru", "89198023232"));
        personList.add(new Person("Дмитрий", "Собчак", 21, genderTypes.UNKNOWN, "dima@mail.ru", "89187023232"));
        personList.add(new Person("Дмитрий", "Собчак", 21, genderTypes.MALE, "dima@mail.ru", "89118023232"));
        personList.add(new Person("Ольга2", null, 21, genderTypes.FEMALE, "olga@mail.ru", null));
        personList.add(new Person("Ольга", "Навальная2", 21, genderTypes.FEMALE, "olga@mail.ru", "+7(917)6023232"));

        Set<Person> personSet = new HashSet<Person>(personList);
        // Здесь мы объединяем два дубликата экземпляра класса Person (например если в
        // каком то из экземпляров класса есть недостающее свойтсво)
        personSet.forEach(person -> {
            personList.forEach(item -> item.merge(person));
        });
        // Выводим Set
        for (Person person : personSet) {
            if (person.age >= 20) // Выводим если старше 20 лет (берем больше или равно, так как если 20 лет
                                  // наступило, то уже больше)
                System.out.println(person);

        }
    }
}

    