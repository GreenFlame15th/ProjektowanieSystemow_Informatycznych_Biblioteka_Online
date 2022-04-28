package com.company;

import java.util.List;

public class PrintDB extends UserAction {

    @Override
    protected boolean PermissionCheck(User user, List<LibraryObject> list) {

        if (SingletonUserDataBaseAccess.getInstance().getUsers().stream().filter(u -> u.getId() == user.getId()).toList().size() > 0)
            return true;
        else
            return false;
    }

    @Override
    protected boolean ActionProper(User user, List<LibraryObject> list) {
        for (LibraryObject l:
                SingletonDataBaseAccess.getInstance().getStock()) {
            System.out.println(l.toString()+"\n-------------");
        }
        return true;
    }

    @Override
    protected boolean OnFail(User user, List<LibraryObject> list) {
        System.out.println("User dose not exist");
        return false;
    }
}
