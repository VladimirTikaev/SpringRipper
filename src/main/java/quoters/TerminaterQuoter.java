package quoters;

import javax.annotation.PostConstruct;

public class TerminaterQuoter implements IQuoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminaterQuoter() {
        //System.out.println(repeat); выведет 0 т.к. сначало объект создается Java, a потом спринг его нстраивает
        // Т.е. если мы в конструкторе обращаемся к каким-то вещам, которые должен настроит спринг - их еще нет.
        // Поэтому напишим Init метод и сказать спрингу что это init метод аннотацией Postconstract
        System.out.println("Phase 1");
    }

    //Анотация не будет работать пока мы в xml файл не добавим бин постпроцессора для стандартных анотаций
    // но для каждой не хочется добавлять поэтому добавим весь пакет для всех сразу с помощью <context:annotation-config/>
    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }

    }
}
