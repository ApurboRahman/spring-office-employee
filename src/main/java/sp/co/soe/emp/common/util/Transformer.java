package sp.co.soe.emp.common.util;

public interface Transformer<S, T> {

    /**
     * transform from T type to S typ
     *
     * @param source
     * @return
     */
    T transform(S source);

    /**
     * transform back from S type to T type
     *
     * @param target
     * @return
     */
    S transformBack(T target);
}
