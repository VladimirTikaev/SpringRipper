package quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Есть 3 типа аннотаций
/*
    SOURCE - видна только в сорсах. Когда мы скомпилируем в байткоде уже ее не будет. Пример @Override
    CLASS - попадает в байткод, но через reflection в runtime мы ее считать не сможем. Это default
    RUNTIME - можно считать через рефлексию
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int min();
    int max();
}
