public class Strategy {
    public static void main(String[] args) {
        Turist turist = new Turist();
        StrategyClient mozg = new StrategyClient();

        mozg.setStrategy(new ToGoNaPravo());
        mozg.executeStratrgy(turist);

        mozg.setStrategy(new ToGoNaLevo());
        mozg.executeStratrgy(turist);

        mozg.setStrategy(new ToGoNaHuy());
        mozg.executeStratrgy(turist);
    }
}
class Turist{
    String go = "иду";
    String kiss = "сосу";

    public String getGo() {
        return go;
    }

    public String getKiss() {
        return kiss;
    }
}
class StrategyClient{
    ToGo strategy;
    void setStrategy(ToGo strategy){
        this.strategy = strategy;
    }
    void executeStratrgy(Turist go){
        strategy.go(go);
    }
}
interface ToGo{
    public void go(Turist go);
}
class ToGoNaPravo implements ToGo{

    @Override
    public void go(Turist go) {
        System.out.println(go.getGo()+" на право");
    }
}
class ToGoNaLevo implements ToGo{

    @Override
    public void go(Turist go) {
        System.out.println(go.getGo()+" на лево");
    }
}
class ToGoNaHuy implements ToGo{

    @Override
    public void go(Turist go) {
        System.out.println(go.getKiss()+" хуй");
    }
}