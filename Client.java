public class Client {
    private String name;
    private int age;
    private String mail;
    private final int clientID;

    public Client(String name, int age, String mail, int clientID){
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getClientID() {
        return clientID;
    }

    public String toString(){
        return "Client: [name = " + name + ", age = " + age + ", mail = " + mail + ", ID = " + clientID + "].";
    }
}
