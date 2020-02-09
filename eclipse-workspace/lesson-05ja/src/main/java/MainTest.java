import ua.lviv.lgs.domain.Adress;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.AdressService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.AdressServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;

public class MainTest {
	public static void main(String[] args) {
		
		UserService userService=new UserServiceImpl();
		userService.create(new User("test@test4", "test3", "test3","test3"));
		
		AdressService adressService=new AdressServiceImpl();
		adressService.create(new Adress(79000,"Ukraine","Ivano-Frankivsk","Dolynskiy","Vygoda","DGalitskogo", 43,14));
		
		
		
	}

}
