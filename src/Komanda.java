public class Komanda {
    public static void main(String[] args) {
        TV tv = new TV();
        Contoller pult = new Contoller(new StartComand(tv), new FinishComand(tv), new PauseComand(tv));
        pult.onClickStart();
        System.out.println("Деградирую перед теликом");
        pult.onClickPause();
        System.out.println("Пошёл посрать" + '\n'+ "Приёшёл");
        pult.onClickStart();
        System.out.println("Деградирую перед теликом дальше "+ '\n'+ " Всё, отупел, хватит");
        pult.onClickFinish();
        System.out.println("Ушёл спать");
    }
}
interface Comand{
    void execute();
}
class TV{
    void start(){
        System.out.println("Start TV");
    }
    void pause(){
        System.out.println("Pause TV");
    }
    void finish(){
        System.out.println("Finish TV");
    }
}
abstract class ComandTV{
    TV tv;
    public ComandTV(TV tv) {
        this.tv = tv;
    }
}
class StartComand extends ComandTV implements Comand{
    StartComand(TV tv){
        super(tv);
    }
    @Override
    public void execute() {
        tv.start();
    }
}
class PauseComand extends ComandTV implements Comand{
    PauseComand(TV tv){
        super(tv);
    }
    @Override
    public void execute() {
        tv.pause();
    }
}
class FinishComand extends ComandTV implements Comand{
    FinishComand(TV tv){
        super(tv);
    }
    @Override
    public void execute() {
        tv.finish();
    }
}

class Contoller{
    Comand stat;
    Comand finish;
    Comand stop;
    public Contoller(Comand stat, Comand finish, Comand stop) {
        this.stat = stat;
        this.finish = finish;
        this.stop = stop;
    }
    void onClickStart(){
        stat.execute();
    }
    void onClickPause(){
        stop.execute();
    }
    void onClickFinish(){
        finish.execute();
    }
}
