package com.mvc;

import com.mvc.controller.Controller;
import com.mvc.model.MainModel;
import com.mvc.model.Model;
import com.mvc.view.EditUserView;
import com.mvc.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        
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
