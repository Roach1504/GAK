public class Dekorator {
    public static void main(String[] args) {
        User skilet = new Skilet();
        skilet = new Luchnik(skilet);
        skilet = new Arbletchik(skilet);
        System.out.println(skilet.getName() + " damag:" + skilet.damag());
    }
}
abstract class User{
    String name = "not name";

    public String getName() {
        return name;
    }
    public abstract double damag();
}
class Pihota extends User{
    public Pihota() {
        name = "pihota";
    }

    @Override
    public double damag() {
        return 1.5;
    }
}
class Skilet extends User{
    public Skilet() {
        name = "Skilet";
    }

    @Override
    public double damag() {
        return 0.9;
    }
}
class Animals extends User{
    public Animals() {
        name = "animals";
    }

    @Override
    public double damag() {
        return 0.5;
    }
}
abstract class CategDekor extends User{
    protected User user;
    public abstract String getName();
}
class Luchnik extends CategDekor{
    public Luchnik(User user) {
        this.user = user;
    }
    @Override
    public double damag() {
        return user.damag()+0.5;
    }

    @Override
    public String getName() {
        return user.getName() + " c луком";
    }
}
class Arbletchik extends CategDekor{
    public Arbletchik(User user) {
        this.user = user;
    }
    @Override
    public double damag() {
        return user.damag()+1;
    }

    @Override
    public String getName() {
        return user.getName() + " с арбалетом";
    }
}