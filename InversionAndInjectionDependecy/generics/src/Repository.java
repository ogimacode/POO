public interface Repository<K, T> {

    T findById(K id);
    void register(T newEmployee);

}
