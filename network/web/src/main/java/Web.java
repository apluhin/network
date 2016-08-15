import net.ru.sbt.account.Account;
import net.ru.sbt.message.Message;
import net.ru.sbt.server.Server;

public class Web {

    Server server;
    Account account;

    public Web(Server server) {
        this.server = server;
    }

    public void sendMessageFromWeb(String idSrc, String idDst, String messageText) {
        Message message = new Message(idSrc, idDst, messageText);
        server.sendMessage(message);
    }

    public void checkMessageWeb(String id, String pass) {
        if (account == null) {
            account = server.signIn(id, pass);
        }
        server.checkMessage(account);
    }

    public void signUp(String id, String pass) {
        account = server.signUp(id, pass);
    }

    public void signIn(String id, String pass) {
        account = server.signIn(id, pass);
    }

    public void signOut() {
        server.signOut(account);
    }


}
