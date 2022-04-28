package com.company;

import java.util.List;

public abstract class UserAction {
    public boolean Action(User user, List<LibraryObject> list)
    {
        if(PermissionCheck(user, list))
            return ActionProper(user, list);
        OnFail(user, list);
        return false;
    }

    protected abstract boolean PermissionCheck(User user, List<LibraryObject> list);
    protected abstract boolean ActionProper(User user, List<LibraryObject> list);
    protected abstract boolean OnFail(User user, List<LibraryObject> list);
}

