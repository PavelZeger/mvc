package com.mvc;

/*
Эта задача будет на паттерн MVC - Model-View-Controller.
Мы вместе построим архитектуру используя MVC. Разберись подробно, что и почему нужно реализовывать так, как я тебе покажу.
Прочти дополнительную литературу, которую дает профессор в конце уровня.
Тебя, скорее всего, на собеседовании спросят об этом паттерне либо дадут задание, в котором нужно будет его реализовать.

Итак...
У тебя есть два пакета: bean, содержащий единственный класс User, и dao, в котором хранится эмуляция базы данных в пакете mock и UserDao. UserDao - это уровень ДАО, т.е. уровень доступа к базе.
В нем размещают различные методы по сохранению и получению объектов из базы данных.
В реальном приложении строку private DataSource dataSource = DataSource.getInstance() не встретить.
Я реализовал DataSource в виде синглтона. В действительности, у тебя будет что-то такое:
@Autowired
private DataSource dataSource;

Фреймворк, которым ты будешь пользоваться, сам создаст объект базы данных и инициализирует поле dataSource.

Запомни, с ДАО уровнем работают сервисы. Никакие другие классы в ДАО не лезут. В сервисах описана бизнес логика.
Сервисы забирают данные из базы используя ДАО, обрабатывают их и отдают тому, кто данные запросил.
Однако не все данные хранятся в базе. Например, залогиненый пользователь будет храниться в специальном объекте - Модели.
Объект, который содержит в себе данные, необходимые для отображения информации на клиенте, называется Моделью.
Также этот объект Модель содержит ссылки на все необходимые сервисы.
Если данных для отображения очень много, то их выделяют в отдельный объект.

Напишем приложение, которое будет показывать список пользователей и что-то делать с ними, например, обновлять их данные и удалять.
 */

import com.mvc.controller.Controller;
import com.mvc.model.MainModel;
import com.mvc.model.Model;
import com.mvc.view.EditUserView;
import com.mvc.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        //Model com.javarush.com.javarush.model = new FakeModel();
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126);
        editUserView.fireEventUserDeleted(124);;
        editUserView.fireEventUserChanged("Pavel", 125, 1);
        usersView.fireEventShowDeletedUsers();
    }
}