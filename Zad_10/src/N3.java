import java.util.Scanner;
import N3_class.Address;
import N3_class.Contact;
import N3_class.ContactBook;
import N3_class.Email;
import N3_class.Phone;
import N3_class.SocialNetworkContact;

public class N3 {
    private static ContactBook<Phone> friendsContactBook = new ContactBook<>();
    private static ContactBook<Email> colleaguesContactBook = new ContactBook<>();
    private static ContactBook<SocialNetworkContact> classmatesContactBook = new ContactBook<>();
    private static ContactBook<Address> relativesContactBook = new ContactBook<>();

    public static void main(String[] args) {
        fillBooks();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Сегодня Новый Год! 1 - Отправить поздравление, 0 - Напомнить позднее");
            int mainCommand = scanner.nextInt();
            if (mainCommand == 1) {
                System.out.println("Какую книгу контактов открыть?");
                System.out.println("1 - Друзья, 2 - Коллеги, 3 - Одногруппники, 4 - Родственники");

                int bookIndex = scanner.nextInt();
                ContactBook<? extends Contact> selectedBook = null;

                switch (bookIndex) {
                    case 1:
                        selectedBook = friendsContactBook;
                        break;
                    case 2:
                        selectedBook = colleaguesContactBook;
                        break;
                    case 3:
                        selectedBook = classmatesContactBook;
                        break;
                    case 4:
                        selectedBook = relativesContactBook;
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                        continue;  // возвращаемся в начало цикла while
                }

                selectedBook.printList();

                System.out.println("Кого вы хотите поздравить? Введите имя:");
                String name = scanner.next();
                selectedBook.congratulate(name);

            } else if (mainCommand == 0) {
                break;
            }
        }
        System.out.println("До следующего Нового года!");
    }

    private static void fillBooks() {
        friendsContactBook.addContact(new Phone("Иван", "+7-909-000-11-22"));
        friendsContactBook.addContact(new Phone("Маша", "+7-999-555-11-22"));
        friendsContactBook.addContact(new Phone("Кирилл", "+7-979-698-00-22"));

        colleaguesContactBook.addContact(new Email("Александр", "sasha@sasha.ru"));
        colleaguesContactBook.addContact(new Email("Павел", "pasha@pasha.ru"));
        colleaguesContactBook.addContact(new Email("Олег", "oleg@oleg.ru"));

        classmatesContactBook.addContact(new SocialNetworkContact("Оля", "НаСвязи", "olya"));
        classmatesContactBook.addContact(new SocialNetworkContact("Женя", "Фотопризма", "zhenya"));

        relativesContactBook.addContact(new Address("Бабуля", "Москва", "Тверская, д.8"));
        relativesContactBook.addContact(new Address("Дедуля", "Воронеж", "Ленина, д.10"));
    }
}