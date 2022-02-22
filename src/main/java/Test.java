import manager.BookAtableManager;
import manager.MenuManager;
import manager.UserManager;
import model.Menu;
import model.User;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        BookAtableManager bt=new BookAtableManager();
        UserManager userManager=new UserManager();
        MenuManager menuManager=new MenuManager();
        List<User> listBT= userManager.getAll();
//        userManager.delete(6);

//        System.out.println(menuManager.getById(1));
User user=new User();
        user.setName("Elen");
        user.setSurname("Zakaryan");
        user.setEmail("elen");
        user.setPassword("elen");
        userManager.create(user);
        for (User b:listBT) {
            System.out.println(b);
        }
    }
}
