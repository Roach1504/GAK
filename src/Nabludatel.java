import java.util.ArrayList;

public class Nabludatel {
    public static void main(String[] args) {
        ServerMessage muskul = new ServerMessage();
        muskul.addUserChat(new NormUser());
        muskul.addUserChat(new SchoolololoUser());
        muskul.setMessage(1, "Рэп-гавно!");
    }
}
interface Chat{
    void addUserChat(Users users);
    void dropUserChat(Users users);
    void pushMessage();
}
class ServerMessage implements Chat{
    int idUser;
    String message;
    ArrayList<Users> userList= new ArrayList<>();
    public void setMessage(int idUser, String message){
        this.idUser = idUser;
        this.message = message;
        pushMessage();
    }

    @Override
    public void addUserChat(Users user) {
        userList.add(user);
    }

    @Override
    public void dropUserChat(Users user) {
        userList.remove(user);
    }

    @Override
    public void pushMessage() {
        for(Users i: userList){
            i.getMessages(idUser, message);
        }
    }
}
interface Users{
    void getMessages(int idUser, String message);
}

class NormUser implements Users{
    @Override
    public void getMessages(int idUser, String message) {
        System.out.println("new message: "+ message + " от: "+ idUser +  "\n Ответ : Годно; от Нормального человека");
    }
}
class SchoolololoUser implements Users{
    @Override
    public void getMessages(int idUser, String message) {
        System.out.println("new message: "+ message + " от: "+ idUser +  "\n Ответ : МАМКУ ЕБАЛ!!1!1; от школяра");
    }
}