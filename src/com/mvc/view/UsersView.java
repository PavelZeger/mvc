package com.mvc.view;

import com.mvc.bean.User;
import com.mvc.controller.Controller;
import com.mvc.model.ModelData;

public class UsersView implements View {

    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()==false) {
            System.out.println("All users:");
        }
        else {
            System.out.println("All deleted users:");
        }
        for (User user : modelData.getUsers()) {
            System.out.println("\t" + user.toString());
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

}
